package com.codetest.crud.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

/*************************************************
 Created By : Yolanda Parawita
 Created Date : 16/7/2024 12:44 pm
 ************************************************/
@Entity
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int custId;
    @NotEmpty(message = "Customer name must not be empty")
    @Size(max = 100, message = "Customer name must not exceed 100 characters")
    private String custName;

    @NotEmpty(message = "Customer address must not be empty")
    @Size(max = 200, message = "Customer address must not exceed 200 characters")
    private String custAddress;

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }
}
