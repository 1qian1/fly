package com.example.demo.contorller;

import com.example.demo.entity.News;
import com.example.demo.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsMapper newsMapper;

    @GetMapping
    public List<News> findAll() {
        return newsMapper.findAll();
    }

    // 新增发布见闻的方法
    @PostMapping
    public News addNews(@RequestBody News news) {
        newsMapper.insert(news);
        return news; // 返回已插入的见闻对象，或根据需要返回其他信息
    }

    // 根据见闻ID查询见闻内容的请求处理方法
    @PostMapping("/{newsId}")
    public News findById(@PathVariable Integer newsId) {
        return newsMapper.findById(newsId);
    }
    // 其他请求方法...
}
