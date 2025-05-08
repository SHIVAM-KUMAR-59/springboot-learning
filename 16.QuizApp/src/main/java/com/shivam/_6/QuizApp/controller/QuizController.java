package com.shivam._6.QuizApp.controller;

import com.shivam._6.QuizApp.model.Question;
import com.shivam._6.QuizApp.model.QuestionWrapper;
import com.shivam._6.QuizApp.model.Response;
import com.shivam._6.QuizApp.service.QuizService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private QuizService service;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int num, @RequestParam String title){

        return service.createQuiz(category, num, title);
    }

    @GetMapping("get/{quizId}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable int quizId){
        return service.getQuiz(quizId);
    }

    @PostMapping("submit/{quizId}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable int quizId, @RequestBody List<Response> responses){
        return service.submitQuiz(quizId, responses);
    }

}
