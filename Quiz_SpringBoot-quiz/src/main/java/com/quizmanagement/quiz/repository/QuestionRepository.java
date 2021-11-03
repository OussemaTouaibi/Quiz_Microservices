package com.quizmanagement.quiz.repository;

import com.quizmanagement.quiz.model.Question;
import com.quizmanagement.quiz.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Set<Question> findByQuiz(Quiz quiz);
}
