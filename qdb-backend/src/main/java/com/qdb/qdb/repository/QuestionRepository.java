package com.qdb.qdb.repository;

import com.qdb.qdb.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    @Query("SELECT q FROM Question q WHERE LOWER(CAST(q.mdbody AS STRING)) LIKE CONCAT('%', LOWER(?1), '%') OR LOWER(CAST(q.title AS STRING)) LIKE CONCAT('%', LOWER(?1), '%')")
    List<Question> searchByStringInTitleAndBody(String searchTerm);

    @Query("SELECT q FROM Question q WHERE LOWER(CAST(q.title AS STRING)) LIKE CONCAT('%', LOWER(?1), '%')")
    List<Question> searchByStringInTitle(String searchTerm);

    @Query("SELECT q FROM Question q WHERE LOWER(CAST(q.mdbody AS STRING)) LIKE CONCAT('%', LOWER(?1), '%')")
    List<Question> searchByStringInBody(String searchTerm);

    @Query("SELECT q FROM Question q ORDER BY FUNCTION('RAND') LIMIT ?1")
    List<Question> randomQuestion(int count);

    List<Question> findAllByTitleAndMdbody(String title, String mdbody);

    Optional<Question> findFirstByIdLessThanOrderByIdDesc(long id);

    Optional<Question> findFirstByIdGreaterThanOrderByIdAsc(long id);
}
