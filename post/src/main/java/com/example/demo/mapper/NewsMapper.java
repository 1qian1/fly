package com.example.demo.mapper;

import com.example.demo.entity.News;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NewsMapper {

    @Select("SELECT * FROM News")
    List<News> findAll();

    @Select("SELECT * FROM News WHERE news_id = #{newsId}")
    News findById(Integer newsId);

    @Insert("INSERT INTO News (user_id, news_title, news_content, publish_date) " +
            "VALUES (#{userId}, #{newsTitle}, #{newsContent}, #{publishDate})")
    void insert(News news);
}
