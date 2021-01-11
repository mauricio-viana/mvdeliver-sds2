package com.mauricioviana.mvdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mauricioviana.mvdeliver.dto.OrderDto;
import com.mauricioviana.mvdeliver.entities.Order;
import com.mauricioviana.mvdeliver.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;

	@Transactional(readOnly = true)
	public List<OrderDto> findAll(){
		List<Order> list = repository.findORderWithProducts();
		
		return list.stream().map(x -> new OrderDto(x)).collect(Collectors.toList());
	}
	
}
