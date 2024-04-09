package com.qdb.qdb.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

@JsonSerialize
public class QuestionDTOWithCount {
    private int resultsCount;
    private List<QuestionDTO> questions;

    public QuestionDTOWithCount(int resultsCount, List<QuestionDTO> questions) {
        this.resultsCount = resultsCount;
        this.questions = questions;
    }

    public QuestionDTOWithCount(List<QuestionDTO> questions) {
        this.questions = questions;
        this.resultsCount = questions.size();
    }

    public int getResultsCount() {
        return resultsCount;
    }

    public void setResultsCount(int resultsCount) {
        this.resultsCount = resultsCount;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }
}
