package  com.shivam._71.Question_Service.controller;


import com.shivam._71.Question_Service.model.Question;
import com.shivam._71.Question_Service.model.QuestionWrapper;
import com.shivam._71.Question_Service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private com.shivam._71.Question_Service.service.QuestionService service;

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

    // TODO: Generate questions for quiz
    @GetMapping("/generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String category, @RequestParam int num){
        return service.getQuestionsForQuiz(category, num);
    }

    // TODO: Get questions based on question ID
    @PostMapping("/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsForId(@RequestBody List<Integer> questionIds){
        return service.getQuestionsForId(questionIds);
    }

    // TODO: Calculate score
    @PostMapping("/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
        return service.getScore(responses);
    }

}
