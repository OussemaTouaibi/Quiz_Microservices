package com.quizmanagement.blog.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.quizmanagement.blog.service.entities.Blog;
@Repository
public interface blogRepository extends CrudRepository<Blog, Integer>{

} 
