package com.music.store.entities;

public class CartItem {
	private Product product;
	private int quality;
	private double totalPrice;
	
	public CartItem() {
		
	}
	
	public CartItem(Product product) {
		this.product = product;
		this.quality = 1;
		this.totalPrice = product.getPrice();
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "CartItem [product=" + product + ", quality=" + quality + ", totalPrice=" + totalPrice + "]";
	}
	
}
