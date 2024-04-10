package com.example.demo.service;

import com.example.demo.entity.Message;
import com.example.demo.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageMapper messageMapper;

    public List<Message> getAllMessages() {
        return messageMapper.findAll();
    }

    public Message getMessageById(Integer messageId) {
        return messageMapper.findById(messageId);
    }

    public void addMessage(Message message) {
        messageMapper.addMessage(message);
    }
}
