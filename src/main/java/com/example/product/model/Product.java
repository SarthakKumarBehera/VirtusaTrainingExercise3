package com.example.product.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	private Integer productId;
	private String productName;
	private float productPrice;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	
	
	
}
