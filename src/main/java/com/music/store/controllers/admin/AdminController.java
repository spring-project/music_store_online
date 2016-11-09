package com.music.store.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {
	@GetMapping({"", "/", "/index"})
	public String index(Model model) {
		model.addAttribute("pageTitle", "- Admin");
		return "admin/home/index";
	}
}
