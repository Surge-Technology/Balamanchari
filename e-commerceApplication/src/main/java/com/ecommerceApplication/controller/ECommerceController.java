package com.ecommerceApplication.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerceApplication.Repo.CartItemRepo;
import com.ecommerceApplication.model.CartItem;
import com.ecommerceApplication.model.Customer;
import com.ecommerceApplication.model.OrderHistory;
import com.ecommerceApplication.model.Product;
import com.ecommerceApplication.service.CartService;
import com.ecommerceApplication.service.CustomerService;
import com.ecommerceApplication.service.ECommerceService;
import com.ecommerceApplication.service.OrderHistoryService;

@RestController
public class ECommerceController {

	@Autowired
	ECommerceService commerceService;
	
    @Autowired
   CartService cartService;
    
    @Autowired
    CustomerService customerService;
    
    @Autowired
    OrderHistoryService orderHistoryService;
    
    @Autowired
    CartItemRepo cartItemRepo;

	@PostMapping("/AddProduct")
	public Object addProduct(@RequestBody Product product) {
		commerceService.createProduct(product);
		return product ;
	}

	@GetMapping("/getProduct")
		public Object getProduct(Product product) {
		
			 return commerceService.getProduct(product);

	 
		}

	@GetMapping("/getProduct/{productId}")
	public Object getProductById(@PathVariable Integer productId) {

		return commerceService.getProductById(productId);

	}

	@DeleteMapping("/deleteProductById/{productId}")
	public Object deleteProduct(@PathVariable Integer productId) {

		return commerceService.deleteProductById(productId);

	}

	@PutMapping("/updateProductDiscount/{productId}")
	public Product updateAddress(@PathVariable Integer productId, @RequestBody Product product) {
		return commerceService.updateProduct(productId, product);
	}
	
	
	  @PostMapping("/add-to-cart/{customerId}/{productId}/{quantity}")
	    public Object addToCart(
	            @PathVariable int customerId,
	            @PathVariable int productId,
	            @PathVariable int quantity) {

		  Optional<Customer> customerOptional = customerService.getCustomerById(customerId);
		  Product product = (Product) commerceService.getProductById(productId);

		  if (customerOptional.isPresent() && product != null) {
		      Customer customer = customerOptional.get();
		      Object obj = cartService.addToCart(customer, product, quantity);
		      return obj;
		  } else {
		      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer or product not found.");
		  }

	    }
	 
	 @PostMapping("/addCustomer")
		public Object addCustomer(@RequestBody Customer customer) {
			customerService.createCustomer(customer);
			return customer;
		}

	 @GetMapping("/getCartItems/{customerId}")
	    public ResponseEntity<List<CartItem>> getCartItemsByCustomerId(@PathVariable Integer customerId) {
	        List<CartItem> cartItems = customerService.getCartItemsByCustomerId(customerId);
	        if (!cartItems.isEmpty()) {
	            return ResponseEntity.ok(cartItems);
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
	        }
	    }

	 @GetMapping("/findByProductId/{productId}")
	    public List<Customer> findCustomersByProductId(@PathVariable Integer productId) {
	        return customerService.findCustomersByProductId(productId);
	    }
	 @GetMapping("/getCartBYId/{cartId}")
	 public Object getCartBYId(@PathVariable Integer cartId) {
		return cartService.getProductById(cartId);
		 
	 }
	 
	 
	 @PostMapping("/checkout/{cartId}")
	 public OrderHistory checkout(@PathVariable Integer cartId) {
		 
		 CartItem cart = cartService.getProductById(cartId);
		 
		 System.out.println(cart);
		 
		 
		 OrderHistory order = orderHistoryService.saveOrderFromCart(cart);
		 
		 cartService.removeFromCart(cartId);
		 
		return order;
		 
	 }

}
