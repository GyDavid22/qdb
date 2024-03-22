package com.qdb.qdb.service;

import com.qdb.qdb.entity.Permission;
import com.qdb.qdb.entity.User;
import com.qdb.qdb.exception.NoRightException;
import com.qdb.qdb.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PermissionService {
    @Autowired
    private final LogService lService;
    @Autowired
    private final PermissionRepository repo;

    public PermissionService(LogService lService, PermissionRepository repo) {
        this.lService = lService;
        this.repo = repo;
    }

    /**
     * Method to check permissions. Throws exception if not just checking and don't have permission because it's harder to ignore
     *
     * @param u
     * @param action
     * @param onlyCheck
     * @return
     * @throws NoRightException
     */
    public boolean checkPermission(User u, Permission.Action action, boolean onlyCheck) throws NoRightException {
        Optional<Permission> result = this.repo.findByRankAndAction(u.getRank(), action);
        boolean hasPermission = result.isPresent();
        if (!onlyCheck) {
            lService.addEntry(u, action, hasPermission);
            if (!hasPermission) {
                throw new NoRightException();
            }
        }
        return hasPermission;
    }
}
