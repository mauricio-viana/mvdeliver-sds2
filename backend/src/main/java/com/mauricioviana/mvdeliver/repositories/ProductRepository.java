package com.mauricioviana.mvdeliver.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mauricioviana.mvdeliver.entities.Product;

public interface ProductRepository  extends JpaRepository<Product, Long>{
	
	List<Product> findAllByOrderByNameAsc();
}