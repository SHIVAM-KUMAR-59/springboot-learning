package com.shivam._6.QuizApp.service;

import com.shivam._6.QuizApp.model.Question;
import com.shivam._6.QuizApp.model.QuestionWrapper;
import com.shivam._6.QuizApp.model.Quiz;
import com.shivam._6.QuizApp.model.Response;
import com.shivam._6.QuizApp.repository.QuestionRepository;
import com.shivam._6.QuizApp.repository.QuizRepository;
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
    private QuestionRepository questionRepository;

    public ResponseEntity<String> createQuiz(String category, int num, String title){

        List<Question> questions = questionRepository.findRandomQuestionsByCategory(category, num);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        repository.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuiz(int  quizId){
        try{
            Optional<Quiz> quiz = repository.findById(quizId);
            List<Question> questionsFromDB = quiz.get().getQuestions();
            List<QuestionWrapper> questionWrappers = new ArrayList<>();
            for(Question question : questionsFromDB){
                QuestionWrapper q = new QuestionWrapper(question.getId(), question.getQuestionTitle(), question.getOption1(), question.getOption2(), question.getOption3(), question.getOption4());
                questionWrappers.add(q);
            }
            return new ResponseEntity<>(questionWrappers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Integer> submitQuiz(int quizId, List<Response> responses){

        Optional<Quiz> quiz = repository.findById(quizId);
        List<Question> questions = quiz.get().getQuestions();
        int score = 0;
        int i = 0;
        for(Response response : responses){
            if(response.getResponse().equals(questions.get(i).getRightAnswer())){
                score++;
            }
            i++;
        }
        return new ResponseEntity<>(score, HttpStatus.OK);
    }
}
