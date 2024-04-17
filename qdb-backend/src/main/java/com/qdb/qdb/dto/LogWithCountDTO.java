package com.qdb.qdb.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.qdb.qdb.entity.Log;

import java.util.List;

@JsonSerialize
public class LogWithCountDTO {
    private long totalCount;
    private List<Log> results;

    public LogWithCountDTO(long totalCount, List<Log> results) {
        this.totalCount = totalCount;
        this.results = results;
    }

    public LogWithCountDTO() {
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public List<Log> getResults() {
        return results;
    }

    public void setResults(List<Log> results) {
        this.results = results;
    }
}
