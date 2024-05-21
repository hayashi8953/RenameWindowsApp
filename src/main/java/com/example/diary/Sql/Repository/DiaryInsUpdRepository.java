package com.example.diary.Sql.Repository;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.diary.Models.DiaryDataModel;

//  Repositoryクラス
@Repository
public class DiaryInsUpdRepository extends BaseRepository{

    // jdbcの情報を受け取るコンストラクタ
    public DiaryInsUpdRepository(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    //  インサート文を行う
    public void insert(DiaryDataModel ddm) throws DataAccessException, NullPointerException{
        System.out.printf("DiaryInsUpdRepository.insertを通過%n%s", ddm.getAllString());
        jdbcTemplate.update("INSERT INTO MyDiary (tagType, mainString, dateTime, emphasis) VALUES (?, ?, ?, ?)",
            ddm.getTagType().getValue(), ddm.getMainString(), ddm.getDateTime(), ddm.getEmphasis());
        System.out.println("insert完了");
    }

    //  アップデート文を行う
    public void update(DiaryDataModel ddm) throws DataAccessException, NullPointerException{
        System.out.printf("DiaryInsUpdRepository.updateを通過%n%s", ddm.getAllString());
        jdbcTemplate.update("UPDATE MyDiary SET tagType = ?, mainString = ?, emphasis = ? WHERE Id = ?",
            ddm.getTagType().getValue(), ddm.getMainString(), ddm.getEmphasis(), ddm.getId());
        System.out.println("update完了");
    }

    //  デリート文を行う
    public void delete(Long num) throws DataAccessException{
        System.out.println("DiaryRepository.deleteを通過");
        jdbcTemplate.update("DELETE FROM MyDiary WHERE Id = ?", num);
        System.out.println("delete完了");
    }
    
}
