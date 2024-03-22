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
    private Long id;
    private String name;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Question> questions;

    public Tag() {
    }

    public Tag(Long id, String name, Collection<Question> questions) {
        this.id = id;
        this.name = name;
        this.questions = questions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Collection<Question> questions) {
        this.questions = questions;
    }
}
