package com.example.demo.service;

import com.example.demo.entity.Question;
import com.example.demo.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    public List<Question> getAllQuestionsWithUserNicknameAndAnswerCount() {
        return questionMapper.findAllWithUserNicknameAndAnswerCount();
    }

    public void addQuestion(Question question) {
        questionMapper.insert(question);
    }

    // 根据问题ID查询问题内容
    public Question findById(Integer questionId) {
        return questionMapper.findById(questionId);
    }
    // 其他方法...
}
