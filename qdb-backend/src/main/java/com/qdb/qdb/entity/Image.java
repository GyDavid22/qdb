package com.qdb.qdb.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * Represents an image. It shouldn't exist on its own without a Question.
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "name"), indexes = @Index(columnList = "name"))
public class Image {
    @Id
    @GeneratedValue
    private long id;
    @Lob
    private byte[] content;
    private String name;
    @ManyToOne
    private Question question;
    private LocalDateTime timeout;

    public Image() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getTimeout() {
        return timeout;
    }

    public void setTimeout(LocalDateTime timeout) {
        this.timeout = timeout;
    }
}
