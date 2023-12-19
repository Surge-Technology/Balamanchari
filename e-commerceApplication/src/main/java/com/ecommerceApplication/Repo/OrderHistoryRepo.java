package com.ecommerceApplication.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerceApplication.model.CartItem;
import com.ecommerceApplication.model.OrderHistory;

@Repository
public interface OrderHistoryRepo extends JpaRepository<OrderHistory, Integer>{
	OrderHistory save(CartItem cart);
}
