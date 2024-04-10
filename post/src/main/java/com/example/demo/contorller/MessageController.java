package com.example.demo.contorller;

import com.example.demo.entity.Message;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/{messageId}")
    public Message getMessageById(@PathVariable Integer messageId) {
        return messageService.getMessageById(messageId);
    }

    @PostMapping
    public Message addMessage(@RequestBody Message message) {
        messageService.addMessage(message);
        return message;
    }
}
