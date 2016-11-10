package com.music.store.controllers.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.music.store.entities.Product;
import com.music.store.services.ProductService;

@Controller
@RequestMapping("admin/products")
public class ProductController {
	private String redirectProducts = "redirect:/admin/products";
	private Path path;

	@Autowired
	private ProductService productService;
	
	@Autowired(required = true)
	private HttpServletRequest request;
	
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
		return "admin/products/index";
	}
	
	@RequestMapping(value = "search", method = {RequestMethod.GET, RequestMethod.POST})
	public String search(Model model, @RequestParam(value = "key", required = false) String keyword) {
		if (keyword == null) {
			keyword = "";
		}
		model.addAttribute("products", productService.search(keyword));
		model.addAttribute("key", keyword);
		return "admin/products/index";
	}
	
	@GetMapping("show/{id}")
	public ModelAndView getProduct(@PathVariable int id) throws IOException {
		if (id <= 0) {
			throw new IOException("Undefined variable id or id is zero");
		}
		ModelAndView mav = new ModelAndView("admin/products/show");
		mav.addObject("product", productService.findId(id));
		return mav;
	}
	
	@GetMapping("new")
	public String getNew(Model model) {
		model.addAttribute("product", new Product());
		return "admin/products/new";
	}
	
	@PostMapping("new")
	public String postNew(@Valid Product product, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("product", product);
			return "admin/products/new";
		}
		saveImage(product);		
		productService.insert(product);
		return redirectProducts;
	}
	
	@GetMapping("edit/{id}")
	public String getEdit(@PathVariable int id, Model model) {		
		model.addAttribute("product", productService.findId(id));
		return "admin/products/edit";
	}
	
	@PostMapping("edit/{id}")
	public String postEdit(@PathVariable int id, @Valid Product product, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("product", product);
			return "admin/products/edit";
		}
		saveImage(product);
		productService.update(product);
		return redirectProducts;
	}
	
	@GetMapping("delete/{id}")
	public String getDelete(@PathVariable int id, Model model) {
		model.addAttribute("product", productService.findId(id));
		return "admin/products/delete";
	}
	
	@PostMapping("delete/{id}")
	public String postDelete(@PathVariable int id, @ModelAttribute Product product) {
		deleteImage(product);
		productService.delete(product);
		return redirectProducts;
	}
	
	private void saveImage(Product product) {
		MultipartFile image = product.getImage();	
		if (image != null && !image.isEmpty()) {
			String rootDirectory = request.getSession().getServletContext().getRealPath("/");
			path = Paths.get(rootDirectory + "\\resources\\images\\" + image.getOriginalFilename());
			try {
				image.transferTo(new File(path.toString()));
				product.setImageName(image.getOriginalFilename());
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println(ex.getClass().getSimpleName());
				System.out.println(ex.getMessage());
				throw new RuntimeException("Image saving failed.", ex);
			}
		}
	}
	
	private void deleteImage(Product product) {
		MultipartFile image = product.getImage();
		if (image != null && !image.isEmpty()) {
			String rootDirectory = request.getSession().getServletContext().getRealPath("/");
			path = Paths.get(rootDirectory + "\\resources\\images\\" + image.getOriginalFilename());
			if (Files.exists(path)) {
				try {
					Files.delete(path);
				} catch (IOException ex) {
					ex.printStackTrace();
					System.out.println(ex.getClass().getSimpleName());
					System.out.println(ex.getMessage());
					throw new RuntimeException("Image saving failed.", ex);
				}
			}
		}
	}
}
