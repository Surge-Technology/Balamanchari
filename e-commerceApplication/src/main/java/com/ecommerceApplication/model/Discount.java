package com.ecommerceApplication.model;
 
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
 
@Entity
@Table(name = "discount")
public class Discount {
 
	@Id
	public int discountId;
	public int percentage;
 
	@OneToOne
	@JoinColumn(name = "product_id")
	private Product product;
 
	public int getDiscountId() {
		return discountId;
	}
 
	public void setDiscountId(int discountId) {
		this.discountId = discountId;
	}
 
	@Override
	public String toString() {
		return "Discount [discountId=" + discountId + ", percentage=" + percentage + "]";
	}
 
	public int getPercentage() {
		return percentage;
	}
 
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
 
	public Product getProduct() {
		return product;
	}
 
	public void setProduct(Product product) {
		this.product = product;
	}
 
}