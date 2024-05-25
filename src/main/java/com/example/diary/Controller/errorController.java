package com.example.diary.Controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.UnsupportedEncodingException;

import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;

//  exceptionHandlerを持つクラス
@ControllerAdvice
public class errorController {
    
    @ExceptionHandler(DataAccessException.class)
    public String DataAccessExceptionHandler(DataAccessException e, Model model) {
        model.addAttribute("exception", "DataAccessException");
        model.addAttribute("errorMessage", e.getMessage());
        model.addAttribute("stackTrace", e.getStackTrace());
        return "error";
    }
    @ExceptionHandler(NullPointerException.class)
    public String NullPointerExceptionHandler(NullPointerException e, Model model) {
        model.addAttribute("exception", "NullPointerException");
        model.addAttribute("errorMessage", e.getMessage());
        model.addAttribute("stackTrace", e.getStackTrace());
        return "error";
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public String IllegalArgumentExceptionHandler(IllegalArgumentException e, Model model) {
        model.addAttribute("exception", "IllegalArgumentException");
        model.addAttribute("errorMessage", e.getMessage());
        model.addAttribute("stackTrace", e.getStackTrace());
        return "error";
    }
    @ExceptionHandler(UnsupportedEncodingException.class)
    public String UnsupportedEncodingExceptionHandler(UnsupportedEncodingException e, Model model) {
        model.addAttribute("exception", "UnsupportedEncodingException");
        model.addAttribute("errorMessage", e.getMessage());
        model.addAttribute("stackTrace", e.getStackTrace());
        return "error";
    }
    @ExceptionHandler(Exception.class)
    public String mainExceptionHandler(Exception e, Model model) {
        model.addAttribute("exception", "Exception");
        model.addAttribute("errorMessage", e.getMessage());
        model.addAttribute("stackTrace", e.getStackTrace());
        return "error";
    }
}
