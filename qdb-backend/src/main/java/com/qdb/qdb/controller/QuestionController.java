package com.qdb.qdb.controller;

import com.qdb.qdb.dto.QuestionDTO;
import com.qdb.qdb.dto.TagDTO;
import com.qdb.qdb.entity.Question;
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
@RequestMapping(path = "/api/question")
public class QuestionController {
    @Autowired
    private final QuestionService service;
    @Autowired
    private final SessionService sService;

    public QuestionController(QuestionService service, SessionService sService) {
        this.service = service;
        this.sService = sService;
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<?> getQuestion(@PathVariable long id) {
        Question result = service.getById(id);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(QuestionDTO.toDto(result));
    }

    @GetMapping(path = "/body/{id}")
    public ResponseEntity<?> getQuestionBody(@PathVariable long id) {
        Question result = service.getById(id);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_MARKDOWN_VALUE + ";charset=UTF8").body(result.getMdbody());
    }

    @PutMapping(path = "{id}/tags")
    public ResponseEntity<?> updateTags(@PathVariable long id, @RequestBody TagDTO tags, HttpServletRequest request, HttpServletResponse response) {
        if (sService.checkCookieValidity(request.getCookies(), response) == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Question result = service.getById(id);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        if (tags == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        service.updateTags(result, tags.getTags());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public ResponseEntity<?> getQuestions(@RequestParam(required = false) Integer pageNumber, @RequestParam(required = false) Integer pageSize, @RequestParam(required = false) String search, @RequestParam(required = false) String searchType, @RequestParam(required = false) List<String> tags) {
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
        // formatting
        if (pageNumber == null || pageSize == null || pageNumber < 0 || pageSize < 1) {
            return ResponseEntity.status(HttpStatus.OK).body(results.stream().map(QuestionDTO::toDto));
        }
        List<Question> resultsPaged = service.getQuestionPagedFromList(pageNumber, pageSize, results);
        if (resultsPaged == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(resultsPaged.stream().map(QuestionDTO::toDto));
    }

    @GetMapping(path = "count")
    public ResponseEntity<?> getNumOfQuestions() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getNumberOfQuestions());
    }
}