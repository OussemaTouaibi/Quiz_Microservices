package com.quizmanagement.blog.service.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizmanagement.blog.service.entities.Blog;
import com.quizmanagement.blog.service.repository.blogRepository;

@Service
public class blogServiceImpl implements IblogService {
	
	@Autowired blogRepository b;

	@Override
	public List<Blog> getAll() {
		// TODO Auto-generated method stub
		return (List<Blog>) b.findAll();
	}

	@Override
	public Optional<Blog> getById(int id) {
		// TODO Auto-generated method stub
		return b.findById(id);
	}

	@Override
	public void ajouterBlog(Blog blog) {
		 b.save(blog);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBlogById(int BlogId) {
b.deleteById(BlogId);		
	}

	@Override
	public void modifyBlog(Blog blog) {
          b.save(blog);		
	}




	
}
