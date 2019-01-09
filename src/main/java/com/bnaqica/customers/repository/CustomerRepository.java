package com.bnaqica.customers.repository;

import com.bnaqica.customers.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
