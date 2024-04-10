package com.example.demo.mapper;

import com.example.demo.entity.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageMapper {

    @Select("SELECT * FROM Messages")
    List<Message> findAll();

    @Select("SELECT * FROM Messages WHERE message_id = #{messageId}")
    Message findById(Integer messageId);

    @Insert("INSERT INTO Messages (user_id, message_content, message_date) " +
            "VALUES (#{userId}, #{messageContent}, #{messageDate})")
    void addMessage(Message message);
}
