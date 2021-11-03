package com.esprit.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.esprit.quiz.entity.Commentaire;
import com.esprit.quiz.service.CommentaireService;


@RestController
@CrossOrigin("*")

public class CommentaireRestAPI {

	@Autowired
	private CommentaireService commentaireService;

	@GetMapping(value = "/commentaires", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Commentaire>> getCommentaires() {
		return new ResponseEntity<>(commentaireService.getAllCommentaire(), HttpStatus.OK);
	}

	@PostMapping(value = "/commentaires/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> createCommentaire(@PathVariable(value = "id") int id,
			@RequestBody Commentaire commentaire) throws Exception {
		return new ResponseEntity<>(commentaireService.addCommentaire(id, commentaire), HttpStatus.OK);

	}

	@DeleteMapping(value = "/commentaires/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteCommentaire(@PathVariable(value = "id") int id) {
		return new ResponseEntity<>(commentaireService.deleteCommentaire(id), HttpStatus.OK);
	}

	@PutMapping(value = "/commentaires/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> updateCommentaire(@PathVariable(value = "id") int id,
			@RequestBody Commentaire commentaire) {
		return new ResponseEntity<>(commentaireService.updateCommentaire(id, commentaire), HttpStatus.OK);
	}

	@PostMapping(value = "/commentaires/like/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> like(@PathVariable(value = "id") int id) throws Exception {

		return new ResponseEntity<>(commentaireService.likeCommentaire(id), HttpStatus.OK);
	}

	@PostMapping(value = "/commentaires/dislike/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> dislike(@PathVariable(value = "id") int id) throws Exception {

		return new ResponseEntity<>(commentaireService.dislikeCommentaire(id), HttpStatus.OK);
	}

}
