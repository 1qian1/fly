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



    // 其他请求方法...
}
