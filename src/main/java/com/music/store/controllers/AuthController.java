package com.music.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {
	
	@GetMapping("/login")
	
	public String getLogin(
			@RequestParam (value = "error", required = false) String error,
			@RequestParam (value = "error", required = false) String logout, Model model) {
			if (error != null) {
				model.addAttribute("error", "Invalid Username or Password");
			}
			if (logout != null) {
				model.addAttribute("message", "You have been logged out successfully.");
			}
			
			return "auth/login";
	}

}
