package com.example.diary.diary_Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import com.example.diary.diary_Sql.DiaryService;
import com.example.diary.diary_Models.DiaryDataModel;


@Controller
public class DiaryController {
    @Autowired
    DiaryService diaryService;

    @GetMapping("/")
    public String diary(Model model) {
        System.out.println("GetMapping(demo)を通過");
        model.addAttribute("samples", diaryService.exeSelectAll());
        return "/index";
    }

    @PostMapping("/insert")
    public String submitForm(@ModelAttribute DiaryDataModel demoDataModel, Model model) {
        DiaryDataModel ddm = new DiaryDataModel();
        ddm = demoDataModel;
        ddm = diaryService.exeInsert(ddm);
        // ビューへの受け渡し
        model.addAttribute("samples", diaryService.exeSelectAll());
        return "redirect:/";
    }
    @GetMapping("/edit/{Id}")
    public String edit(@PathVariable("Id") Long id, Model model) {
        DiaryDataModel ddm = diaryService.exeSelectOfOne(id);
        model.addAttribute("sample", ddm);
        return "/edit";
    }
    @PostMapping("/update")
    public String postMethodName(@ModelAttribute DiaryDataModel demoDiaryDataModel, Model model) {
        DiaryDataModel ddm = new DiaryDataModel();
        ddm = demoDiaryDataModel;
        diaryService.exeUpdate(ddm);
        model.addAttribute("samples", diaryService.exeSelectAll());
        return "redirect:/";
    }
    
}
