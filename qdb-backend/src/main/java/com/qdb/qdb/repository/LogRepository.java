package com.qdb.qdb.repository;

import com.qdb.qdb.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface LogRepository extends JpaRepository<Log, Long> {
    List<Log> findAllByTimeLessThan(LocalDateTime time);
}
