package com.qdb.qdb.configuration;

import com.qdb.qdb.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Task to delete inactive Sessions.
 */
@Configuration
@EnableScheduling
public class DeleteOldSessions {
    @Autowired
    private final SessionService service;

    public DeleteOldSessions(SessionService service) {
        this.service = service;
    }

    @Scheduled(fixedRate = 86400000) // once a day
    public void deleteSessionsOlderThanOneDayTask() {
        service.removeOlderThan(24);
    }
}
