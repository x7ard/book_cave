package com.youcode.ecommerce.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.youcode.ecommerce.dao.OrderDetailRepo;
import com.youcode.ecommerce.entities.Client;
import com.youcode.ecommerce.entities.OrderDetail;
import com.youcode.ecommerce.exceptions.ResourceNotFoundException;
import com.youcode.ecommerce.services.OrderDetailService;

@Service
public class OrderDetailServiceImp implements OrderDetailService {

	@Autowired
	OrderDetailRepo orderDetailDao;

	@Override
	public List<OrderDetail> findAll() {
		return orderDetailDao.findAll();
	}

	@Override
	public List<OrderDetail> findPages(Pageable pageable) {
		return orderDetailDao.findAll(pageable).getContent();
	}

	@Override
	public List<OrderDetail> findAllByClient(Client client, Pageable pages) {
		return orderDetailDao.findAllByClient(client, pages).getContent();
	}

	@Override
	public List<OrderDetail> findAllByPhone(String phone, Pageable pages) {
		return orderDetailDao.findAllByPhone(phone, pages).getContent();
	}

	@Override
	public OrderDetail getOne(Long id) {
		return orderDetailDao.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("can't find this order detail you're trying to reach!"));
	}

	@Override
	public OrderDetail create(OrderDetail orderDetail) {
		return orderDetailDao.save(orderDetail);
	}

	@Override
	public void delete(Long id) {
		orderDetailDao.deleteById(id);
	}

}
