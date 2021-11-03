package com.quizmanagement.blog.service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.quizmanagement.blog.service.entities.Comment;
import com.quizmanagement.blog.service.services.IcommentService;
@RestController
@CrossOrigin(origins = "http://BLOG-SERVICE")
@RequestMapping("/blog")
public class RestComment {
	
	@Autowired IcommentService com;


	
	//http://localhost:8081/SpringMVC/servlet/ajoutercomment
		@PostMapping("/ajoutercomment")
		@ResponseBody
		public Comment ajouterComment(@RequestBody Comment c)
		{
			com.ajouterComment(c);
			return c;
		}
		
		@GetMapping("/getallComment")
		@ResponseBody
		public List<Comment> getAllComment()
		{
			
			return com.getAll();
		}
		@GetMapping("/getComment/{id}")
		@ResponseBody
		public Optional<Comment> getComment(@PathVariable("id") int id)
		{
			
			return com.getById(id);
		}

		@PutMapping("/modifyComment/{id}")
		@ResponseBody
		public Comment modifyComment(@RequestBody Comment b, @PathVariable("id") int id)
		{
			com.modifyComment(b);
			return b;
		}
		@DeleteMapping("/deletComment/{id}")
		@ResponseBody
		public String deletComment(@PathVariable("id") int id)
		{
			
			com.deleteCommentById(id);
			return "succ";
		}

}
