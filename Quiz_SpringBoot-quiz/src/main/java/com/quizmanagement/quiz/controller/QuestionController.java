package com.quizmanagement.quiz.controller;

import com.quizmanagement.quiz.model.Question;
import com.quizmanagement.quiz.model.Quiz;
import com.quizmanagement.quiz.service.QuestionService;
import com.quizmanagement.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://QUIZ-SERVICE")
@RequestMapping("/quiz")
public class QuestionController {

    @Autowired
    private QuestionService service;

    @Autowired
    private QuizService quizService;

    //add a question
    @PostMapping("/question")
    public ResponseEntity<Question> add(@RequestBody Question question){
        return ResponseEntity.ok(this.service.addQuestion(question));
    }

    //update question
    @PutMapping("/question")
    public ResponseEntity<Question> update(@RequestBody Question question){
        return ResponseEntity.ok(this.service.updateQuestion(question));
    }

    //get all questions of any quiz
    @GetMapping("/quiz/question/{qid}")
    public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("qid") Long qid){
//        Quiz quiz = new Quiz();
//        quiz.setqId(qid);
//        Set<Question> questionsOfQuiz = this.service.getQuestionsOfQuiz(quiz);
//        return ResponseEntity.ok(questionsOfQuiz);

        Quiz quiz = this.quizService.getQuiz(qid);
        Set<Question> questions = quiz.getQuestions();
        List list = new ArrayList(questions);
        if(list.size() > Integer.parseInt(quiz.getNumberOfQuestions())){
            list = list.subList(0,Integer.parseInt(quiz.getNumberOfQuestions()+1));
        }
        Collections.shuffle(list);
        return ResponseEntity.ok(list);
    }

    //get single question
    @GetMapping("/question/{quesId}")
    public Question get(@PathVariable("quesId") Long quesId){
        return this.service.getQuestion(quesId);
    }

    //delete question
    @DeleteMapping("/question/{quesId}")
    public void delete(@PathVariable("quesId") Long quesId){
        this.service.deleteQuestion(quesId);
    }
}
