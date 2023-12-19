package com.ecommerceApplication.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Customer {

    @Id
    private Integer customerId;

    private String customerName;
    
    @Column(name = "product_Id")
    private Integer productId;



	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", cartItems=" + cartItems
				+ "]";
	}



	public Integer getCustomerId() {
		return customerId;
	}



	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}



	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



	public List<CartItem> getCartItems() {
		return cartItems;
	}



	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}



	public Customer() {
		super();
	}



	public Customer(Integer customerId, String customerName, List<CartItem> cartItems) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.cartItems = cartItems;
	}
	

	  
	  @OneToMany(mappedBy = "customer")
	   @JsonManagedReference
	    private List<CartItem> cartItems;


}
