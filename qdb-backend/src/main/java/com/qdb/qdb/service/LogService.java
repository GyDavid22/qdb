package com.qdb.qdb.service;

import com.qdb.qdb.entity.Log;
import com.qdb.qdb.entity.Permission;
import com.qdb.qdb.entity.User;
import com.qdb.qdb.exception.NoRightException;
import com.qdb.qdb.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LogService {
    @Autowired
    private final LogRepository repo;
    @Autowired
    private final ApplicationContext context;

    public LogService(LogRepository repo, ApplicationContext context) {
        this.repo = repo;
        this.context = context;
    }

    public void addEntry(User u, Permission.Action action, boolean didSucceed) {
        repo.saveAndFlush(new Log(null, LocalDateTime.now(), u.getId(), u.getUserName(), action.toString(), u.getRank().toString(), didSucceed));
    }

    public List<Log> getLogEntries(@NonNull User u, Integer pageSize, Integer pageIndex) throws IllegalArgumentException, NoRightException {
        context.getBean(PermissionService.class).checkPermission(u, Permission.Action.READ_LOG, false);
        if (pageSize == null || pageIndex == null) {
            return repo.findAll(Sort.by("time").descending());
        }
        if (pageSize < 1 || pageIndex < 0 || pageIndex >= pageCount(repo.count(), pageSize)) {
            throw new IllegalArgumentException();
        }
        return repo.findAll(PageRequest.of(pageIndex, pageSize, Sort.by("time").descending())).getContent();
    }

    public void deleteEntriesOlderThan(int days) {
        repo.deleteAll(repo.findAllByTimeLessThan(LocalDateTime.now().minusDays(days)));
        repo.flush();
    }

    private long pageCount(long numOfEntries, int pageSize) {
        if (numOfEntries % pageSize == 0) {
            return numOfEntries / pageSize;
        }
        return numOfEntries / pageSize + 1;
    }
}
