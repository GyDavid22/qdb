package com.qdb.qdb.service;

import com.qdb.qdb.entity.Image;
import com.qdb.qdb.entity.Question;
import com.qdb.qdb.entity.User;
import com.qdb.qdb.exception.NoRightException;
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
    @Autowired
    private final UserService uService;

    public ImageService(ImageRepository repo, UserService uService) {
        this.repo = repo;
        this.uService = uService;
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

    /**
     * Adds a new image to the database. Doesn't bind to a question, images not bound to a question will be deleted after 2 hours. Needs basic rights.
     *
     * @param content
     * @param mediaType
     * @param u
     * @return
     * @throws UnsupportedFileFormatException
     * @throws NoRightException
     */
    public Image addImage(byte[] content, String mediaType, User u) throws UnsupportedFileFormatException, NoRightException {
        if (!uService.checkRights(u, User.Rank.BASIC)) {
            throw new NoRightException();
        }
        if ((mediaType == null) || (!mediaType.equalsIgnoreCase(MediaType.IMAGE_JPEG_VALUE) && !mediaType.equalsIgnoreCase(MediaType.IMAGE_PNG_VALUE))) {
            throw new UnsupportedFileFormatException();
        }
        Image i = new Image();
        i.setContent(content);
        i.setTimeout(LocalDateTime.now().plusHours(2));
        repo.saveAndFlush(i);
        i.setName(i.getId() + (mediaType.equalsIgnoreCase(MediaType.IMAGE_PNG_VALUE) ? ".png" : ".jpg"));
        repo.flush();
        return i;
    }

    /**
     * Binds an image to a question and saves it from being automatically deleted. User either needs to be the owner of the question or be an admin.
     *
     * @param i
     * @param q
     * @param u
     * @throws NoRightException
     */
    public void bindImageToQuestion(Image i, Question q, User u) throws NoRightException {
        if (q.getOwner() != u && !u.getRank().equals(User.Rank.ADMIN)) {
            throw new NoRightException();
        }
        i.setTimeout(null);
        i.setQuestion(q);
        repo.flush();
    }
}
