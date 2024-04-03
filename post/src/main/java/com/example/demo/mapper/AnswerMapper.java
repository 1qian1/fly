package com.example.demo.mapper;

import com.example.demo.entity.Answer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AnswerMapper {

    @Select("SELECT * FROM Answers")
    List<Answer> findAll();

    @Select("SELECT * FROM Answers WHERE answer_id = #{answerId}")
    Answer findById(Integer answerId);
    @Select("SELECT * FROM Answers WHERE question_id = #{questionId}")
    List<Answer>  findByqId(Integer questionId);
}
