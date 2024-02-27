package com.qdb.qdb.repository;

import com.qdb.qdb.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Long> {
    Optional<Image> findByNameIgnoreCase(String name);
}
