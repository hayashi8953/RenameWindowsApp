package com.example.diary.Sql;

import java.time.LocalDateTime;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.diary.Models.DiaryModel;
import com.example.diary.Models.SearchData;
import com.example.diary.Sql.Repository.DemoRepository;
import com.example.diary.Sql.Repository.DiaryInsUpdRepository;
import com.example.diary.Sql.Repository.DiarySelectRepository;

//  Serviceクラス
@Service
public class DiaryService {

    private final DiaryInsUpdRepository dir;
    private final DiarySelectRepository dsr;
    private final DemoRepository dr;

    // コンストラクタ ここでjdbcにデータベースと接続する情報を入れる
    public DiaryService(DiaryInsUpdRepository dir, DiarySelectRepository dsr, DemoRepository dr) {
        this.dir = dir;
        this.dsr = dsr;
        this.dr = dr;
    }

    // 受け取ったモデルクラスを調整して、
    // リポジトリクラスのインサートメソッドを起動する
    public DiaryModel exeInsert(DiaryModel ddm) throws DataAccessException {
        LocalDateTime now = LocalDateTime.now();
        ddm.setDateTime(now);
        dir.insert(ddm);
        return ddm;
    }

    // リポジトリクラスのアップデートメソッドを起動する
    public void exeUpdate(DiaryModel ddm) throws DataAccessException {
        dir.update(ddm);
    }

    // リポジトリクラスのデリートメソッドを起動する
    public void exeDelete(Long num) throws DataAccessException {
        dir.delete(num);
    }

    // リポジトリクラスの一件セレクト文を起動する
    public DiaryModel exeSelectOfOne(Long num) throws DataAccessException {
        return dsr.selectOfOne(num);
    }

    // リポジトリクラスの直近30日のセレクト文を起動する
    public List<DiaryModel> exeSelect30days() throws DataAccessException {
        return dsr.select30days();
    }

    // リポジトリクラスの直近30日のセレクト文を起動する
    public List<DiaryModel> exeSelectAll() throws DataAccessException {
        return dsr.selectAll();
    }

    // リポジトリクラスの直近30日のセレクト文を起動する
    public List<DiaryModel> exeSelectAll(SearchData sData)
            throws DataAccessException {
        return dsr.selectAll(sData);
    }
}
