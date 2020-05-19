package com.youcode.ecommerce.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youcode.ecommerce.entities.Client;
import com.youcode.ecommerce.entities.OrderDetail;

@Repository
public interface OrderDetailRepo extends JpaRepository<OrderDetail, Long> {

	Page<OrderDetail> findAllByClient(Client client, Pageable pageable);

	Page<OrderDetail> findAllByPhone(String phone, Pageable pageable);

}
