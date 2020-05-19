package com.youcode.ecommerce.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.youcode.ecommerce.entities.Order;

@Repository
public interface OrderRepo extends PagingAndSortingRepository<Order, Long> {

}
