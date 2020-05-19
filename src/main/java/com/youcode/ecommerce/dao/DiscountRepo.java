package com.youcode.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youcode.ecommerce.entities.Discount;

@Repository
public interface DiscountRepo extends JpaRepository<Discount, Long> {

	Discount findByCode(String code);

}
