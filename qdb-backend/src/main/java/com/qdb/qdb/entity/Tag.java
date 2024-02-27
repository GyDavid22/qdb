package com.qdb.qdb.entity;

import jakarta.persistence.*;

import java.util.Collection;

/**
 * Represents a Tag bound to Questions. It shouldn't exist on its own without any Questions.
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "name"), indexes = @Index(columnList = "name"))
public class Tag {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @ManyToMany
    private Collection<Question> questions;

    public Tag() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Collection<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Collection<Question> questions) {
        this.questions = questions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
