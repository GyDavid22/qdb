package com.qdb.qdb.entity;

import jakarta.persistence.*;

@Entity
public class ProfilePicture {
    @Id
    @GeneratedValue
    private Long id;
    @Lob
    private byte[] content;
    @OneToOne
    private User owner;
    private Format format;

    public ProfilePicture() {
    }

    public ProfilePicture(Long id, byte[] content, User owner, Format format) {
        this.id = id;
        this.content = content;
        this.owner = owner;
        this.format = format;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public enum Format {
        JPG, PNG
    }
}
