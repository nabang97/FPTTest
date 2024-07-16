package com.codetest.crud.controller;

import com.codetest.crud.bean.Customer;
import com.codetest.crud.entities.CustomerEntity;
import com.codetest.crud.services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*************************************************
 Created By : Yolanda Parawita
 Created Date : 16/7/2024 12:50 pm
 ************************************************/

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping(path = "/getAllCustomers")
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        List<CustomerEntity> customerEntities = customerService.getAllCustomers();
        customerEntities = customerEntities.stream().peek(x -> {
           Customer customer = new Customer();
           customer.setCustomerId(x.getCustId());
           customer.setCustomerName(x.getCustName());
           customer.setCustomerAddress(x.getCustAddress());
           customers.add(customer);
       }).collect(Collectors.toList());
        return customers;
    }

    @GetMapping("/getCustomerById/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable int id) {
        CustomerEntity customerEntity = customerService.getCustomerById(id);
        if (customerEntity != null) {
            Customer customer = new Customer();
            customer.setCustomerId(customerEntity.getCustId());
            customer.setCustomerName(customerEntity.getCustName());
            customer.setCustomerAddress(customerEntity.getCustAddress());
            return new ResponseEntity<Customer>(customer, null, HttpStatus.OK);
        }
        return new ResponseEntity<String>("Customer is not exist", null, HttpStatus.OK);
    }

    @PostMapping(path = "/createCustomer")
    public ResponseEntity<?> createCustomer(@Valid @RequestBody Customer request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error ->
                    errors.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }

        CustomerEntity entity = new CustomerEntity();
        entity.setCustName(request.getCustomerName());
        entity.setCustAddress(request.getCustomerAddress());

        CustomerEntity customerEntity = customerService.saveCustomer(entity);
        Customer customer = new Customer();
        customer.setCustomerId(customerEntity.getCustId());
        customer.setCustomerName(customerEntity.getCustName());
        customer.setCustomerAddress(customerEntity.getCustAddress());
        return ResponseEntity.ok(customer);
    }

    @PutMapping("/updateCustomer/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable int id, @Valid @RequestBody Customer request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error ->
                    errors.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }
        CustomerEntity existingCustomer = customerService.getCustomerById(id);
        Customer customer = new Customer();
        if (existingCustomer != null) {
            existingCustomer.setCustId(id);
            existingCustomer.setCustName(request.getCustomerName());
            existingCustomer.setCustAddress(request.getCustomerAddress());

            CustomerEntity customerEntity = customerService.saveCustomer(existingCustomer);
            customer.setCustomerId(existingCustomer.getCustId());
            customer.setCustomerName(customerEntity.getCustName());
            customer.setCustomerAddress(customerEntity.getCustAddress());

            return new ResponseEntity<Customer>(customer, null, HttpStatus.OK);
        }
        return new ResponseEntity<String>("Customer is not exist", null, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int id) {
        CustomerEntity existingCustomer = customerService.getCustomerById(id);
        if (existingCustomer != null) {
            customerService.deleteCustomer(id);
            return new ResponseEntity<String>("Data has been deleted", null, HttpStatus.OK);
        }
        return new ResponseEntity<String>("Customer is not exist", null, HttpStatus.OK);

    }

}
