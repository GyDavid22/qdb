package com.qdb.qdb.repository;

import com.qdb.qdb.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session, Long> {
    List<Session> findAllByLastInteractionLessThan(LocalDateTime date);

    Optional<Session> findBySessionId(char[] sessionId);
}
