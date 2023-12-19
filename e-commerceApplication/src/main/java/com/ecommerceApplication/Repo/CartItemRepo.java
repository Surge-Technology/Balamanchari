package com.ecommerceApplication.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerceApplication.model.CartItem;

@Repository
public interface CartItemRepo extends JpaRepository<CartItem, Integer> {
	 List<CartItem> findByCustomer_CustomerId(int customerId);
}
