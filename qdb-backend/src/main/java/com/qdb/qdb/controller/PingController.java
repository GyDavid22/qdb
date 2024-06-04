package com.qdb.qdb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ping")
public class PingController {
    public ResponseEntity<?> ping() {
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
