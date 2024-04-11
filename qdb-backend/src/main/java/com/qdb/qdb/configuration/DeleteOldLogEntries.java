package com.qdb.qdb.configuration;

import com.qdb.qdb.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class DeleteOldLogEntries {
    @Autowired
    private final ApplicationContext context;

    public DeleteOldLogEntries(ApplicationContext context) {
        this.context = context;
    }

    @Scheduled(fixedRate = 86400000) // once a day
    public void deleteOlderLogEntriesThan30Days() {
        context.getBean(LogService.class).deleteEntriesOlderThan(30);
    }
}
