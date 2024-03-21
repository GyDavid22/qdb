package com.qdb.qdb.controller;

import com.qdb.qdb.dto.QuestionDTO;
import com.qdb.qdb.dto.QuestionDTOWithCount;
import com.qdb.qdb.dto.TagDTO;
import com.qdb.qdb.entity.Question;
import com.qdb.qdb.entity.User;
import com.qdb.qdb.exception.NoRightException;
import com.qdb.qdb.service.QuestionService;
import com.qdb.qdb.service.SessionService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.status(HttpStatus.OK).body(QuestionDTO.toDto(result, editingrights));
    }

    /**
     * Responds with markdown body text of Question of the given ID
     *
     * @param id
     * @return
     */
    @GetMapping(path = "/body/{id}")
    public ResponseEntity<?> getQuestionBody(@PathVariable long id) {
        Question result = service.getById(id);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_MARKDOWN_VALUE + ";charset=UTF8").body(result.getMdbody());
    }

    /**
     * Updates tags of Question of the given ID. Requires a valid session
     *
     * @param id
     * @param tags
     * @param request
     * @param response
     * @return
     */
    @PutMapping(path = "{id}/tags")
    public ResponseEntity<?> updateTags(@PathVariable long id, @RequestBody TagDTO tags, HttpServletRequest request, HttpServletResponse response) {
        User u = sService.checkCookieValidity(request.getCookies(), response);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Question result = service.getById(id);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        if (tags == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        try {
            service.updateTags(result, tags.getTags(), u);
        } catch (NoRightException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
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
    public ResponseEntity<?> getQuestions(HttpServletRequest request, HttpServletResponse response, @RequestParam(required = false) Integer pageNumber, @RequestParam(required = false) Integer pageSize, @RequestParam(required = false) String search, @RequestParam(required = false) String searchType, @RequestParam(required = false) List<String> tags) {
        User u = sService.checkCookieValidity(request.getCookies(), response);
        List<Question> results = new ArrayList<>();
        // filtering
        if (search == null) {
            results.addAll(service.getQuestions());
        } else {
            List<Question> searchResults = service.search(search, searchType);
            if (searchResults == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            results.addAll(searchResults);
        }
        if (tags != null) {
            results = service.filterByTags(results, tags);
        }
        int count = results.size();
        // formatting
        if (pageNumber == null || pageSize == null) {
            return ResponseEntity.status(HttpStatus.OK).body(new QuestionDTOWithCount(count, results.stream().map(q -> {
                boolean editingrights = false;
                if (u != null) {
                    try {
                        editingrights = service.checkEditingRights(q, u, true);
                    } catch (NoRightException ignored) {
                    }
                }
                return QuestionDTO.toDto(q, editingrights);
            }).toList()));
        }
        List<Question> resultsPaged = service.getQuestionPagedFromList(pageNumber, pageSize, results);
        if (resultsPaged == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(new QuestionDTOWithCount(count, resultsPaged.stream().map(q -> {
            boolean editingrights = false;
            if (u != null) {
                try {
                    editingrights = service.checkEditingRights(q, u, true);
                } catch (NoRightException ignored) {
                }
            }
            return QuestionDTO.toDto(q, editingrights);
        }).toList()));
    }
}
