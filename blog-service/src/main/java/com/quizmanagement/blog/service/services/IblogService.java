package com.quizmanagement.blog.service.services;

import java.util.List;
import java.util.Optional;

import com.quizmanagement.blog.service.entities.Blog;

public interface IblogService {
	public void ajouterBlog(Blog blog);
	public List<Blog> getAll();
	public Optional<Blog> getById(int id);
	public void modifyBlog(Blog blog);

	public void deleteBlogById(int BlogId);
}
