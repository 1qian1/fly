package com.example.demo.mapper;

import com.example.demo.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {

    @Select("SELECT q.question_id, q.user_id, q.question_content, q.question_date, " +
            "u.nickname AS userNickname, COUNT(a.answer_id) AS answerCount " +
            "FROM questions q " +
            "JOIN users u ON q.user_id = u.user_id " +
            "LEFT JOIN answers a ON q.question_id = a.question_id " +
            "GROUP BY q.question_id")
    @Results({
            @Result(property = "questionId", column = "question_id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "questionContent", column = "question_content"),
            @Result(property = "questionDate", column = "question_date"),
            @Result(property = "userNickname", column = "userNickname"),
            @Result(property = "answerCount", column = "answerCount")
    })
    List<Question> findAllWithUserNicknameAndAnswerCount();



    // 其他方法...
}
