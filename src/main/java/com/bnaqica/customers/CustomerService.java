package com.bnaqica.customers;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(Customer.builder()
                .id(1L)
                .firstName("Joe")
                .lastName("Smuck")
                .gender("Male")
                .dateOfBirth(LocalDate.parse("2016-06-12"))
                .build());

        return customers;
    }
}
