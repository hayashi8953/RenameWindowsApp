package com.example.diary.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.ui.Model;

@ControllerAdvice
public class errorController {
    
    @ExceptionHandler(MainException.class)
    public String mainExceptionHandler(MainException e, Model model) {
        model.addAttribute("errorMessage", e.getMessage());
        return "error";
    }
}
