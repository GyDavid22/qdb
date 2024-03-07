package com.qdb.qdb.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.qdb.qdb.entity.Question;
import com.qdb.qdb.entity.Tag;

import java.util.Collection;

@JsonSerialize
public class QuestionDTO {
    //TODO: fetch from application.properties
    private static final String root = "/java/api";
    private long id;
    private String title;
    private String bodyUrl;
    private Collection<String> tags;
    private Collection<String> imagesUrls;
    private String createdby;

    public QuestionDTO(long id, String title, String bodyUrl, Collection<String> tags, Collection<String> imagesUrls, String createdby) {
        this.id = id;
        this.title = title;
        this.bodyUrl = bodyUrl;
        this.tags = tags;
        this.imagesUrls = imagesUrls;
        this.createdby = createdby;
    }

    public static QuestionDTO toDto(Question q) {
        return new QuestionDTO(q.getId(), q.getTitle(), root + "/question/body/" + q.getId(), q.getTags().stream().map(Tag::getName).toList(), q.getImages().stream().map(i -> root + "/image/" + i.getName()).toList(), q.getOwner() == null ? "null" : q.getOwner().getUserName());
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }
}
