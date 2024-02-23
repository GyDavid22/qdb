package com.qdb.qdb.service;

import com.qdb.qdb.entity.Image;
import com.qdb.qdb.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageService {
    @Autowired
    private final ImageRepository repo;

    public ImageService(ImageRepository repo) {
        this.repo = repo;
    }

    public byte[] getImageContent(String name) {
        Optional<Image> result = repo.findByNameIgnoreCase(name);
        return result.map(Image::getContent).orElse(null);
    }
}
