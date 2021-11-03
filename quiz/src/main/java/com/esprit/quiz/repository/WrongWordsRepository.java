package com.esprit.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.quiz.entity.WrongWords;

@Repository
public interface WrongWordsRepository extends JpaRepository<WrongWords, Integer> {

}
