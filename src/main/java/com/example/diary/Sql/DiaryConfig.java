package com.example.diary.Sql;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import com.example.diary.Sql.Repository.BaseRepository;

@Configuration
public class DiaryConfig {

    @Bean
    public JdbcTemplate jdbcTemplate(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        JdbcTemplate jdbcTemplate;
        try{
            BaseRepository.databaseAccess = "com.mysql.cj.jdbc.Driver";
            dataSource.setDriverClassName(BaseRepository.databaseAccess);
            dataSource.setUrl("jdbc:mysql://localhost:3306/my_database");
            dataSource.setUsername("root");
            dataSource.setPassword("EEC238XrztYs");
            jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.execute("SELECT 1");  // 接続のテスト
        }
        catch (Exception e){
            BaseRepository.databaseAccess = "org.hsqldb.jdbcDriver";
            dataSource.setDriverClassName(BaseRepository.databaseAccess);
            dataSource.setUrl("jdbc:hsqldb:mem:test");
            dataSource.setUsername("SA");
            dataSource.setPassword("");
            jdbcTemplate = new JdbcTemplate(dataSource);
        }
        return jdbcTemplate;

    }

    
}
