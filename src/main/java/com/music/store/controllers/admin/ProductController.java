package com.music.store.controllers.admin;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.music.store.entities.Product;
import com.music.store.services.ProductService;

@Controller
@RequestMapping("admin/products")
public class ProductController {
	private String redirectProducts = "redirect:/admin/products";
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	@Qualifier("productValidator")
	private Validator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@GetMapping({"", "/", "/index"})
	public String index(Model model) {
		List<Product> products = productService.findAll(); 
		model.addAttribute("products", products);
		model.addAttribute("key", "");
		return "products/index";
	}
	
	@RequestMapping(value = "search", method = {RequestMethod.GET, RequestMethod.POST})
	public String search(Model model, @RequestParam(value = "key", required = false) String keyword) {
		if (keyword == null) {
			keyword = "";
		}
		model.addAttribute("products", productService.search(keyword));
		model.addAttribute("key", keyword);
		return "products/index";
	}
	
	@GetMapping("show/{id}")
	public ModelAndView getProduct(@PathVariable int id) throws IOException {
		if (id <= 0) {
			throw new IOException("Undefined variable id or id is zero");
		}
		ModelAndView mav = new ModelAndView("products/show");
		mav.addObject("product", productService.findId(id));
		return mav;
	}
	
	@GetMapping("new")
	public String getNew(Model model) {
		model.addAttribute("product", new Product());
		return "products/new";
	}
	
	@PostMapping("new")
	public String postNew(@Valid Product product, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("product", product);
			return "products/new";
		}
		
		productService.insert(product);
		return redirectProducts;
	}
	
	@GetMapping("edit/{id}")
	public String getEdit(@PathVariable int id, Model model) {		
		model.addAttribute("product", productService.findId(id));
		return "products/edit";
	}
	
	@PostMapping("edit/{id}")
	public String postEdit(@PathVariable int id, @Valid Product product, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("product", product);
			return "products/edit";
		}
		
		productService.update(product);
		return redirectProducts;
	}
	
	@GetMapping("delete/{id}")
	public String getDelete(@PathVariable int id, Model model) {
		model.addAttribute("product", productService.findId(id));
		return "products/delete";
	}
	
	@PostMapping("delete/{id}")
	public String postDelete(@PathVariable int id, @ModelAttribute Product product) {
		productService.delete(product);
		return redirectProducts;
	}
}
