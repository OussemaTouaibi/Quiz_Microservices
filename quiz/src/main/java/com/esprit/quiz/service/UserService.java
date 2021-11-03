package com.esprit.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.quiz.entity.User;
import com.esprit.quiz.repository.UserRepository;


@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User findById(int id) {
		User existingUser = null;
		if (userRepository.findById(id).isPresent()) {
			existingUser = userRepository.findById(id).get();
		}
		return existingUser;
	}

}
