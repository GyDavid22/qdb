package com.qdb.qdb.service;

import com.qdb.qdb.entity.Image;
import com.qdb.qdb.entity.Question;
import com.qdb.qdb.exception.UnsupportedFileFormatException;
import com.qdb.qdb.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Iterator;
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

    public void deleteOrphanImagesWithExpiredTimeout() {
        Collection<Image> results = repo.findByQuestionIsNull();
        LocalDateTime now = LocalDateTime.now();
        Iterator<Image> i = results.iterator();
        while (i.hasNext()) {
            Image image = i.next();
            if (image.getTimeout() != null && image.getTimeout().compareTo(now) < 1) {
                repo.delete(image);
                repo.flush();
            }
        }
    }

    public Image addImage(byte[] content, String mediaType) throws UnsupportedFileFormatException {
        if ((mediaType == null) || (!mediaType.equalsIgnoreCase(MediaType.IMAGE_JPEG_VALUE) && !mediaType.equalsIgnoreCase(MediaType.IMAGE_PNG_VALUE))) {
            throw new UnsupportedFileFormatException();
        }
        Image i = new Image();
        i.setContent(content);
        i.setTimeout(LocalDateTime.now().plusHours(2));
        repo.saveAndFlush(i);
        // TODO name check
        i.setName(i.getId() + (mediaType.equalsIgnoreCase(MediaType.IMAGE_PNG_VALUE) ? ".png" : ".jpg"));
        repo.flush();
        return i;
    }

    public void bindImageToQuestion(Image i, Question q) {
        i.setTimeout(null);
        i.setQuestion(q);
        repo.flush();
    }
}
