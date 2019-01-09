package com.bnaqica.customers;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Customer does not exist"));
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
