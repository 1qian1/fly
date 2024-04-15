package com.example.demo.service;

import com.example.demo.entity.News;
import com.example.demo.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsMapper newsMapper;

    public List<News> getAllNews() {
        return newsMapper.findAll();
    }

    public News getNewsById(Integer newsId) {
        return newsMapper.findById(newsId);
    }

    public void addNews(News news) {
        newsMapper.insert(news);
    }
}
