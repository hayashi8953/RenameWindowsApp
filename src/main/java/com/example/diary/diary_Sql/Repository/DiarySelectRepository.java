package com.example.diary.diary_Sql.Repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.diary.diary_Models.DiaryDataModel;
import com.example.diary.diary_Sql.DiaryRowMapper;

public class DiarySelectRepository extends BaseRepository{

    public DiarySelectRepository(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }
    
    //  Idを検索して一件だけ取り出すセレクト文
    public DiaryDataModel selectOfOne(Long num) throws DataAccessException, IllegalArgumentException{
        DiaryRowMapper rowMapper = new DiaryRowMapper();
        System.out.println("DiarySelectRepository.selectOfOneを通過");
        DiaryDataModel ddm = jdbcTemplate.queryForObject("SELECT * FROM MyDiary WHERE Id = ?", rowMapper, num);
        System.out.println("selectOfOne完了");
        return ddm;
    }
    
    //  直近30日を取り出すセレクト文
    public List<DiaryDataModel> select30days() throws DataAccessException, IllegalArgumentException{
        DiaryRowMapper rowMapper = new DiaryRowMapper();
        System.out.println("DiarySelectRepository.select30daysを通過");
        List<DiaryDataModel> list = jdbcTemplate.query("SELECT * FROM MyDiary WHERE dateTime >= NOW() - INTERVAL 30 DAY ORDER BY emphasis DESC, Id DESC",rowMapper);
        System.out.println("selectAll完了");
        return list;
    }
}
