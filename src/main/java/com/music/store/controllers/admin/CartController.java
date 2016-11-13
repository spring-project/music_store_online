package com.music.store.controllers.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.music.store.daos.CartDao;
import com.music.store.entities.Cart;
import com.music.store.entities.CartItem;
import com.music.store.entities.Product;
import com.music.store.services.ProductService;

@Controller
@RequestMapping("/rest/carts")
public class CartController {
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private HttpServletRequest request;
	
	
	@GetMapping("/{cartId}")
	public @ResponseBody Cart read(@PathVariable("cartId") String cartId) {
		return cartDao.read(cartId);
	}
	
	@PutMapping("/{cartId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable("cartId") String cartId, @RequestBody Cart cart) {
		cartDao.update(cartId, cart);
	}
	
	@DeleteMapping("/{cartId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("cartId") String cartId) {
		cartDao.delete(cartId);
	}
	
	
	@PutMapping("insert/{productId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void addItem(@PathVariable("productId") int productId) {
		System.out.println("addItem productId:" + productId);
		String sessionId = request.getSession(true).getId();
		Cart cart = cartDao.read(sessionId);
		
		if (cart == null) {
			cart = cartDao.create(new Cart(sessionId));
		}	
		
		System.out.println(cart);
		
		Product product = productService.findId(productId);
		
		System.out.println("product: " + product);
		
		if (product == null) {
			throw new IllegalArgumentException(new Exception());
		}

		cart.addCartItem(new CartItem(product));
		cartDao.update(sessionId, cart);
	}
	
	@PutMapping("remove/{productId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeItem(@PathVariable("productId") int productId) {
		String sessionId = request.getSession(true).getId();
		Cart cart = cartDao.read(sessionId);
		
		if (cart == null) {
			cart = cartDao.create(new Cart(sessionId));
		}	
		
		Product product = productService.findId(productId);
		if (product == null) {
			throw new IllegalArgumentException(new Exception());
		}
		
		cart.removeCartItem(new CartItem(product));
		cartDao.update(sessionId, cart);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload")
	public void handleClientError(Exception ex) {}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal server error")
	public void handleServerError(Exception ex) {}
	
}
