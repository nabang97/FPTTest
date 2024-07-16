package com.codetest.crud.services;

import com.codetest.crud.bean.Customer;
import com.codetest.crud.entities.CustomerEntity;
import com.codetest.crud.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*************************************************
 Created By : Yolanda Parawita
 Created Date : 16/7/2024 1:24 pm
 ************************************************/

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<CustomerEntity> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerEntity getCustomerById(int id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public CustomerEntity saveCustomer(CustomerEntity customerRequest) {
        return customerRepository.save(customerRequest);
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }
}
