package com.example.diary.diary_Models;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Component
public class DiaryDataModel {
    @Id
    private Long id;
    private String tagString;
    private String mainString;
    private LocalDateTime dateTime;
    private Integer emphasis;

    public void setId(Long id){
        this.id = id;
    }
    public void setTagString(String tagString){
        this.tagString = tagString;
    }
    public void setMainString(String mainString){
        this.mainString = mainString;
    }
    public void setDateTime(LocalDateTime dateTime){
        this.dateTime = dateTime;
    }
    public void setEmphasis(int emphasis){
        this.emphasis = emphasis;
    }
    public Long getId(){
        return id;
    }
    public String getTagString(){
        return tagString;
    }
    public String getMainString(){
        return mainString;
    }
    public LocalDateTime getDateTime(){
        return dateTime;
    }
    public Integer getEmphasis(){
        return emphasis;
    }

    public DiaryDataModel(){
        
    }
    public DiaryDataModel(String tag, String main, LocalDateTime date, int emphasis){
        this.tagString = tag;
        this.mainString = main;
        this.dateTime = date;
        this.emphasis = emphasis;
    }
    public String getAllString(){

        StringBuilder sb = new StringBuilder();
        sb.append(id == null ? "idが空です" : id);
        sb.append(", ");
        sb.append(mainString);
        sb.append(", ");
        sb.append(tagString);
        sb.append(", ");
        sb.append(dateTime == null ? "dateTimeが空です" : dateTime.toString());
        sb.append(", ");
        sb.append(emphasis.toString());
        return sb.toString();
    }

}
