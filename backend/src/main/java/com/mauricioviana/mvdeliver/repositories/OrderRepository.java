package com.mauricioviana.mvdeliver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mauricioviana.mvdeliver.entities.Order;

public interface OrderRepository  extends JpaRepository<Order, Long>{
	

}
