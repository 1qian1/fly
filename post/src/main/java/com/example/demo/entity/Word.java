package com.example.demo.entity;

import java.util.Date;

public class Word {
    private Integer id;
    private String name;
    private Integer cp;
    private String spelling;
    private String cx;
    private String meaning;
    private String englishExample;
    private String chineseExample;
    private String wordClass;
    private String soundSource;

    public Word() {
        // 默认构造函数
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
 public Integer getCp(){return cp;}
    public  void setCp(Integer cp){this.cp=cp;}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpelling() {
        return spelling;
    }

    public void setSpelling(String spelling) {
        this.spelling = spelling;
    }

    public String getCx() {
        return cx;
    }

    public void setCx(String cx) {
        this.cx = cx;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getEnglishExample() {
        return englishExample;
    }

    public void setEnglishExample(String englishExample) {
        this.englishExample = englishExample;
    }

    public String getChineseExample() {
        return chineseExample;
    }

    public void setChineseExample(String chineseExample) {
        this.chineseExample = chineseExample;
    }

    public String getWordClass() {
        return wordClass;
    }

    public void setWordClass(String wordClass) {
        this.wordClass = wordClass;
    }

    public String getSoundSource() {
        return soundSource;
    }

    public void setSoundSource(String soundSource) {
        this.soundSource = soundSource;
    }
}
