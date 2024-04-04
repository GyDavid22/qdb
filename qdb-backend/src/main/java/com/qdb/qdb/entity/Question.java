package com.qdb.qdb.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.Collection;

/**
 * Represents a Question.
 */
@Entity
public class Question {
    @Id
    @GeneratedValue
    private Long id;
    @Lob
    private String title;
    @Lob
    private String mdbody;
    @ManyToOne
    @Nullable
    private User owner;
    private Boolean isReported;
    @ManyToMany(mappedBy = "questions", fetch = FetchType.EAGER)
    private Collection<Tag> tags;
    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
    private Collection<Image> images;

    public Question() {
    }

    public Question(Long id, String title, String mdbody, @Nullable User owner, Boolean isReported, Collection<Tag> tags, Collection<Image> images) {
        this.id = id;
        this.title = title;
        this.mdbody = mdbody;
        this.owner = owner;
        this.isReported = isReported;
        this.tags = tags;
        this.images = images;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Nullable
    public User getOwner() {
        return owner;
    }

    public void setOwner(@Nullable User owner) {
        this.owner = owner;
    }

    public Collection<Tag> getTags() {
        return tags;
    }

    public void setTags(Collection<Tag> tags) {
        this.tags = tags;
    }

    public Collection<Image> getImages() {
        return images;
    }

    public void setImages(Collection<Image> images) {
        this.images = images;
    }

    public Boolean isReported() {
        return isReported;
    }

    public void setReported(Boolean reported) {
        isReported = reported;
    }
}
