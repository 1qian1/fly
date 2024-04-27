package com.example.demo.contorller;
import com.example.demo.entity.Answer;
import com.example.demo.entity.Word;
import com.example.demo.mapper.WordMapper;
import com.example.demo.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/words")
public class WordController {
    @Autowired
    private WordService wordService;
    @GetMapping
    public List<Word> getAllWord() {
        return wordService.getAllWord();
    }
    @GetMapping("/{tp}")
    public List<Word> getWordbytp(@PathVariable String tp) {
        return wordService.getWordbytp(tp);
    }

}
