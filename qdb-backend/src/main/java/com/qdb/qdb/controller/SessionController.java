package com.qdb.qdb.controller;

import com.qdb.qdb.dto.UserLoginDTO;
import com.qdb.qdb.dto.UsernameDTO;
import com.qdb.qdb.entity.User;
import com.qdb.qdb.service.SessionService;
import com.qdb.qdb.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.qdb.qdb.service.SessionService.COOKIE_NAME;

@RestController
@RequestMapping(path = "/api/session")
public class SessionController {
    @Autowired
    private final SessionService sService;
    @Autowired
    private final UserService uService;

    public SessionController(SessionService sService, UserService uService) {
        this.sService = sService;
        this.uService = uService;
    }

    @PostMapping
    public ResponseEntity<?> login(HttpServletRequest request, HttpServletResponse response, @RequestBody UserLoginDTO loginCredentials) {
        User u = sService.checkCookieValidity(request.getCookies(), response);
        if (u != null) {
            return ResponseEntity.status(HttpStatus.OK).body(new UsernameDTO(u.getUserName()));
        }
        u = uService.authenticate(loginCredentials.getUsername(), loginCredentials.getPassword());
        if (u != null) {
            char[] sessionId = sService.createSession(u);
            Cookie c = new Cookie(COOKIE_NAME, new String(sessionId));
            c.setHttpOnly(true);
            c.setPath("/");
            c.setAttribute("SameSite", "None");
            c.setSecure(true);
            response.addCookie(c);
            return ResponseEntity.status(HttpStatus.OK).body(new UsernameDTO(u.getUserName()));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PostMapping(path = "/logout")
    public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response) {
        User u = sService.checkCookieValidity(request.getCookies(), response);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        for (Cookie c : request.getCookies()) {
            if (c.getName().equals(COOKIE_NAME)) {
                sService.invalidateCookie(c, response);
                break;
            }
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
