package com.shivam._72.Quiz_Service.service;


import com.shivam._72.Quiz_Service.feign.QuizInterface;
import com.shivam._72.Quiz_Service.model.QuestionWrapper;
import com.shivam._72.Quiz_Service.model.Quiz;
import com.shivam._72.Quiz_Service.model.Response;
import com.shivam._72.Quiz_Service.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizRepository repository;

    @Autowired
    private QuizInterface quizInterface;


    public ResponseEntity<String> createQuiz(String category, int num, String title){

        List<Integer> questions = quizInterface.getQuestionsForQuiz(category, num).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        repository.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuiz(int  quizId){
        try{
            Quiz quiz = repository.findById(quizId).get();
            List<Integer> questionIds = quiz.getQuestions();
            ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionsForId(questionIds);

            return questions;
        } catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Integer> submitQuiz(int quizId, List<Response> responses){

        ResponseEntity<Integer> score = quizInterface.getScore(responses);


        return score;
    }
}
