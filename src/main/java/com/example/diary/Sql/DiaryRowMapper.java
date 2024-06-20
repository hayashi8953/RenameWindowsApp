package com.example.diary.Sql;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.diary.Models.DiaryModel;
import com.example.diary.Models.TagType;

//  マッパークラス
public class DiaryRowMapper implements RowMapper<DiaryModel>{
    @Override
    public DiaryModel mapRow(ResultSet rs, int rowNum) throws IllegalArgumentException{
        try{
            DiaryModel ddm = new DiaryModel();
            ddm.setId(rs.getLong("Id"));
            ddm.setTagType(stringToTagType(rs.getString("tagType")));
            ddm.setMainString(rs.getString("mainString"));
            ddm.setDateTime(rs.getTimestamp("dateTime").toLocalDateTime());
            ddm.setEmphasis(rs.getInt("emphasis"));
            return ddm;
        }catch (SQLException e){
            throw new IllegalArgumentException("MapRowエラー", e);
        }
    }

    //  Stringをenumに変換する
    public TagType stringToTagType(String str) throws IllegalArgumentException{
        for (TagType ty : TagType.values()) {
            if (ty.getValue().equals(str)) {
                return ty;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + str);
    }
}
