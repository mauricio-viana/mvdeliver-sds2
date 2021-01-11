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

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}
		
}
