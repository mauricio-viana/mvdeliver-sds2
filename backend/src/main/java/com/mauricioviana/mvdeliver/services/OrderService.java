package com.mauricioviana.mvdeliver.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mauricioviana.mvdeliver.dto.OrderDto;
import com.mauricioviana.mvdeliver.dto.ProductDto;
import com.mauricioviana.mvdeliver.entities.Order;
import com.mauricioviana.mvdeliver.entities.OrderStatus;
import com.mauricioviana.mvdeliver.entities.Product;
import com.mauricioviana.mvdeliver.repositories.OrderRepository;
import com.mauricioviana.mvdeliver.repositories.ProductRepository;

@Service
public class OrderService {
	
	private OrderRepository orderRepository;
	private ProductRepository productRepository;
	
	@Autowired
	public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
		this.orderRepository = orderRepository;
		this.productRepository = productRepository;		
	}
	
	@Transactional(readOnly = true)
	public List<OrderDto> findAll(){
		List<Order> list = orderRepository.findORderWithProducts();
		return list.stream().map(x -> new OrderDto(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public OrderDto insert(OrderDto dto) {
		Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(),
				Instant.now(), OrderStatus.PENDING);
		for (ProductDto p : dto.getProducts()) {
			Product product = productRepository.getOne(p.getId());
			order.getProducts().add(product);
		}
		order = orderRepository.save(order);
		return new OrderDto(order);
	}
	
}
