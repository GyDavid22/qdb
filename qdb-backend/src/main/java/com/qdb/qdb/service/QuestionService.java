package com.qdb.qdb.service;

import com.qdb.qdb.entity.Permission;
import com.qdb.qdb.entity.Question;
import com.qdb.qdb.entity.Tag;
import com.qdb.qdb.entity.User;
import com.qdb.qdb.exception.NoRightException;
import com.qdb.qdb.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionService {
    @Autowired
    private final QuestionRepository repo;
    @Autowired
    private final TagService tService;
    @Autowired
    private final PermissionService pService;

    public QuestionService(QuestionRepository repo, TagService tService, PermissionService pService) {
        this.repo = repo;
        this.tService = tService;
        this.pService = pService;
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
    public void updateTags(Question q, List<String> tags, User u) throws NoRightException {
        checkEditingRights(q, u);
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

    /**
     * Paginates results
     *
     * @param indexOfPage Index of the desired page, starts with 0.
     * @param pageSize    Desired size of a page
     * @param questions   Source list to paginate
     * @return Returns with the list of results on the page determined by the parameters, returns null if indexOfPage or pageSize is invalid
     */
    public List<Question> getQuestionPagedFromList(int indexOfPage, int pageSize, List<Question> questions) {
        if (questions.isEmpty()) {
            return questions;
        }
        if (indexOfPage < 0 || pageSize < 1 || numberOfPages(pageSize, questions) - 1 < indexOfPage) {
            return null;
        }
        int start = pageSize * indexOfPage;
        int end = Math.min(start + pageSize, questions.size());
        return questions.subList(start, end);
    }

    public List<Question> getQuestions() {
        return repo.findAll();
    }

    /**
     * @param pageSize
     * @param questions
     * @return The maximum number of pages with the given pageSize on the given list.
     */
    public long numberOfPages(int pageSize, List<Question> questions) {
        return questions.size() % pageSize == 0 ? questions.size() / pageSize : questions.size() / pageSize + 1;
    }

    public long getNumberOfQuestions() {
        return repo.count();
    }

    /**
     * @param term
     * @param searchType
     * @return A list of Questions matching the search criteria. An empty list, if no results were found, null is searchType is invalid
     */
    public List<Question> search(String term, String searchType) {
        if (searchType == null) {
            return repo.searchByStringInTitleAndBody(term);
        }
        try {
            return switch (SearchType.valueOf(searchType.toUpperCase())) {
                case ALL -> repo.searchByStringInTitleAndBody(term);
                case BODY -> repo.searchByStringInBody(term);
                case TITLE -> repo.searchByStringInTitle(term);
            };
        } catch (IllegalArgumentException ignored) {
        }
        return null;
    }

    /**
     * Returns a list with the Questions which have all tags from the tags list. If the tags list is empty, returns Questions without any tags.
     *
     * @param questions
     * @param tags
     * @return
     */
    public List<Question> filterByTags(List<Question> questions, List<String> tags) {
        List<Question> potentialResults = new ArrayList<>();
        if (!tags.isEmpty()) {
            potentialResults.addAll(questions);
            for (String s : tags) {
                Tag t = tService.getTagByName(s);
                if (t == null) {
                    potentialResults.clear();
                    return potentialResults;
                }
                int i = 0;
                while (i < potentialResults.size()) {
                    if (!t.getQuestions().contains(potentialResults.get(i))) {
                        potentialResults.remove(i);
                    } else {
                        i++;
                    }
                }
            }
        } else {
            for (Question q : questions) {
                if (q.getTags().isEmpty()) {
                    potentialResults.add(q);
                }
            }
        }
        return potentialResults;
    }

    private void checkEditingRights(Question q, User u) throws NoRightException {
        if (u.getQuestions().contains(q)) {
            pService.checkPermission(u, Permission.Action.UPDATE_TAGS_OWN_QUESTION, false);
        } else {
            pService.checkPermission(u, Permission.Action.UPDATE_TAGS_ANY_QUESTION, false);
        }
    }

    private enum SearchType {
        TITLE, BODY, ALL
    }
}
