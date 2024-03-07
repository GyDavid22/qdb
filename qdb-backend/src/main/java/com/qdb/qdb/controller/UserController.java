package com.qdb.qdb.controller;

import com.qdb.qdb.dto.SetPasswordDTO;
import com.qdb.qdb.dto.SetRankDTO;
import com.qdb.qdb.dto.UserDTO;
import com.qdb.qdb.dto.UserLoginDTO;
import com.qdb.qdb.entity.ProfilePicture;
import com.qdb.qdb.entity.User;
import com.qdb.qdb.exception.NoRightException;
import com.qdb.qdb.service.SessionService;
import com.qdb.qdb.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping(path = {"", "/{username}"})
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
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        service.deleteUser(u.getUserName());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public ResponseEntity<?> getCurrentUserData(HttpServletRequest request, HttpServletResponse response) {
        User u = sService.checkCookieValidity(request.getCookies(), response);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(UserDTO.toDTO(u));
    }

    @GetMapping(path = "/{username}")
    public ResponseEntity<?> getUserData(HttpServletRequest request, HttpServletResponse response, @PathVariable String username) {
        User u = sService.checkCookieValidity(request.getCookies(), response);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        User res;
        try {
            res = service.getByUserName(username, u);
        } catch (NoRightException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        if (res == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(UserDTO.toDTO(res));
    }

    @GetMapping(path = "/all")
    public ResponseEntity<?> getAllUser(HttpServletRequest request, HttpServletResponse response) {
        User u = sService.checkCookieValidity(request.getCookies(), response);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        List<User> res;
        try {
            res = service.getAllUsers(u);
        } catch (NoRightException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(res.stream().map(UserDTO::toDTO));
    }

    @PostMapping(path = "/rank/{username}")
    public ResponseEntity<?> setRank(HttpServletRequest request, HttpServletResponse response, @PathVariable String username, @RequestBody SetRankDTO rank) {
        User u = sService.checkCookieValidity(request.getCookies(), response);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        try {
            User res = service.getByUserName(username, u);
            if (res == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            service.setRank(u, res, rank.getRank());
        } catch (NoRightException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You don't have permission to set one's rank");
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /**
     * Endpoint to change one's password. If username not provided, user changes its own password, otherwise it expects an admin changing another user's password
     *
     * @param request
     * @param response
     * @param username
     * @param password
     * @return
     */
    @PostMapping(path = {"/password", "/password/{username}"})
    public ResponseEntity<?> setPassword(HttpServletRequest request, HttpServletResponse response, @PathVariable(required = false) String username, @RequestBody SetPasswordDTO password) {
        User u = sService.checkCookieValidity(request.getCookies(), response);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        if (username == null) {
            char[] sessionId = sService.getCurrentSessionId(request.getCookies(), response);
            boolean result = service.changePassword(u, password.getOldPassword(), password.getNewPassword(), sessionId);
            if (!result) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Incorrect current password");
            }
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        try {
            User res = service.getByUserName(username, u);
            if (res == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            service.setPasswordByAdmin(u, res, password.getNewPassword());
        } catch (NoRightException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You don't have permission to change one's password");
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping(path = "/picture/{username}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    ResponseEntity<?> getProfilePicture(@PathVariable String username) {
        ProfilePicture pfp = service.getProfilePicture(username);
        if (pfp == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        MediaType contentType = switch (pfp.getFormat()) {
            case JPG -> MediaType.IMAGE_JPEG;
            case PNG -> MediaType.IMAGE_PNG;
            default -> MediaType.IMAGE_JPEG;
        };
        return ResponseEntity.status(HttpStatus.OK).contentType(contentType).body(pfp.getContent());
    }
}
