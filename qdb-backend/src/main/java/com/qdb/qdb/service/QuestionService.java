package com.qdb.qdb.service;

import com.qdb.qdb.dto.QuestionModifyDTO;
import com.qdb.qdb.entity.*;
import com.qdb.qdb.exception.NoRightException;
import com.qdb.qdb.exception.QuestionNotFoundException;
import com.qdb.qdb.exception.UserNotFoundException;
import com.qdb.qdb.repository.ImageRepository;
import com.qdb.qdb.repository.QuestionRepository;
import jakarta.annotation.Nullable;
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
    @Autowired
    private final ImageRepository iRepo;
    @Autowired
    private final UserService uService;

    public QuestionService(QuestionRepository repo, TagService tService, PermissionService pService, ImageRepository iRepo, UserService uService) {
        this.repo = repo;
        this.tService = tService;
        this.pService = pService;
        this.iRepo = iRepo;
        this.uService = uService;
    }

    @Nullable
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
        checkEditingRights(q, u, false);
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
        Set<Question> results = new TreeSet<>();
        String[] termSplitted = term.split(" ");
        for (String i : termSplitted) {
            results.addAll(searchInTitleBody(i, searchType));
        }
        List<Question> questions = repo.findAll();
        for (Question i : questions) {
            for (Tag j : i.getTags()) {
                for (String k : termSplitted) {
                    if (j.getName().equalsIgnoreCase(k)) {
                        results.add(i);
                    }
                }
            }
        }
        return new ArrayList<>(results);
    }

    /**
     * Returns a list with the Questions which have all tags from the tags list. If the tags list is empty, returns Questions without any tags.
     *
     * @param questions
     * @param tags
     * @return
     */
    public List<Question> filterByTagsAnd(List<Question> questions, List<String> tags) {
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

    private List<Question> searchInTitleBody(String term, String searchType) {
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
        return new ArrayList<>();
    }

    public void updateQuestion(long id, QuestionModifyDTO updated, User u) throws QuestionNotFoundException, NoRightException {
        Question q = getById(id);
        if (q == null) {
            throw new QuestionNotFoundException();
        }
        checkEditingRights(q, u, false);
        q.setTitle(updated.getTitle());
        q.setMdbody(updated.getMdbody());
        updateTags(q, updated.getTags(), u);
        repo.saveAndFlush(q);
    }

    public Question createQuestion(QuestionModifyDTO q, User u) throws NoRightException {
        pService.checkPermission(u, Permission.Action.CREATE_QUESTION, false);
        Question newQuestion = new Question(null, q.getTitle(), q.getMdbody(), u, false, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        repo.saveAndFlush(newQuestion);
        updateTags(newQuestion, q.getTags(), u);
        return newQuestion;
    }

    public void deleteQuestion(long id, User u) throws QuestionNotFoundException, NoRightException {
        Question q = getById(id);
        if (q == null) {
            throw new QuestionNotFoundException();
        }
        checkDeletingRights(q, u, false);
        List<Image> shallowCopy = new ArrayList<>(q.getImages());
        q.getImages().clear();
        q.getFavoritedBy().clear();
        repo.saveAndFlush(q);
        iRepo.deleteAll(shallowCopy);
        updateTags(q, new ArrayList<>(), u);
        repo.delete(q);
        repo.flush();
    }

    public void reportQuestion(long id, User u) throws QuestionNotFoundException, NoRightException {
        pService.checkPermission(u, Permission.Action.REPORT_QUESTION, false);
        Question q = getById(id);
        if (q == null) {
            throw new QuestionNotFoundException();
        }
        q.setReported(true);
        repo.saveAndFlush(q);
    }

    public void unReportQuestion(long id, User u) throws QuestionNotFoundException, NoRightException {
        pService.checkPermission(u, Permission.Action.UNREPORT_QUESTION, false);
        Question q = getById(id);
        if (q == null) {
            throw new QuestionNotFoundException();
        }
        q.setReported(false);
        repo.saveAndFlush(q);
    }

    public void addToFavorites(long id, User u) throws QuestionNotFoundException, NoRightException {
        pService.checkPermission(u, Permission.Action.EDIT_FAVORITE_LIST_OWN, false);
        Question q = getById(id);
        if (q == null) {
            throw new QuestionNotFoundException();
        }
        if (!q.getFavoritedBy().contains(u)) {
            q.getFavoritedBy().add(u);
        }
        repo.saveAndFlush(q);
    }

    public void removeFromFavorites(long id, User u) throws QuestionNotFoundException, NoRightException {
        pService.checkPermission(u, Permission.Action.EDIT_FAVORITE_LIST_OWN, false);
        Question q = getById(id);
        if (q == null) {
            throw new QuestionNotFoundException();
        }
        q.getFavoritedBy().remove(u);
        repo.saveAndFlush(q);
    }

    public List<Question> findForUser(String username, @Nullable List<Question> q) throws NoRightException, UserNotFoundException {
        User u = uService.getByUserName(username, null);
        if (u == null) {
            throw new UserNotFoundException();
        }
        if (q != null) {
            return q.stream().filter(t -> t.getOwner() == u).toList();
        }
        return u.getQuestions().stream().toList();
    }

    public boolean checkEditingRights(Question q, User u, boolean onlycheck) throws NoRightException {
        if (q.getOwner() == u && u.getRank() != User.Rank.RESTRICTED) {
            return pService.checkPermission(u, Permission.Action.UPDATE_QUESTION_OWN, onlycheck);
        } else if (q.getOwner() != null) {
            if (q.getOwner().getRank() == User.Rank.ADMIN) {
                return pService.checkPermission(u, Permission.Action.UPDATE_QUESTION_OWNER_ADMIN, onlycheck);
            } else if (q.getOwner().getRank() == User.Rank.SUPERUSER) {
                return pService.checkPermission(u, Permission.Action.UPDATE_QUESTION_OWNER_SUPERUSER, onlycheck);
            } else if (q.getOwner().getRank() == User.Rank.NORMAL || q.getOwner().getRank() == User.Rank.RESTRICTED) {
                return pService.checkPermission(u, Permission.Action.UPDATE_QUESTION_OWNER_NORMAL_RESTRICTED, onlycheck);
            }
        } else if (q.getOwner() == null && u.getRank() == User.Rank.SUPERUSER) {
            return pService.checkPermission(u, Permission.Action.UPDATE_QUESTION_OWNER_SUPERUSER, onlycheck);
        }
        return false;
    }

    public boolean checkDeletingRights(Question q, User u, boolean onlycheck) throws NoRightException {
        if (q.getOwner() == null) {
            return pService.checkPermission(u, Permission.Action.DELETE_QUESTION_OF_SUPERUSER, onlycheck);
        } else if (q.getOwner().getRank() == User.Rank.SUPERUSER) {
            return pService.checkPermission(u, Permission.Action.DELETE_QUESTION_OF_SUPERUSER, onlycheck);
        } else if (q.getOwner().getRank() == User.Rank.ADMIN) {
            return pService.checkPermission(u, Permission.Action.DELETE_QUESTION_OF_ADMIN, onlycheck);
        } else if (q.getOwner().getRank() == User.Rank.NORMAL || q.getOwner().getRank() == User.Rank.RESTRICTED) {
            return pService.checkPermission(u, Permission.Action.DELETE_QUESTION_OF_NORMAL_RESTRICTED, onlycheck);
        } else if (q.getOwner() == u) {
            return pService.checkPermission(u, Permission.Action.DELETE_QUESTION_OWN, onlycheck);
        }
        return false;
    }

    private enum SearchType {
        TITLE, BODY, ALL
    }
}
