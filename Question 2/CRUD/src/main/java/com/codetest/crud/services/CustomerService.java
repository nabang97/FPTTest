package com.codetest.crud.services;

import com.codetest.crud.bean.Customer;
import com.codetest.crud.entities.CustomerEntity;

import java.util.List;

/*************************************************
 Created By : Yolanda Parawita
 Created Date : 16/7/2024 12:48 pm
 ************************************************/


public interface CustomerService {

    public List<CustomerEntity> getAllCustomers();

    public CustomerEntity getCustomerById(int id);

    public CustomerEntity saveCustomer(CustomerEntity customer);

    public void deleteCustomer(int id);
}
