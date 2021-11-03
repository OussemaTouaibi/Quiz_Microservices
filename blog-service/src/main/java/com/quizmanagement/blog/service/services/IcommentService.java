package com.quizmanagement.blog.service.services;

import java.util.List;
import java.util.Optional;

import com.quizmanagement.blog.service.entities.Comment;

public interface IcommentService {
	public void ajouterComment(Comment comment);
	public List<Comment> getAll();
	public Optional<Comment> getById(int id);
	public void modifyComment(Comment comment);

	public void deleteCommentById(int CommentById);

}
