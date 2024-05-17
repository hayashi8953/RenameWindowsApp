package com.example.diary.diary_Sql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import com.example.diary.diary_Models.*;

//  Repositoryクラス
@Repository
public class DiaryRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //  jdbcの情報を受け取るコンストラクタ
    public DiaryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //  インサート文を行う
    public void insert(DiaryDataModel ddm) throws DataAccessException, NullPointerException{
        System.out.println("DiaryRepository.insertを通過");
        System.out.println(ddm.getAllString());
        jdbcTemplate.update("INSERT INTO MyDiary (tagType, mainString, dateTime, emphasis) VALUES (?, ?, ?, ?)",
            ddm.getTagType().getValue(), ddm.getMainString(), ddm.getDateTime(), ddm.getEmphasis());
        System.out.println("insert完了");
    }

    //  アップデート文を行う
    public void update(DiaryDataModel ddm) throws DataAccessException, NullPointerException{
        System.out.println("DiaryRepository.updateを通過");
        System.out.println(ddm.getAllString());
        jdbcTemplate.update("UPDATE MyDiary SET tagType = ?, mainString = ?, emphasis = ? WHERE Id = ?",
            ddm.getTagType().getValue(), ddm.getMainString(), ddm.getEmphasis(), ddm.getId());
        System.out.println("update完了");
    }

    //  Idを検索して一件だけ取り出すセレクト文
    public DiaryDataModel selectOfOne(Long num) throws DataAccessException, IllegalArgumentException{
        DiaryRowMapper rowMapper = new DiaryRowMapper();
        System.out.println("DiaryRepository.selectOfOneを通過");
        DiaryDataModel ddm = jdbcTemplate.queryForObject("SELECT * FROM MyDiary WHERE Id = ?", rowMapper, num.intValue());
        System.out.println("selectOfOne完了");
        return ddm;
    }
    
    //  全件を取り出すセレクト文
    public List<DiaryDataModel> selectAll() throws DataAccessException, IllegalArgumentException{
        DiaryRowMapper rowMapper = new DiaryRowMapper();
        System.out.println("DiaryRepository.selectAllを通過");
        List<DiaryDataModel> list = jdbcTemplate.query("SELECT * FROM MyDiary ORDER BY emphasis DESC, Id DESC",rowMapper);
        System.out.println("selectAll完了");
        return list;
    }
    
}
