package com.example.diary.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;

//  exceptionHandlerを持つクラス
@ControllerAdvice
public class errorController {
    
    @ExceptionHandler(DataAccessException.class)
    public String DataAccessExceptionHandler(MainException e, Model model) {
        model.addAttribute("errorMessage", e.getMessage());
        return "error";
    }
    
    @ExceptionHandler(MainException.class)
    public String mainExceptionHandler(MainException e, Model model) {
        model.addAttribute("errorMessage", e.getMessage());
        return "error";
    }
}
