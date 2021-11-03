package com.quizmanagement.blog.service.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizmanagement.blog.service.entities.Comment;
import com.quizmanagement.blog.service.repository.CommentRepository;
@Service
public class CommentServiceImpl implements IcommentService {
@Autowired	CommentRepository commentI;

	@Override
	public void ajouterComment(Comment comment) {
		commentI.save(comment);
		
	}

	@Override
	public List<Comment> getAll() {
		// TODO Auto-generated method stub
		return (List<Comment>) commentI.findAll();
	}

	@Override
	public Optional<Comment> getById(int id) {
		// TODO Auto-generated method stub
		return commentI.findById(id);
	}

	@Override
	public void modifyComment(Comment comment) {
		commentI.save(comment);
		
	}

	@Override
	public void deleteCommentById(int CommentById) {
		commentI.deleteById(CommentById);
		
	}

}
