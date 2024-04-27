package com.example.demo.service;
import com.example.demo.entity.Word;
import com.example.demo.mapper.WordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WordService {
    @Autowired
    private  WordMapper wordMapper;

    public  List<Word> getAllWord() {
        return wordMapper.findAll();
    }
    public  List<Word> getWordbytp(String tp){return wordMapper.findTp(tp);}
}
