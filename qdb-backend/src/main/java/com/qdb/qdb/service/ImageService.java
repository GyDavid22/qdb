package com.qdb.qdb.service;

import com.qdb.qdb.entity.Image;
import com.qdb.qdb.entity.Permission;
import com.qdb.qdb.entity.Question;
import com.qdb.qdb.entity.User;
import com.qdb.qdb.exception.NoRightException;
import com.qdb.qdb.exception.UnsupportedFileFormatException;
import com.qdb.qdb.repository.ImageRepository;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class ImageService {
    @Autowired
    private final ImageRepository repo;
    @Autowired
    private final PermissionService pService;
    @Autowired
    private final QuestionService qService;
    private Random r = new Random();

    public ImageService(ImageRepository repo, PermissionService pService, QuestionService qService) {
        this.repo = repo;
        this.pService = pService;
        this.qService = qService;
    }

    public byte[] getImageContent(String name) {
        Optional<Image> result = repo.findByNameIgnoreCase(name);
        return result.map(Image::getContent).orElse(null);
    }

    public Image getByName(String name) {
        Optional<Image> result = repo.findByNameIgnoreCase(name);
        return result.orElse(null);
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
    public Image addImage(byte[] content, String mediaType, User u, @Nullable String originalName) throws UnsupportedFileFormatException, NoRightException {
        pService.checkPermission(u, Permission.Action.UPLOAD_IMAGE, false);
        if ((mediaType == null) || (!mediaType.equalsIgnoreCase(MediaType.IMAGE_JPEG_VALUE) && !mediaType.equalsIgnoreCase(MediaType.IMAGE_PNG_VALUE))) {
            throw new UnsupportedFileFormatException();
        }
        Image i = new Image(null, content, null, null, LocalDateTime.now().plusHours(2));
        repo.saveAndFlush(i);
        if (originalName != null) {
            i.setName(originalName);
        } else {
            boolean ok = false;
            String extension = mediaType.equalsIgnoreCase(MediaType.IMAGE_PNG_VALUE) ? ".png" : ".jpg";
            String testname = "";
            while (!ok) {
                byte[] randomBytes = new byte[16];
                r.nextBytes(randomBytes);
                LocalDateTime now = LocalDateTime.now();
                testname = Base64.getEncoder().encodeToString(randomBytes) + now + extension;
                if (repo.findByNameIgnoreCase(testname).isEmpty()) {
                    ok = true;
                }
            }
            i.setName(testname);
        }
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
        qService.checkEditingRights(q, u, false);
        i.setTimeout(null);
        i.setQuestion(q);
        repo.flush();
    }

    public void deleteImage(Image i) {
        repo.delete(i);
        repo.flush();
    }

    public void deleteImages(Collection<Image> i) {
        repo.deleteAll(i);
        repo.flush();
    }
}
