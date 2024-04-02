package com.example.demo.contorller;

import com.example.demo.entity.Question;
import com.example.demo.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionMapper questionMapper;

    @GetMapping
    public List<Question> getAllQuestions() {
        return questionMapper.findAll();
    }

    @GetMapping("/{questionId}")
    public Question getQuestionById(@PathVariable Integer questionId) {
        return questionMapper.findById(questionId);
    }

    @PostMapping
    public void addQuestion(@RequestBody Question question) {
        questionMapper.add(question);
    }

    @PutMapping("/{questionId}")
    public void updateQuestion(@PathVariable Integer questionId, @RequestBody Question question) {
        question.setQuestionId(questionId);
        questionMapper.update(question);
    }

    @DeleteMapping("/{questionId}")
    public void deleteQuestion(@PathVariable Integer questionId) {
        questionMapper.delete(questionId);
    }
}
