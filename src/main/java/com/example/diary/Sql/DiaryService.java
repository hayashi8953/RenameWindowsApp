package com.example.diary.Sql;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.diary.Models.DiaryDataModel;
import com.example.diary.Sql.Repository.DiaryInsUpdRepository;
import com.example.diary.Sql.Repository.DiarySelectRepository;

//  Serviceクラス
@Service
public class DiaryService {

    private final DiaryInsUpdRepository dir;
    private final DiarySelectRepository dsr;

    // コンストラクタ ここでjdbcにデータベースと接続する情報を入れる
    public DiaryService(DiaryInsUpdRepository dir, DiarySelectRepository dsr) {
        this.dir = dir;
        this.dsr = dsr;
    }

    // 受け取ったモデルクラスを調整して、
    // リポジトリクラスのインサートメソッドを起動する
    public DiaryDataModel exeInsert(DiaryDataModel ddm) throws DataAccessException {
        LocalDateTime now = LocalDateTime.now();
        ddm.setDateTime(now);
        System.out.println("Service.exeInsertを通過");
        dir.insert(ddm);
        return ddm;
    }

    // リポジトリクラスのアップデートメソッドを起動する
    public void exeUpdate(DiaryDataModel ddm) throws DataAccessException {
        dir.update(ddm);
    }

    // リポジトリクラスのデリートメソッドを起動する
    public void exeDelete(Long num) throws DataAccessException {
        dir.delete(num);
    }

    // リポジトリクラスの一件セレクト文を起動する
    public DiaryDataModel exeSelectOfOne(Long num) throws DataAccessException {
        return dsr.selectOfOne(num);
    }

    // リポジトリクラスの直近30日のセレクト文を起動する
    public List<DiaryDataModel> exeSelect30days() throws DataAccessException {
        return dsr.select30days();
    }

    // リポジトリクラスの直近30日のセレクト文を起動する
    public List<DiaryDataModel> exeSelectAll() throws DataAccessException {
        return dsr.selectAll();
    }

    // リポジトリクラスの直近30日のセレクト文を起動する
    public List<DiaryDataModel> exeSelectAll(String tagType)
            throws DataAccessException, UnsupportedEncodingException, IllegalArgumentException {
        String formattedTagType = null;
        // tagType=の文字を切り取る
        if (tagType.startsWith("tagType=")) {
            // 送られてきた文字列をUTF-8に変換する
            String decodeTagType = java.net.URLDecoder.decode(tagType, "UTF-8");
            formattedTagType = decodeTagType.substring(8);

        } else {
            throw new IllegalArgumentException("無効な値が送られました");
        }
        return dsr.selectAll(formattedTagType);
    }
}
