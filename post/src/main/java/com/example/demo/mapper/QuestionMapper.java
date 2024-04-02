package com.example.demo.mapper;

import com.example.demo.entity.Question;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QuestionMapper {
    @Select("SELECT q.question_id, q.user_id, q.question_content, q.question_date, " +
            "u.nickname AS userNickname, COUNT(a.answer_id) AS answerCount " +
            "FROM questions q " +
            "JOIN users u ON q.user_id = u.user_id " +
            "LEFT JOIN answers a ON q.question_id = a.question_id " +
            "GROUP BY q.question_id")
    List<Question> findAll();


    @Select("SELECT * FROM questions WHERE question_id = #{questionId}")
    Question findById(Integer questionId);

    @Insert("INSERT INTO questions (user_id, question_content, question_date) " +
            "VALUES (#{userId}, #{questionContent}, #{questionDate})")
    void add(Question question);

    @Update("UPDATE questions SET user_id = #{userId}, question_content = #{questionContent}, " +
            "question_date = #{questionDate} WHERE question_id = #{questionId}")
    void update(Question question);

    @Delete("DELETE FROM questions WHERE question_id = #{questionId}")
    void delete(Integer questionId);
}
