package com.ecommerceApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerceApplication.Repo.DiscountRepo;
import com.ecommerceApplication.model.Discount;

@Service
public class DiscountService {

	@Autowired
	DiscountRepo discountRepo;
	
	public void createProduct(Discount discount)   
	{  
		discountRepo.save(discount);  
	}  
	
	
}
