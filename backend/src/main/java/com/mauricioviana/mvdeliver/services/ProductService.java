package com.mauricioviana.mvdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mauricioviana.mvdeliver.dto.ProductDto;
import com.mauricioviana.mvdeliver.entities.Product;
import com.mauricioviana.mvdeliver.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;

	@Transactional(readOnly = true)
	public List<ProductDto> findAll(){
		List<Product> list = repository.findAllByOrderByNameAsc();
		
		return list.stream().map(x -> new ProductDto(x)).collect(Collectors.toList());
	}
	
}
