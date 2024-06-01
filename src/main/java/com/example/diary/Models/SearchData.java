package com.example.diary.Models;

import java.time.LocalDate;

//  検索の情報を受け渡しするクラス
public class SearchData {

    //  タグ情報
    private String tagType;

    //  検索する月
    private LocalDate searchDay;

    public void setTagType(String tagType){
        this.tagType = tagType;
    }
    public void setSearchDay(LocalDate searchDay){
        this.searchDay = searchDay;
    }
    public String getTagType(){
        return tagType;
    }
    public LocalDate getSearchDay(){
        return searchDay;
    }

    public LocalDate getSearchLastDay(){
        return searchDay.plusMonths(1);
    }
}
