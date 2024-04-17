package com.qdb.qdb.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.qdb.qdb.entity.Image;
import com.qdb.qdb.entity.Question;
import com.qdb.qdb.entity.Tag;

import java.util.Collection;

@JsonSerialize
public class QuestionDTO {
    private long id;
    private String title;
    private Collection<String> tags;
    private Collection<String> imagesUrls;
    private String createdby;
    private Boolean isReported;
    private boolean currentUserHasEditingRights;
    private boolean isInFavorites;

    public QuestionDTO(long id, String title, Collection<String> tags, Collection<String> imagesUrls, String createdby, Boolean isReported, boolean currentUserHasEditingRights, boolean isInFavorites) {
        this.id = id;
        this.title = title;
        this.tags = tags;
        this.imagesUrls = imagesUrls;
        this.createdby = createdby;
        this.isReported = isReported;
        this.currentUserHasEditingRights = currentUserHasEditingRights;
        this.isInFavorites = isInFavorites;
    }

    public static QuestionDTO toDto(Question q, boolean currentUserHasEditingRights, boolean isInFavorites) {
        return new QuestionDTO(q.getId(), q.getTitle(), q.getTags().stream().map(Tag::getName).toList(), q.getImages().stream().map(Image::getName).toList(), q.getOwner() == null ? "null" : q.getOwner().getUserName(), q.isReported(), currentUserHasEditingRights, isInFavorites);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public boolean isCurrentUserHasEditingRights() {
        return currentUserHasEditingRights;
    }

    public void setCurrentUserHasEditingRights(boolean currentUserHasEditingRights) {
        this.currentUserHasEditingRights = currentUserHasEditingRights;
    }

    public Boolean getIsReported() {
        return isReported;
    }

    public void setIsReported(Boolean reported) {
        isReported = reported;
    }

    public boolean isInFavorites() {
        return isInFavorites;
    }

    public void setInFavorites(boolean inFavorites) {
        isInFavorites = inFavorites;
    }
}
