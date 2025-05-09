package com.shivam._72.Quiz_Service.controller;


import com.shivam._72.Quiz_Service.model.QuestionWrapper;
import com.shivam._72.Quiz_Service.model.QuizDto;
import com.shivam._72.Quiz_Service.model.Response;
import com.shivam._72.Quiz_Service.service.QuizService;
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
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){

        return service.createQuiz(quizDto.getCategory(), quizDto.getNum(), quizDto.getTitle());
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
