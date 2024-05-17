package com.example.diary.diary_Controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;

//  exceptionHandlerを持つクラス
@ControllerAdvice
public class errorController {
    
    @ExceptionHandler(DataAccessException.class)
    public String DataAccessExceptionHandler(DataAccessException e, Model model) {
        model.addAttribute("exception", "DataAccessException");
        model.addAttribute("errorMessage", e.getMessage());
        return "error";
    }
    @ExceptionHandler(NullPointerException.class)
    public String Handler(NullPointerException e, Model model) {
        model.addAttribute("NullPointerException", "DataAccessException");
        model.addAttribute("errorMessage", e.getMessage());
        return "error";
    }
    
    @ExceptionHandler(Exception.class)
    public String mainExceptionHandler(Exception e, Model model) {
        model.addAttribute("errorMessage", e.getMessage());
        return "error";
    }
}
