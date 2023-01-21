package com.yuripe.cms.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuripe.cms.exceptions.CustomerException;
import com.yuripe.cms.models.Customer;
import com.yuripe.cms.repositories.CustomerRepository;

@Service
public class CustomerService {
	
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAllCars() {
        return (List<Customer>) customerRepository.findAll();
    }

    public Customer getCustomer(String CF) throws CustomerException {
        return customerRepository.findByCF(CF).orElseThrow(() -> new CustomerException("Customer Not FOUND!"));
    }

    public void addCustomer(Customer customer) {
        this.customerRepository.save(customer);
    }

    public void updateCustomer(String id, Customer customer) {
        this.customerRepository.save(customer);
    }

    public void deleteCustomer(String CF) {
        this.customerRepository.deleteByCF(CF);;
    }
}
