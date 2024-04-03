package com.example.demo.contorller;

import com.example.demo.entity.Answer;
import com.example.demo.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answers")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @GetMapping
    public List<Answer> getAllAnswers() {
        return answerService.getAllAnswers();
    }

    @GetMapping("/{answerId}")
    public Answer getAnswerById(@PathVariable Integer answerId) {
        return answerService.getAnswerById(answerId);
    }
    @GetMapping("/qq/{questionId}")
    public List<Answer>  getAnswerByqId(@PathVariable Integer questionId) {
        return answerService.getAnswerByqId(questionId);
    }
}
