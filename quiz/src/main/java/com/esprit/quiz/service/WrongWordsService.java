package com.esprit.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.esprit.quiz.entity.WrongWords;
import com.esprit.quiz.repository.WrongWordsRepository;


@Service
public class WrongWordsService {


    @Autowired
    private WrongWordsRepository wrongWordsRepository;

    public String addWrongWords(WrongWords wrongWords) throws Exception {
        wrongWordsRepository.save(wrongWords);
        return "Wrong word added";
    }

    public String deleteWrongWords(int id) {
        if (wrongWordsRepository.findById(id).isPresent()) {
            wrongWordsRepository.deleteById(id);
            return "Wrong Words deleted";
        }
        return "Wrong doesn't exist";
    }

    public List<WrongWords> getAllWrongWords() {
        List<WrongWords> wrongWords = wrongWordsRepository.findAll();
        return wrongWords;
    }

}
