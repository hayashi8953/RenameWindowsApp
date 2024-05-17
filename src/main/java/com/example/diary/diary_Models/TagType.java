package com.example.diary.diary_Models;

public enum TagType {
    MEMO("メモ"),
    MEAL("食事"),
    EXERCISE("運動"),
    SLEEP("睡眠"),
    HOBBY("趣味");

    private String value;
    TagType(String value){
        this.value = value;
    }
    public String getValue() {
        return value;
    }

}
