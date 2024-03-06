package com.qdb.qdb.controller;

import com.qdb.qdb.dto.UserLoginDTO;
import com.qdb.qdb.entity.User;
import com.qdb.qdb.service.SessionService;
import com.qdb.qdb.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "user")
public class UserController {
    @Autowired
    private final UserService service;
    @Autowired
    private final SessionService sService;

    public UserController(UserService service, SessionService sService) {
        this.service = service;
        this.sService = sService;
    }

    @PostMapping
    public ResponseEntity<?> registration(HttpServletRequest request, HttpServletResponse response, @RequestBody UserLoginDTO userCredentials) {
        if (sService.checkCookieValidity(request.getCookies(), response) != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Log out first");
        }
        if (service.createUser(userCredentials.getUsername(), userCredentials.getPassword()) == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username taken");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Your registration request was sent to the admins");
    }

    @DeleteMapping(path = "/{username}")
    public ResponseEntity<?> deleteUser(HttpServletRequest request, HttpServletResponse response, @PathVariable(required = false) String username) {
        User u = sService.checkCookieValidity(request.getCookies(), response);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        if (username != null) {
            boolean result = service.deleteUserByAdmin(username, u);
            if (!result) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You're either not an admin or the given user doesn't exist");
            }
        }
        service.deleteUser(u.getId());
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
