package com.mauricioviana.mvdeliver.dto;

import com.mauricioviana.mvdeliver.entities.Product;

public class ProductDto {

	private Long id;
	private String name;
	private Double price;
	private String description;
	private String imageUri;
	
	public ProductDto () {}

	public ProductDto(Product entity) {
		id = entity.getId();
		name = entity.getName();
		price = entity.getPrice();
		description = entity.getDescription();
		imageUri = entity.getImageUri();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	public String getImageUri() {
		return imageUri;
	}
	
}
