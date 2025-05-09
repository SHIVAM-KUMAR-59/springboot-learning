package com.shivam._71.Question_Service.repository;

import com.shivam._71.Question_Service.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);

    @Query(value = "SELECT q.id FROM question q WHERE q.category = :category ORDER BY RANDOM() LIMIT :num", nativeQuery = true)
    List<Integer> findRandomQuestionsByCategory(@Param("category") String category, @Param("num") int num);

}
