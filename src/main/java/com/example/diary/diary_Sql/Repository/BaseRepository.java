package com.example.diary.diary_Sql.Repository;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class BaseRepository {

    protected final JdbcTemplate jdbcTemplate;

    //  jdbcの情報を受け取るコンストラクタ
    protected BaseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
