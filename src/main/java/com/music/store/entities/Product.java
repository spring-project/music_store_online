package com.music.store.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq_id")
	@SequenceGenerator(name = "product_seq_id", sequenceName = "product_seq_id")
	private long id;
	
	@NotNull
	private String name;
	
	private String description;
	
	@NotNull
	private double price;
	
	private int condition;
	
	private int status;
	
	@NotNull
	private int unitStock;
	
	private String manufacturer;

	public Product() {
		super();
		this.condition = 0;
		this.status = 1;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCondition() {
		return condition;
	}

	public void setCondition(int condition) {
		this.condition = condition;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getUnitStock() {
		return unitStock;
	}

	public void setUnitStock(int unitStock) {
		this.unitStock = unitStock;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", condition=" + condition + ", status=" + status + ", unitStock=" + unitStock + ", manufacturer="
				+ manufacturer + "]";
	}

}
