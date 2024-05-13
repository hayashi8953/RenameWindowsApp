package com.example.diary.diary_Sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.example.diary.diary_Models.DiaryDataModel;

public class DiaryRowMapper implements RowMapper<DiaryDataModel>{
    @Override
    public DiaryDataModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        DiaryDataModel ddm = new DiaryDataModel();

        ddm.setId(rs.getLong("Id"));
        ddm.setTagString(rs.getString("tagString"));
        ddm.setMainString(rs.getString("mainString"));
        ddm.setDateTime(rs.getTimestamp("dateTime").toLocalDateTime());
        ddm.setEmphasis(rs.getInt("emphasis"));
        return ddm;
    }
}
