package com.music.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.music.store.entities.Product;
import com.music.store.services.ProductService;

@Controller
public class HomeController {
	
	@Autowired()
	private ProductService productService;
	
	@RequestMapping("/")
	public String index() {
		return "home/index";
	}
	
	@RequestMapping("/products")
	public String getProducts(Model model) {
		List<Product> products = productService.findAll(); 
		model.addAttribute("products", products);
		return "products/index";
	}
	
}
