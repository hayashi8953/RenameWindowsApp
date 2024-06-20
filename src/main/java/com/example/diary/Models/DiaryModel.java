package com.example.diary.Models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//  エンティティモデルクラス
@Entity
@Component
public class DiaryModel {

    //  各種保持するフィールド
    @Id
    private Long id;
    private TagType tagType;
    private String mainString;
    private LocalDateTime dateTime;
    private Integer emphasis;

    //  ゲッターセッター
    public void setId(Long id){
        this.id = id;
    }
    public void setTagType(TagType tagType){
        this.tagType = tagType;
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
    public TagType getTagType(){
        return tagType;
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

    //  Id以外を引数にとるコンストラクタ
    public DiaryModel(TagType tag, String main, LocalDateTime date, int emphasis){
        this.tagType = tag;
        this.mainString = main;
        this.dateTime = date;
        this.emphasis = emphasis;
    }

    //  dateTimeをFormatして返す
    public String getFormattedDateTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return this.dateTime.format(dtf);
    }

    //  emphasisが1なら有、0なら無
    public String getFormattedEmphasis(){
        return this.emphasis == 1 ? "有" : "無";
    }

    //  全てのフィールドをString戻り値で返す
    public String getAllString() throws NullPointerException{

        StringBuilder sb = new StringBuilder();
        sb.append(id == null ? "idが空です" : id);
        sb.append(", ");
        sb.append(mainString);
        sb.append(", ");
        sb.append(tagType);
        sb.append(", ");
        sb.append(dateTime == null ? "dateTimeが空です" : dateTime.toString());
        sb.append(", ");
        sb.append(emphasis.toString());
        return sb.toString();
    }

}

