package com.qdb.qdb.repository;

import com.qdb.qdb.entity.Permission;
import com.qdb.qdb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
    Optional<Permission> findByRankAndAction(User.Rank rank, Permission.Action action);

    List<Permission> findByAction(Permission.Action action);

    @Query("SELECT DISTINCT p.action FROM Permission p")
    List<Permission.Action> listOfActions();
}
