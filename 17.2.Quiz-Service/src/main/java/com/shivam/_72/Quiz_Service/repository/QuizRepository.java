package com.shivam._72.Quiz_Service.repository;

import com.shivam._72.Quiz_Service.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {
}
