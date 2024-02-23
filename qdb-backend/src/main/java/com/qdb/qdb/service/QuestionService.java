package com.qdb.qdb.service;

import com.qdb.qdb.entity.Question;
import com.qdb.qdb.entity.Tag;
import com.qdb.qdb.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class QuestionService {
    @Autowired
    private final QuestionRepository repo;
    @Autowired
    private final TagService tService;

    public QuestionService(QuestionRepository repo, TagService tService) {
        this.repo = repo;
        this.tService = tService;
    }

    public Question getById(long id) {
        Optional<Question> result = repo.findById(id);
        return result.orElse(null);
    }

    /**
     * Examines the difference between bound Tags to Question and the given list of Tags and updates Question according to that. If the Tag doesn't exist, it will be created.
     *
     * @param q
     * @param tags
     */
    public void updateTags(Question q, List<String> tags) {
        Set<String> toAdd = new HashSet<>();
        Set<Tag> tagObj = new HashSet<>();
        for (String i : tags) {
            Tag result = tService.getTagByName(i);
            if (result == null) {
                toAdd.add(i);
            } else {
                tagObj.add(result);
            }
        }
        Set<Tag> currentTags = new HashSet<>(q.getTags());
        Set<Tag> toRemove = new HashSet<>();
        for (Tag i : currentTags) {
            if (!tagObj.contains(i)) {
                toRemove.add(i);
            }
        }
        for (Tag i : tagObj) {
            if (!currentTags.contains(i)) {
                toAdd.add(i.getName());
            }
        }
        for (String i : toAdd) {
            tService.bindTagToQuestion(q, i);
        }
        for (Tag i : toRemove) {
            tService.unbindTagFromQuestion(q, i);
        }
    }

    public List<Question> getQuestionPaged(int indexOfPage, int pageSize) {
        return repo.findAll(PageRequest.of(indexOfPage, pageSize)).toList();
    }

    public List<Question> getQuestions() {
        return repo.findAll();
    }

    public long numberOfPages(int pageSize) {
        long count = repo.count();
        return count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
    }

    public long getNumberOfQuestions() {
        return repo.count();
    }
}
