package com.quizmanagement.blog.service.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.quizmanagement.blog.service.entities.Blog;
import com.quizmanagement.blog.service.services.IblogService;

@RestController
@CrossOrigin(origins = "http://BLOG-SERVICE")
@RequestMapping("/blog")
public class RestBlog {

	
	
	@Autowired
	IblogService blogService;


	//http://localhost:8081/SpringMVC/servlet/ajouterBlog
	@PostMapping("/ajouterBlog")
	@ResponseBody
	public Blog ajouterBlog(@RequestBody Blog b)
	{
		blogService.ajouterBlog(b);
		return b;
	}
	
	@GetMapping("/getallBlog")
	@ResponseBody
	public List<Blog> getAllBlog()
	{
		
		return blogService.getAll();
	}
	@GetMapping("/getBlog/{id}")
	@ResponseBody
	public Optional<Blog> getBlog(@PathVariable("id") int id)
	{
		
		return blogService.getById(id);
	}

	@PutMapping("/modifyBlog/{id}")
	@ResponseBody
	public Blog modifyBlog(@RequestBody Blog b , @PathVariable("id") int id)
	{
		blogService.modifyBlog(b);
		return b;
	}
	@DeleteMapping("/deletBlog/{id}")
	@ResponseBody
	public String deletBlog(@PathVariable("id") int id)
	{
		
		blogService.deleteBlogById(id);
		return "succ";
	}

	
}
