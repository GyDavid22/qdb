package com.qdb.qdb.controller;

import com.qdb.qdb.dto.SetPasswordDTO;
import com.qdb.qdb.dto.SetRankDTO;
import com.qdb.qdb.dto.UserDTO;
import com.qdb.qdb.dto.UserLoginDTO;
import com.qdb.qdb.entity.ProfilePicture;
import com.qdb.qdb.entity.User;
import com.qdb.qdb.exception.NoRightException;
import com.qdb.qdb.exception.UnsupportedFileFormatException;
import com.qdb.qdb.exception.UserNotFoundException;
import com.qdb.qdb.service.SessionService;
import com.qdb.qdb.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    /**
     * Endpoint to create new user.
     *
     * @param request
     * @param response
     * @param userCredentials
     * @return
     */
    @PostMapping
    public ResponseEntity<?> registration(HttpServletRequest request, HttpServletResponse response, @RequestBody UserLoginDTO userCredentials) {
        if (sService.checkCookieValidity(request.getCookies(), response) != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Log out first");
        }
        if (service.createUser(userCredentials.getUsername(), userCredentials.getPassword()) == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username taken");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Account created");
    }

    /**
     * Endpoint to delete an user. If username provided, user deletes itself, if no username provided, an admin session needed and the given user will be deleted.
     *
     * @param request
     * @param response
     * @param username
     * @return
     */
    @DeleteMapping(path = {"", "/{username}"})
    public ResponseEntity<?> deleteUser(HttpServletRequest request, HttpServletResponse response, @PathVariable(required = false) String username) {
        User u = sService.checkCookieValidity(request.getCookies(), response);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        try {
            if (username != null) {
                if (u.getUserName().equals(username)) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please delete your account on the user overview page");
                }
                User u2 = service.getByUserName(username, null);
                if (u2 == null) {
                    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
                }
                service.deleteUser(u2, u, false);
            } else {
                boolean result = service.deleteUser(u, null, false);
                if (!result) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You're the last superuser, you can't delete your account");
                }
            }
        } catch (NoRightException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You don't have the rights to perform this action.");
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * Endpoint to get metadata of currently logged in user.
     *
     * @param request
     * @param response
     * @return
     */
    @GetMapping
    public ResponseEntity<?> getCurrentUserData(HttpServletRequest request, HttpServletResponse response) {
        User u = sService.checkCookieValidity(request.getCookies(), response);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(UserDTO.toDTO(u));
    }

    /**
     * Endpoint to get metadata of a given user, admin session needed.
     *
     * @param request
     * @param response
     * @param username
     * @return
     */
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

    /**
     * Endpoint to get metadata of all users, admin session needed.
     *
     * @param request
     * @param response
     * @return
     */
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

    /**
     * Endpoint to set one's rank, admin session needed.
     *
     * @param request
     * @param response
     * @param username
     * @param rank
     * @return
     */
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
            if (u == res) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You can't set your own rank");
            }
            service.setRank(u, res, rank.getRank());
        } catch (NoRightException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You don't have permission to set this rank");
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
            if (u == res) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please change your password on the user overview page");
            }
            service.setPasswordByAdmin(u, res, password.getNewPassword());
        } catch (NoRightException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You don't have permission to change one's password");
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @GetMapping(path = {"/picture", "/picture/{username}"}, produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public ResponseEntity<?> getProfilePicture(HttpServletRequest request, HttpServletResponse response, @PathVariable(required = false) String username) {
        User u = sService.checkCookieValidity(request.getCookies(), response);
        ProfilePicture pfp = null;
        if (username != null) {
            pfp = service.getProfilePicture(username);
        } else if (u != null) {
            pfp = service.getProfilePicture(u.getUserName());
        }
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

    /**
     * Endpoint to get one's profile picture. Login required.
     *
     * @param request
     * @param response
     * @param file
     * @return
     */
    @PostMapping(path = "/picture")
    public ResponseEntity<?> uploadProfilePicture(HttpServletRequest request, HttpServletResponse response, @RequestParam("file") MultipartFile file) {
        User u = sService.checkCookieValidity(request.getCookies(), response);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        if (file == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        try {
            service.setProfilePicture(file.getBytes(), file.getContentType(), u.getUserName());
        } catch (IOException | UnsupportedFileFormatException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unsupported file format, please upload .jpg, .jpeg or .png");
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (NoRightException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You don't have rights to upload a profile picture");
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /**
     * Endpoint to reset one's profile picture. If username not provided, user will set its own profile picture, if provided, an admin session needed and the given user's profile picture will be deleted.
     *
     * @param request
     * @param response
     * @return
     */
    @DeleteMapping(path = "/picture")
    public ResponseEntity<?> deleteProfilePicture(HttpServletRequest request, HttpServletResponse response) {
        User u = sService.checkCookieValidity(request.getCookies(), response);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        try {
            service.deleteProfilePicture(u.getUserName());
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (NoRightException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
