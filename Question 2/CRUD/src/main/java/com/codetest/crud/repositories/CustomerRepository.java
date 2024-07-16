package com.codetest.crud.repositories;

import com.codetest.crud.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/*************************************************
 Created By : Yolanda Parawita
 Created Date : 16/7/2024 12:47 pm
 ************************************************/

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
}
