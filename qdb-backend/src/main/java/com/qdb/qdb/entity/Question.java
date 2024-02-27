package com.qdb.qdb.entity;

import jakarta.persistence.*;

import java.util.Collection;

/**
 * Represents a Question.
 */
@Entity
public class Question {
    @Id
    @GeneratedValue
    private long id;
    @Lob
    private String title;
    @Lob
    private String mdbody;
    @ManyToMany(mappedBy = "questions")
    private Collection<Tag> tags;
    @OneToMany(mappedBy = "question")
    private Collection<Image> images;

    public Question() {
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

    public String getMdbody() {
        return mdbody;
    }

    public void setMdbody(String mdbody) {
        this.mdbody = mdbody;
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
}
