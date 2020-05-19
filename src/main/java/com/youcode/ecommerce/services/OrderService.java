package com.youcode.ecommerce.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.youcode.ecommerce.entities.Order;

public interface OrderService {

	public List<Order> findAll();

	public List<Order> findPages(Pageable pages);

	public Order getOrder(Long id);

	public Order createOrder(Order order);

	public void deleteOrder(Long id);

}
