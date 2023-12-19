package com.ecommerceApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerceApplication.Repo.OrderHistoryRepo;
import com.ecommerceApplication.model.CartItem;
import com.ecommerceApplication.model.OrderHistory;

@Service
public class OrderHistoryService {

	@Autowired
	OrderHistoryRepo orderHistoryRepo;
	

	public OrderHistory saveOrderFromCart(CartItem cart) {
		OrderHistory order=new OrderHistory();
		 order.setOrderId(cart.getCartId());
		 order.setCustomer(cart.getCustomer());
		 order.setCustomerName(cart.getCustomerName());
		 order.setProductName(cart.getProductName());
		 orderHistoryRepo.save(order);
		 return order;
		
	}
}
