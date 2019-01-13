package com.bnaqica.customers.service;

import com.bnaqica.customers.model.Customer;
import com.bnaqica.customers.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Transactional
    public Customer getCustomer(Long id) {
        Optional<Customer> cus = customerRepository.findById(id);

        return cus.orElseThrow(() -> new IllegalArgumentException("Customer does not exist"));
    }

    public Customer createCustomer(Customer customer) {
        customer.getPhoneNumbers().forEach(phoneNumber -> customer.addPhoneNumber(phoneNumber));
        return customerRepository.save(customer);
    }
}
