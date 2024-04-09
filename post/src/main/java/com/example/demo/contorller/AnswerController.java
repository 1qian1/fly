package com.example.demo.contorller;

import com.example.demo.entity.Answer;
import com.example.demo.entity.Question;
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
    public List<Answer> getAnswerByqId(@PathVariable Integer questionId) {
        return answerService.getAnswerByqId(questionId);
    }
@PostMapping
    public Answer addAnswer(@RequestBody Answer answer) {
        // 这里假设您的answerService.addAnswer方法会将answer添加到数据库并返回添加的answer对象
         answerService.addAnswer(answer);
         return answer;
    }


}
