package com.qdb.qdb.controller;

import com.qdb.qdb.entity.User;
import com.qdb.qdb.exception.NoRightException;
import com.qdb.qdb.service.LogService;
import com.qdb.qdb.service.SessionService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "log")
public class LogController {
    @Autowired
    private final LogService service;
    @Autowired
    private final SessionService sService;

    public LogController(LogService service, SessionService sService) {
        this.service = service;
        this.sService = sService;
    }

    @GetMapping
    public ResponseEntity<?> getLogs(HttpServletRequest request, HttpServletResponse response, @RequestParam(required = false) Integer pageSize, @RequestParam(required = false) Integer pageIndex) {
        User u = sService.checkCookieValidity(request.getCookies(), response);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.getLogEntries(u, pageSize, pageIndex));
        } catch (NoRightException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
