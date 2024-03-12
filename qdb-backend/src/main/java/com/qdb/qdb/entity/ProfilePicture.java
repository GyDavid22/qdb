package com.qdb.qdb.entity;

import jakarta.persistence.*;

@Entity
public class ProfilePicture {
    @Id
    @GeneratedValue
    private long id;
    @Lob
    private byte[] content;
    @OneToOne
    private User owner;
    private Format format;

    public ProfilePicture() {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public enum Format {
        JPG, PNG
    }
}
