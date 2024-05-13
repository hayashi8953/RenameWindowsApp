package com.example.diary.diary_Sql;

import java.time.LocalDateTime;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.diary.diary_Models.DiaryDataModel;;

@Service
public class DiaryService {
    @Autowired
    DiaryRepository dm;
    DiaryConfig dc;

    public DiaryService(){
        dc = new DiaryConfig();
        DataSource dataSource = dc.dataSource();
        JdbcTemplate jdbcTemplate = dc.jdbcTemplate(dataSource);
        dm = new DiaryRepository(jdbcTemplate);
    }

    public DiaryDataModel exeInsert(DiaryDataModel ddm) {
        LocalDateTime now = LocalDateTime.now();
        ddm.setDateTime(now);
        System.out.println("Service.exeInsertを通過");
        dm.insert(ddm);
        return ddm;
    }

    public void exeUpdate(DiaryDataModel ddm){
        
        dm.update(ddm);
    }

    public DiaryDataModel exeSelectOfOne(Long num){
        return dm.selectOfOne(num);
    }

    public List<DiaryDataModel> exeSelectAll(){
        return dm.selectAll();
    }
}
