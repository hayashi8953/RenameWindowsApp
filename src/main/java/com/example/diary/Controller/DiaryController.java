package com.example.diary.Controller;

import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import com.example.diary.Models.DiaryDataModel;
import com.example.diary.Models.TagType;
import com.example.diary.Sql.DiaryService;

import org.springframework.web.bind.annotation.RequestBody;

//  コントローラークラス
@Controller
public class DiaryController {

    // Serviceクラス
    DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    // indexページ
    @GetMapping("/")
    public String diary(Model model) {
        // データベースから取り出したデータを送る
        model.addAttribute("samples", diaryService.exeSelectAll());
        return "/index";
    }

    // htmlのselectタグにenum情報を送る
    @ModelAttribute("tagTypes")
    public TagType[] getTagTypes() {
        return TagType.values();
    }

    // インサート文を送るページ
    @PostMapping("/insert")
    public String submitForm(@ModelAttribute DiaryDataModel ddm, Model model) {
        // インサートを行う
        ddm = diaryService.exeInsert(ddm);
        return "redirect:/";
    }

    // 編集ページに飛ぶ
    @GetMapping("/edit/{Id}")
    public String edit(@PathVariable("Id") Long id, Model model) {
        // 選択されたIdのみを取り出してそれを編集ページに送る
        DiaryDataModel ddm = diaryService.exeSelectOfOne(id);
        model.addAttribute("sample", ddm);
        return "/edit";
    }

    // 編集を行うupdateページ
    @PostMapping("/update")
    public String updatePage(@ModelAttribute DiaryDataModel ddm, Model model) {
        // updateに使う情報を送る
        diaryService.exeUpdate(ddm);
        return "redirect:/";
    }

    // 検索を行うsearchページ
    @PostMapping("/search")
    public String searchPage(@RequestBody String tagType, Model model) {
        try {
            // データベースから取り出したデータを送る
            model.addAttribute("samples", diaryService.exeSelectAll(tagType));
            return "/index";
        } catch (UnsupportedEncodingException e) {
            return "error";
        } catch (IllegalArgumentException e) {
            return "error";
        }
    }

}
