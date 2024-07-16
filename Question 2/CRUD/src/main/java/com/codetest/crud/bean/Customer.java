package com.codetest.crud.bean;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

/*************************************************
 Created By : Yolanda Parawita
 Created Date : 16/7/2024 1:21 pm
 ************************************************/

public class Customer {
    private int customerId;
    @NotEmpty(message = "Customer name must not be empty")
    @Size(max = 100, message = "Customer name must not exceed 100 characters")
    private String customerName;

    @NotEmpty(message = "Customer address must not be empty")
    @Size(max = 200, message = "Customer address must not exceed 200 characters")
    private String customerAddress;


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
}
