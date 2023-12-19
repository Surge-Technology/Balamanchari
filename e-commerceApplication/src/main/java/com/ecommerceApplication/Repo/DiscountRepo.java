package com.ecommerceApplication.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerceApplication.model.Discount;

@Repository
public interface DiscountRepo extends JpaRepository<Discount, Integer> {

}
