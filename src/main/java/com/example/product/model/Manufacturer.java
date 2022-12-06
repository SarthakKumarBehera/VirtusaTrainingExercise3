package com.example.product.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Manufacturer {
	
	private int manufacturerId;
	private int manufacturerName;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getManufacturerId() {
		return manufacturerId;
	}
	public int getManufacturerName() {
		return manufacturerName;
	}
	public void setManufacturerId(int manufacturerId) {
		this.manufacturerId = manufacturerId;
	}
	public void setManufacturerName(int manufacturerName) {
		this.manufacturerName = manufacturerName;
	}
}
