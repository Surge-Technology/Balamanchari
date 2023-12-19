package com.ecommerceApplication.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerceApplication.model.Product;

@Repository
public interface ECommerceRepo extends JpaRepository<Product, Integer> {

	Optional<Product> findById(Integer productId);
	  //List<Customer> findCustomersByCartItems_Product_ProductId(Integer productId);
	//List<Customer> findCustomersByCartItems_Product_ProductId(Integer productId);
}
