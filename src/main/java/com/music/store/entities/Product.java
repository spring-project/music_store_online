package com.music.store.entities;

import javax.persistence.*;

@Entity
@Table(name="products")
public class Product {
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq_id")
    @SequenceGenerator(name = "product_seq_id", sequenceName = "product_seq_id")
    private long productId;

    private String productName;
    private String productCategory;
    private String productDescription;
    private double productPrice;
    private String productCondition;
    private String productStatus;
    private int unitStock;
    private String productManufacturer;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCondition() {
        return productCondition;
    }

    public void setProductCondition(String productCondition) {
        this.productCondition = productCondition;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public int getUnitStock() {
        return unitStock;
    }

    public void setUnitStock(int unitStock) {
        this.unitStock = unitStock;
    }

    public String getProductManufacturer() {
        return productManufacturer;
    }

    public void setProductManufacturer(String productManufacturer) {
        this.productManufacturer = productManufacturer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice=" + productPrice +
                ", productCondition='" + productCondition + '\'' +
                ", productStatus='" + productStatus + '\'' +
                ", unitStock=" + unitStock +
                ", productManufacturer='" + productManufacturer + '\'' +
                '}';
    }
}
