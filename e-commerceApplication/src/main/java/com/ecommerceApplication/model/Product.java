package com.ecommerceApplication.model;
 
import java.util.ArrayList;
import java.util.List;
 
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
 
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
 
@Entity
@Table(name = "product")
public class Product {
 
	@Id
	@GeneratedValue
	private Integer productId;
	private String productName;
	private Integer price;
 
 
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "discount_Id")
 
	@JsonIgnoreProperties("product")
	private Discount discount;
 
	public Integer getProductId() {
		return productId;
	}
 
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
 
	public String getProductName() {
		return productName;
	}
 
	public void setProductName(String productName) {
		this.productName = productName;
	}
 
	public Integer getPrice() {
		return price;
	}
	 public Integer getDiscountedPrice() {
	      
	            int discountPercentage = discount.getPercentage();
	            int discountedAmount = (price * discountPercentage) / 100;
	            return price - discountedAmount;
	    }
 
	public void setPrice(Integer price) {
		this.price = price;
	}
 
	public Discount getDiscount() {
		return discount;
	}
 
	public void setDiscount(Discount discount) {
		this.discount = discount;
	}
 
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<CartItem> cartItems;
 
 
	 @Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + ", discount="
				+ discount + ", cartItems=" + cartItems + " ]";
	}
 
 
}