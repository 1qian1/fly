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

    public List<Question> findAll() {
        return questionMapper.findAll();
    }

    public Question findById(Integer questionId) {
        return questionMapper.findById(questionId);
    }

    public void add(Question question) {
        questionMapper.add(question);
    }

    public void update(Question question) {
        questionMapper.update(question);
    }

    public void delete(Integer questionId) {
        questionMapper.delete(questionId);
    }
}
