package com.esprit.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.quiz.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
