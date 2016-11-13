package com.music.store.entities;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	private String cartId;
	private Map<String, CartItem> cartItems;
	private double grandTotal;
	
	public Cart() {
		this.cartItems = new HashMap<String, CartItem>();
		this.grandTotal = 0;
	}
	
	public Cart(String cartId) {
		this();
		this.cartId = cartId;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public Map<String, CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Map<String, CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public void addCartItem(CartItem item) {
		String productId = "" + item.getProduct().getId();
		
		if (cartItems.containsKey(productId)) {
			CartItem cardItem = cartItems.get(productId);
			cardItem.setQuality(cardItem.getQuality() + item.getQuality());
			cartItems.put(productId, cardItem);
		} else {
			cartItems.put(productId, item);
		}
		
		updateGrandTotal();
	}
	
	public void removeCartItem(CartItem item) {
		String productId = "" + item.getProduct().getId();
		cartItems.remove(productId);
		updateGrandTotal();
	}
	
	public void updateGrandTotal() {
		grandTotal = 0;
		for (CartItem item : cartItems.values()) {
			grandTotal = grandTotal + item.getTotalPrice();
		}
	}

	@Override
	public String toString() {
		return "Cart [cardId=" + cartId + ", cardItems=" + cartItems + ", grandTotal=" + grandTotal + "]";
	}

}
