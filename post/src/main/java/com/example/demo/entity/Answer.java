package com.example.demo.entity;

import java.util.Date;

public class Answer {
    private Integer answerId;
    private Integer questionId;
    private Integer userId;
    private String answerContent;
    private Date answerDate;
    private String userNickname; // 新增用户昵称字段
    private String questionContent;//新增问题内容
    // Getters and Setters

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public Date getAnswerDate() {
        return answerDate;
    }

    public void setAnswerDate(Date answerDate) {
        this.answerDate = answerDate;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }
    public String getQuestionContent(){
        return questionContent;
    }
    public void setQuestionContent(String questionContent)
    {
        this.questionContent=questionContent;
    }
}
