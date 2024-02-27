package com.qdb.qdb.controller;

import com.qdb.qdb.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/image")
public class ImageController {
    @Autowired
    private final ImageService service;

    public ImageController(ImageService service) {
        this.service = service;
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
}
