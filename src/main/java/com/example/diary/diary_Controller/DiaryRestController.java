package com.example.diary.diary_Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.diary.diary_Sql.DiaryService;

@RestController
public class DiaryRestController {
    //  Serviceクラス
    DiaryService diaryService;

    public DiaryRestController(DiaryService diaryService){
        this.diaryService = diaryService;
    }

    //  削除を行うdeleteページ
    //  javascriptから値を受け取る(json形式, HTTPレスポンスボディ)
    @ResponseBody
    @PostMapping("/delete")
    public ResponseEntity<String> postMethodName(@RequestBody String id) {
        Long parseLong = Long.parseLong(id);
        diaryService.exeDelete(parseLong);
        return ResponseEntity.ok().body("deleteは正常に終了しました");
    }

}
