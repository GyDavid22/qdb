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
    private Long id;
    @Lob
    private byte[] content;
    private String name;
    @ManyToOne
    private Question question;
    private LocalDateTime timeout;

    public Image() {
    }

    public Image(Long id, byte[] content, String name, Question question, LocalDateTime timeout) {
        this.id = id;
        this.content = content;
        this.name = name;
        this.question = question;
        this.timeout = timeout;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public LocalDateTime getTimeout() {
        return timeout;
    }

    public void setTimeout(LocalDateTime timeout) {
        this.timeout = timeout;
    }
}
