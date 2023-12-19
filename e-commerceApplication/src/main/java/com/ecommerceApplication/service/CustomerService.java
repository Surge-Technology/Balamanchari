package com.ecommerceApplication.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerceApplication.Repo.CustomerRepo;
import com.ecommerceApplication.model.CartItem;
import com.ecommerceApplication.model.Customer;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepository;



	public void createCustomer(Customer customer) {
		customerRepository.save(customer);
		}
	  public Optional<Customer> getCustomerById(int customerId) {
	        return customerRepository.findById(customerId);
	    }
	  
	  public List<CartItem> getCartItemsByCustomerId(Integer customerId) {
	        Optional<Customer> customerOptional = customerRepository.findById(customerId);
	        return customerOptional.map(Customer::getCartItems).orElse(Collections.emptyList());
	    }

	  public List<Customer> findCustomersByProductId(Integer productId) {
	        return customerRepository.findCartItemsByProductId(productId);
	    }
	 
	}
