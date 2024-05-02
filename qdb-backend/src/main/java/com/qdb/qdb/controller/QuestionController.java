package com.qdb.qdb.controller;

import com.qdb.qdb.dto.QuestionDTO;
import com.qdb.qdb.dto.QuestionDTOWithCount;
import com.qdb.qdb.dto.QuestionModifyDTO;
import com.qdb.qdb.entity.Question;
import com.qdb.qdb.entity.User;
import com.qdb.qdb.exception.NoRightException;
import com.qdb.qdb.exception.QuestionNotFoundException;
import com.qdb.qdb.exception.UserNotFoundException;
import com.qdb.qdb.service.QuestionService;
import com.qdb.qdb.service.SessionService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "question")
public class QuestionController {
    @Autowired
    private final QuestionService service;
    @Autowired
    private final SessionService sService;

    public QuestionController(QuestionService service, SessionService sService) {
        this.service = service;
        this.sService = sService;
    }

    /**
     * Responds with Question metadata of Question of the given ID
     *
     * @param id
     * @return
     */
    @GetMapping(path = "{id}")
    public ResponseEntity<?> getQuestion(@PathVariable long id, HttpServletRequest request, HttpServletResponse response) {
        User u = sService.checkCookieValidity(request.getCookies(), response);
        Question result = service.getById(id);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        boolean editingrights = false;
        if (u != null) {
            try {
                editingrights = service.checkEditingRights(result, u, true);
            } catch (NoRightException ignored) {
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(QuestionDTO.toDto(result, editingrights, u != null && u.getFavorites().contains(result)));
    }

    /**
     * Responds with markdown body text of Question of the given ID
     *
     * @param id
     * @return
     */
    @GetMapping(path = "/body/{id}", produces = MediaType.TEXT_MARKDOWN_VALUE)
    public ResponseEntity<?> getQuestionBody(@PathVariable long id) {
        Question result = service.getById(id);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_MARKDOWN_VALUE + ";charset=UTF8").body(result.getMdbody());
    }

//    /**
//     * Updates tags of Question of the given ID. Requires a valid session
//     *
//     * @param id
//     * @param tags
//     * @param request
//     * @param response
//     * @return
//     */
//    @PutMapping(path = "{id}/tags")
//    public ResponseEntity<?> updateTags(@PathVariable long id, @RequestBody TagDTO tags, HttpServletRequest request, HttpServletResponse response) {
//        User u = sService.checkCookieValidity(request.getCookies(), response);
//        if (u == null) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//        Question result = service.getById(id);
//        if (result == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//        if (tags == null) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//        }
//        try {
//            service.updateTags(result, tags.getTags(), u);
//        } catch (NoRightException e) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }

    @PostMapping
    public ResponseEntity<?> addQuestion(HttpServletRequest request, HttpServletResponse response, @RequestBody QuestionModifyDTO q) {
        User u = sService.checkCookieValidity(request.getCookies(), response);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        try {
            Question newQuestion = service.createQuestion(q, u);
            return ResponseEntity.status(HttpStatus.CREATED).body(newQuestion.getId());
        } catch (NoRightException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You don't have rights to create a new question");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<?> updateQuestion(HttpServletRequest request, HttpServletResponse response, @PathVariable long id, @RequestBody QuestionModifyDTO q) {
        User u = sService.checkCookieValidity(request.getCookies(), response);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        try {
            service.updateQuestion(id, q, u);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (NoRightException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You don't have rights to update this question");
        } catch (QuestionNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deleteQuestion(HttpServletRequest request, HttpServletResponse response, @PathVariable long id) {
        User u = sService.checkCookieValidity(request.getCookies(), response);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        try {
            service.deleteQuestion(id, u);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (NoRightException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You don't have rights to delete this question");
        } catch (QuestionNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(path = "/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<?> questionToPdf(HttpServletRequest request, HttpServletResponse response, @RequestParam List<Long> id) {
        User u = sService.checkCookieValidity(request.getCookies(), response);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        try {
            byte[] result = service.exportToPdf(id, u);
            if (result == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
            return ResponseEntity.status(HttpStatus.OK).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE).header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=export.pdf").body(result);
        } catch (NoRightException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You don't have rights to export a question to PDF");
        } catch (QuestionNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /**
     * Provides a flexible endpoint for querying Questions. All criteria are interpreted with AND connection
     *
     * @param pageNumber The number of page in case of pagination
     * @param pageSize   The size of a page in case of pagination
     * @param search     Search term
     * @param searchType Case-insensitive, see QuestionService.SearchType
     * @param tags       List of tags to search for
     * @return
     */
    @GetMapping
    public ResponseEntity<?> getQuestions(HttpServletRequest request, HttpServletResponse response, @RequestParam(required = false) Integer pageNumber, @RequestParam(required = false) Integer pageSize, @RequestParam(required = false) String search, @RequestParam(required = false) String searchType, @RequestParam(required = false) List<String> tags, @RequestParam(required = false) String username, @RequestParam(required = false) Boolean reportedOnly) {
        User u = sService.checkCookieValidity(request.getCookies(), response);
        List<Question> results = new ArrayList<>();
        // filtering
        if (search == null || search.isEmpty()) {
            results.addAll(service.getQuestions());
        } else {
            List<Question> searchResults = service.search(search, searchType);
            if (searchResults == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            results.addAll(searchResults);
        }
        if (tags != null && !tags.isEmpty()) {
            results = service.filterByTagsAnd(results, tags);
        }
        if (username != null) {
            try {
                results = service.findForUser(username, results);
            } catch (NoRightException ignored) {
            } catch (UserNotFoundException e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            }
        }
        if (reportedOnly != null && reportedOnly) {
            results = results.stream().filter(Question::isReported).toList();
        }
        int count = results.size();
        // formatting
        if (pageNumber == null || pageSize == null) {
            return ResponseEntity.status(HttpStatus.OK).body(new QuestionDTOWithCount(count, results.stream().map(q -> {
                boolean editingrights = false;
                boolean isInFavorites = false;
                if (u != null) {
                    try {
                        editingrights = service.checkEditingRights(q, u, true);
                    } catch (NoRightException ignored) {
                    }
                    isInFavorites = u.getFavorites().contains(q);
                }
                return QuestionDTO.toDto(q, editingrights, isInFavorites);
            }).toList()));
        }
        List<Question> resultsPaged = service.getQuestionPagedFromList(pageNumber, pageSize, results);
        if (resultsPaged == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(new QuestionDTOWithCount(count, resultsPaged.stream().map(q -> {
            boolean editingrights = false;
            boolean isInFavorites = false;
            if (u != null) {
                try {
                    editingrights = service.checkEditingRights(q, u, true);
                } catch (NoRightException ignored) {
                }
                isInFavorites = u.getFavorites().contains(q);
            }
            return QuestionDTO.toDto(q, editingrights, isInFavorites);
        }).toList()));
    }

    @PostMapping("report/{id}")
    public ResponseEntity<?> reportQuestion(HttpServletRequest request, HttpServletResponse response, @PathVariable long id) {
        User u = sService.checkCookieValidity(request.getCookies(), response);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        try {
            service.reportQuestion(id, u);
        } catch (QuestionNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Question not found");
        } catch (NoRightException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You don't have rights to report a question");
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("unreport/{id}")
    public ResponseEntity<?> unReportQuestion(HttpServletRequest request, HttpServletResponse response, @PathVariable long id) {
        User u = sService.checkCookieValidity(request.getCookies(), response);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        try {
            service.unReportQuestion(id, u);
        } catch (QuestionNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Question not found");
        } catch (NoRightException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You don't have rights to unreport a question");
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("favorite/{id}")
    public ResponseEntity<?> addToFavoritesCurrentUser(HttpServletRequest request, HttpServletResponse response, @PathVariable long id) {
        User u = sService.checkCookieValidity(request.getCookies(), response);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        try {
            service.addToFavorites(id, u);
        } catch (QuestionNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Question not found");
        } catch (NoRightException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You don't have rights to add a question to favorites");
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("unfavorite/{id}")
    public ResponseEntity<?> removeFromFavoritesCurrentUser(HttpServletRequest request, HttpServletResponse response, @PathVariable long id) {
        User u = sService.checkCookieValidity(request.getCookies(), response);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        try {
            service.removeFromFavorites(id, u);
        } catch (QuestionNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Question not found");
        } catch (NoRightException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You don't have rights to remove a question from favorites");
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("favorites")
    public ResponseEntity<?> removeFromFavoritesCurrentUser(HttpServletRequest request, HttpServletResponse response) {
        User u = sService.checkCookieValidity(request.getCookies(), response);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(new QuestionDTOWithCount(u.getFavorites().stream().map(q -> {
            boolean editingRights = false;
            try {
                editingRights = service.checkEditingRights(q, u, true);
            } catch (NoRightException ignored) {
            }
            return QuestionDTO.toDto(q, editingRights, u.getFavorites().contains(q));
        }).toList()));
    }

    @GetMapping("random")
    public ResponseEntity<?> randomQuestions(HttpServletRequest request, HttpServletResponse response, @RequestParam(required = false) Integer count) {
        User u = sService.checkCookieValidity(request.getCookies(), response);
        final boolean loggedout = u == null;
        if (count == null) {
            count = 1;
        } else if (count < 1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please enter a number greater than 0");
        }
        return ResponseEntity.status(HttpStatus.OK).body(new QuestionDTOWithCount(service.getRandomQuestions(count).stream().map(q -> {
            boolean editingRights = false;
            boolean favorites = false;
            if (!loggedout) {
                try {
                    editingRights = service.checkEditingRights(q, u, true);
                    favorites = u.getFavorites().contains(q);
                } catch (NoRightException ignored) {
                }
            }
            return QuestionDTO.toDto(q, editingRights, favorites);
        }).toList()));
    }

    @PostMapping(value = "json", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadFromJson(HttpServletRequest request, HttpServletResponse response, @RequestParam("file") MultipartFile file) {
        User u = sService.checkCookieValidity(request.getCookies(), response);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        try {
            service.parseFromJson(u, file.getBytes());
        } catch (NoRightException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You don't have the rights to upload from JSON");
        } catch (ParseException | ClassCastException | IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This is not a valid JSON");
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
