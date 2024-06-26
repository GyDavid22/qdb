package com.qdb.qdb.controller;

import com.qdb.qdb.dto.QuestionBindingDTO;
import com.qdb.qdb.entity.Image;
import com.qdb.qdb.entity.Question;
import com.qdb.qdb.entity.User;
import com.qdb.qdb.exception.NoRightException;
import com.qdb.qdb.exception.UnsupportedFileFormatException;
import com.qdb.qdb.service.ImageService;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(path = "image")
public class ImageController {
    @Autowired
    private final ImageService service;
    @Autowired
    private final SessionService sService;
    @Autowired
    private final QuestionService qService;

    public ImageController(ImageService service, SessionService sService, QuestionService qService) {
        this.service = service;
        this.sService = sService;
        this.qService = qService;
    }

    /**
     * Responds with the image specified by its name.
     *
     * @param name
     * @return
     */
    @GetMapping(path = "{name}")
    public ResponseEntity<?> getImage(@PathVariable String name) {
        byte[] result = service.getImageContent(name);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        String type = name.toLowerCase().endsWith(".png") ? MediaType.IMAGE_PNG_VALUE : MediaType.IMAGE_JPEG_VALUE;
        return ResponseEntity.status(HttpStatus.OK).header(HttpHeaders.CONTENT_TYPE, type).body(result);
    }

    /**
     * Endpoint to upload an image. Needs active session and basic rights. The image doesn't get bound to a question just by this endpoint.
     *
     * @param request
     * @param response
     * @param file
     * @return
     */
    @PostMapping
    ResponseEntity<?> uploadImage(HttpServletRequest request, HttpServletResponse response, @RequestParam("file") MultipartFile file) {
        User u = sService.checkCookieValidity(request.getCookies(), response);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        try {
            Image i = service.addImage(file.getBytes(), file.getContentType(), u, null);
            return ResponseEntity.status(HttpStatus.CREATED).body(i.getName());
        } catch (UnsupportedFileFormatException | IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Only .jpg, .jpeg and .png are supported");
        } catch (NoRightException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @DeleteMapping(path = "{name}")
    ResponseEntity<?> deleteImage(HttpServletRequest request, HttpServletResponse response, @PathVariable String name) {
        User u = sService.checkCookieValidity(request.getCookies(), response);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Image i = service.getByName(name);
        if (i == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        if (i.getQuestion() != null) {
            Question q = i.getQuestion();
            try {
                qService.checkEditingRights(q, u, false);
            } catch (NoRightException e) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You don't have rights to delete this image");
            }
        }
        service.deleteImage(i);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping(path = "{name}")
    ResponseEntity<?> bindImageToQuestion(HttpServletRequest request, HttpServletResponse response, @PathVariable String name, @RequestBody QuestionBindingDTO dto) {
        User u = sService.checkCookieValidity(request.getCookies(), response);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Image i = service.getByName(name);
        if (i == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Image not found");
        }
        if (i.getQuestion() != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Image already bound to question");
        }
        Question q = qService.getById(dto.getId());
        if (q == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Question not found");
        }
        try {
            service.bindImageToQuestion(i, q, u);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (NoRightException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You don't have rights to modify this question");
        }
    }
}
