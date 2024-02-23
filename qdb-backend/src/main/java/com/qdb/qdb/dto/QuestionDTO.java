package com.qdb.qdb.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.qdb.qdb.entity.Question;
import com.qdb.qdb.entity.Tag;

import java.util.Collection;

@JsonSerialize
public class QuestionDTO {
    private String title;
    private String bodyUrl;
    private Collection<String> tags;
    private Collection<String> imagesUrls;

    public QuestionDTO(String title, String bodyUrl, Collection<String> tags, Collection<String> imagesUrls) {
        this.title = title;
        this.bodyUrl = bodyUrl;
        this.tags = tags;
        this.imagesUrls = imagesUrls;
    }

    public static QuestionDTO toDto(Question q) {
        return new QuestionDTO(q.getTitle(), "/api/question/body/" + q.getId(), q.getTags().stream().map(Tag::getName).toList(), q.getImages().stream().map(i -> "/api/image/" + i.getName()).toList());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBodyUrl() {
        return bodyUrl;
    }

    public void setBodyUrl(String bodyUrl) {
        this.bodyUrl = bodyUrl;
    }

    public Collection<String> getTags() {
        return tags;
    }

    public void setTags(Collection<String> tags) {
        this.tags = tags;
    }

    public Collection<String> getImagesUrls() {
        return imagesUrls;
    }

    public void setImagesUrls(Collection<String> imagesUrls) {
        this.imagesUrls = imagesUrls;
    }
}
