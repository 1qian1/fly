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
    public List<Question> getAllQuestionsWithUserNickname() {
        return questionMapper.findAllWithUserNicknameAndAnswerCount();
    }

    // 新增发布问题的方法
    @PostMapping
    public Question addQuestion(@RequestBody Question question) {
        questionMapper.insert(question);
        return question; // 返回已插入的问题对象，或根据需要返回其他信息
    }

    // 根据问题ID查询问题内容的请求处理方法
    @PostMapping("/{questionId}")
    public Question findById(@PathVariable Integer questionId) {
        return questionMapper.findById(questionId);
    }
    // 其他请求方法...
}
