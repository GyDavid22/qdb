package com.qdb.qdb.service;

import com.qdb.qdb.entity.Log;
import com.qdb.qdb.entity.Permission;
import com.qdb.qdb.entity.User;
import com.qdb.qdb.repository.LogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LogService {
    private final LogRepository repo;

    public LogService(LogRepository repo) {
        this.repo = repo;
    }

    public void addEntry(User u, Permission.Action action, boolean didSucceed) {
        repo.saveAndFlush(new Log(null, LocalDateTime.now(), u.getId(), u.getUserName(), action.toString(), u.getRank().toString(), didSucceed));
    }
}
