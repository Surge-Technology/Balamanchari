package com.ecommerceApplication.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerceApplication.Repo.CartItemRepo;
import com.ecommerceApplication.Repo.ECommerceRepo;
import com.ecommerceApplication.model.Product;

@Service
public class ECommerceService {

	@Autowired
	ECommerceRepo commerceRepo;
	
	@Autowired
	CartItemRepo cartItemRepo;

	public void createProduct(Product product) {
		commerceRepo.save(product);
	}

	public Object getProduct(Product product) {
		return commerceRepo.findAll();

	}

	public Object getProductById(Integer productId) {
		return commerceRepo.findById(productId);

	}

	public Object deleteProductById(Integer productId) {
		commerceRepo.deleteById(productId);
		;
		return "product deleted successfully";

	}

	public Product updateProduct(Integer productId, Product product) {
		Optional<Product> optionalAddress = commerceRepo.findById(productId);

		if (optionalAddress.isPresent()) {
			Product existingAddress = optionalAddress.get();
			existingAddress.setDiscount(product.getDiscount());

			return commerceRepo.save(existingAddress);
		} else {
			return null;
		}
	}
	
	public Product getProductById(int productId) {
	    return commerceRepo.findById(productId).orElse(null);
	}



}
