package com.qdb.qdb.controller;

import com.qdb.qdb.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "tags")
public class TagController {
    @Autowired
    private final TagService service;

    public TagController(TagService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> getTagsWithQuestionCount() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getTagsWithQuestionCount());
    }
}
