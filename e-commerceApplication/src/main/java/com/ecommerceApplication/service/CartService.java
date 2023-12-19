package com.ecommerceApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerceApplication.Repo.CartItemRepo;
import com.ecommerceApplication.model.CartItem;
import com.ecommerceApplication.model.Customer;
import com.ecommerceApplication.model.Product;

@Service
public class CartService {

	@Autowired
	CartItemRepo cartItemRepo;
	


	 public Object addToCart(Customer customer, Product product, int quantity) {
	        CartItem cartItem = new CartItem();
	        cartItem.setCustomer(customer);
	        cartItem.setProduct(product);
	        cartItem.setQuantity(quantity);
	        cartItem.setCustomerName(customer.getCustomerName()); 
	        cartItem.setProductName(product.getProductName());

	        return cartItemRepo.save(cartItem);
	    }


		public CartItem getProductById(int cartId) {
		    return cartItemRepo.findById(cartId).orElse(null);
		}

		public void removeFromCart(int cartId) {
			cartItemRepo.deleteById(cartId);
		}
		
}
