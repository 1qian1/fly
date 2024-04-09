package com.example.demo.service;

import com.example.demo.entity.Answer;
import com.example.demo.mapper.AnswerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    @Autowired
    private AnswerMapper answerMapper;

    public List<Answer> getAllAnswers() {
        return answerMapper.findAll();
    }

    public Answer getAnswerById(Integer answerId) {
        return answerMapper.findById(answerId);
    }
    public List<Answer>  getAnswerByqId(Integer questionId) {
        return answerMapper.findByqId(questionId);
    }
    // 添加新增回答的方法
    public void addAnswer(Answer answer) {
        answerMapper.addAnswer(answer);

    }

}
