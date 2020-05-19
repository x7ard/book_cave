package com.youcode.ecommerce.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youcode.ecommerce.dao.DiscountRepo;
import com.youcode.ecommerce.entities.Discount;

@Service
public class DiscountService implements com.youcode.ecommerce.services.DiscountService{

	@Autowired
	DiscountRepo discountRepo;
	
	public List<Discount> getListDiscount(){
		return discountRepo.findAll();
	}
	
	
}
