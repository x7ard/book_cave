package com.youcode.ecommerce.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.youcode.ecommerce.dao.OrderRepo;
import com.youcode.ecommerce.entities.Order;
import com.youcode.ecommerce.exceptions.ResourceNotFoundException;
import com.youcode.ecommerce.services.OrderService;

@Service
public class OrderServiceImp implements OrderService {

	@Autowired
	OrderRepo orderRepo;

	@Override
	public List<Order> findAll() {
		List<Order> orders = (List<Order>) orderRepo.findAll();
		return orders;
	}

	@Override
	public List<Order> findPages(Pageable pages) {
		return orderRepo.findAll(pages).getContent();
	}

	@Override
	public Order getOrder(Long id) {
		return orderRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("The order you're trying to reach is not found ..."));
	}

	@Override
	public Order createOrder(Order order) {
		return orderRepo.save(order);
	}

	@Override
	public void deleteOrder(Long id) {
		orderRepo.deleteById(id);

	}

}
