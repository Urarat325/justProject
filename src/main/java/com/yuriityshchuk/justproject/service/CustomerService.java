package com.yuriityshchuk.justproject.service;

import com.yuriityshchuk.justproject.model.Customer;
import com.yuriityshchuk.justproject.model.enumDB.Role;
import com.yuriityshchuk.justproject.repository.CustomerRepo;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
//@Scope(scopeName = "websocket", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CustomerService implements UserDetailsService {

    private final CustomerRepo customerRepo;

    private PasswordEncoder passwordEncoder;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        try {
            return customerRepo.findByUsername(username);
        } catch (UsernameNotFoundException e) {
            throw e;
        }
    }

    public boolean addUser(Customer customer) {

        if (customerRepo.findByUsername(customer.getUsername()) != null) return false;

        customer.setRoles(Collections.singleton(Role.USER));
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customerRepo.save(customer);

        return true;
    }


}
