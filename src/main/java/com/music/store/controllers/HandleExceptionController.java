package com.music.store.controllers;

import java.io.IOException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleExceptionController {
	@ExceptionHandler(IOException.class)
	public String IOExceptionHandler(Model model, IOException ex) {
		model.addAttribute("name", ex.getClass().getSimpleName());
		model.addAttribute("message", ex.getMessage());
		ex.printStackTrace();
	    return "errors/exception";
	}
	
	@ExceptionHandler(Exception.class)
	public String ExceptionHandler(Model model, Exception ex) {
		model.addAttribute("name", ex.getClass().getSimpleName());
		model.addAttribute("message", ex.getMessage());
		ex.printStackTrace();
	    return "errors/exception";
	}
}
