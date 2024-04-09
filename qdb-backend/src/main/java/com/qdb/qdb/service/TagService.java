package com.qdb.qdb.service;

import com.qdb.qdb.dto.TagWithCountDTO;
import com.qdb.qdb.entity.Question;
import com.qdb.qdb.entity.Tag;
import com.qdb.qdb.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    @Autowired
    private final TagRepository repo;

    public TagService(TagRepository repo) {
        this.repo = repo;
    }

    public Tag getTagByName(String name) {
        name = name.trim();
        return repo.findByNameIgnoreCase(name).orElse(null);
    }

    /**
     * Binds tag to Question, if it hasn't been bound already. Creates and saves new Tag if tag name doesn't exist.
     *
     * @param q
     * @param name
     */
    public void bindTagToQuestion(Question q, String name) {
        if (name.isEmpty()) {
            return;
        }
        name = name.trim().replace(",", "").replace(" ", "_");
        Optional<Tag> result = repo.findByNameIgnoreCase(name);
        if (result.isPresent()) {
            if (!result.get().getQuestions().contains(q)) {
                result.get().getQuestions().add(q);
            }
        } else {
            Tag newTag = new Tag(null, name.toLowerCase(), new ArrayList<>());
            newTag.getQuestions().add(q);
            repo.save(newTag);
        }
        repo.flush();
    }

    /**
     * Unbinds Tag from Question if Question and Tag both exists, also Tag is bound to Question. Deletes Tag if there aren't any Questions bound to it anymore.
     *
     * @param q
     * @param t
     */
    public void unbindTagFromQuestion(Question q, Tag t) {
        boolean didRemovalSucceed = t.getQuestions().remove(q);
        if (didRemovalSucceed) {
            if (t.getQuestions().isEmpty()) {
                repo.delete(t);
            }
            repo.flush();
        }
    }

    public List<TagWithCountDTO> getTagsWithQuestionCount() {
        return new ArrayList<>(repo.findAll().stream().map(t -> new TagWithCountDTO(t.getName(), t.getQuestions().size())).toList());
    }
}
