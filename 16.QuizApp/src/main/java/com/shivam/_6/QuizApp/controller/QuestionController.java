package com.shivam._6.QuizApp.controller;

import com.shivam._6.QuizApp.model.Question;
import com.shivam._6.QuizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService service;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return service.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return service.getQuestionsByCategory(category);
    }

    @PostMapping("/add")
    public ResponseEntity<String> insertQuestion(@RequestBody Question question){
        return service.insertQuestion(question);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteQuestion(@RequestBody Question question){
        return service.deleteQuestion(question);
    }

}
