package com.music.store.controllers.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/carts")
public class CartItemController {
	
	@GetMapping({"", "/", "/index"})
	public String index(HttpServletRequest request) {
		return "redirect:/admin/carts/" + request.getSession(true).getId();
	}
	
	@GetMapping("/{cartId}")
	public String show(@PathVariable("cartId") String cartId, Model model) {
		model.addAttribute("cartId", cartId);
		return "/admin/carts/show";
	}
}
