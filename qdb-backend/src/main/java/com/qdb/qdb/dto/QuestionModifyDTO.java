package com.qdb.qdb.dto;

import com.qdb.qdb.entity.Question;
import com.qdb.qdb.entity.User;
import jakarta.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class QuestionModifyDTO {

    private String title;

    private String mdbody;

    private List<String> tags;

    public QuestionModifyDTO(String title, String mdbody, List<String> tags) {
        this.title = title;
        this.mdbody = mdbody;
        this.tags = tags;
    }

    public QuestionModifyDTO() {
    }

    public static Question toQuestion(QuestionModifyDTO q, @Nullable User owner) {
        return new Question(null, q.getTitle(), q.getMdbody(), owner, new ArrayList<>(), new ArrayList<>());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMdbody() {
        return mdbody;
    }

    public void setMdbody(String mdbody) {
        this.mdbody = mdbody;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
