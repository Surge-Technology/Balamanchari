package com.ecommerceApplication.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerceApplication.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    List<Customer> findCartItemsByProductId(Integer productId);
}


