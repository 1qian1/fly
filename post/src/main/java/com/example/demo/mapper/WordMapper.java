package com.example.demo.mapper;

import com.example.demo.entity.Word;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface WordMapper {
    @Select("SELECT * FROM words")
    List<Word> findAll();

    @Select("   SELECT * FROM Words WHERE word_class LIKE CONCAT('%', #{tp}, '%');")
    List<Word> findTp(String tp);
}
