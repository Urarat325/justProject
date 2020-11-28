package com.yuriityshchuk.justproject.repository;

import com.yuriityshchuk.justproject.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
    Customer findByUsername(String username);
}
