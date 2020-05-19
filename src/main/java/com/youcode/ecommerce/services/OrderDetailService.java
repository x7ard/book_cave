package com.youcode.ecommerce.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.youcode.ecommerce.entities.Client;
import com.youcode.ecommerce.entities.OrderDetail;

public interface OrderDetailService {

	List<OrderDetail> findAll();

	List<OrderDetail> findPages(Pageable pageable);

	public List<OrderDetail> findAllByClient(Client client, Pageable pages);

	public List<OrderDetail> findAllByPhone(String phone, Pageable pages);

	OrderDetail getOne(Long id);

	OrderDetail create(OrderDetail orderDetail);

	void delete(Long id);

}
