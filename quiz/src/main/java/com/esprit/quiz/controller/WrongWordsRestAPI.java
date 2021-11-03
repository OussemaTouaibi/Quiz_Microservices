package com.esprit.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.esprit.quiz.entity.WrongWords;
import com.esprit.quiz.service.WrongWordsService;


@RestController
@CrossOrigin(origins = "http://COMMENT-SERVICE")
@RequestMapping("/done")
public class WrongWordsRestAPI {

	@Autowired
	private WrongWordsService wrongWordsService;

	@GetMapping(value = "/read", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<WrongWords>> getWrongWords() {
		return new ResponseEntity<>(wrongWordsService.getAllWrongWords(), HttpStatus.OK);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> createWrongWords(@RequestBody WrongWords wrongWords) throws Exception {
		return new ResponseEntity<>(wrongWordsService.addWrongWords(wrongWords), HttpStatus.OK);

	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteWrongWords(@PathVariable(value = "id") int id) {
		return new ResponseEntity<>(wrongWordsService.deleteWrongWords(id), HttpStatus.OK);
	}

}
