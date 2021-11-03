package com.quizmanagement.quiz.repository;

import com.quizmanagement.quiz.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {
}
