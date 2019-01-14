package com.bnaqica.customers.service;

import com.bnaqica.customers.connector.CustomerConnector;
import com.bnaqica.customers.model.Customer;
import com.bnaqica.customers.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    private CustomerConnector customerConnector;

    public CustomerService(CustomerRepository customerRepository, CustomerConnector customerConnector) {
        this.customerRepository = customerRepository;
        this.customerConnector = customerConnector;
    }

    public Customer getCustomer(Long id, boolean isClientCustomer) {
        return isClientCustomer ? getCustomerFromClient(id) : getCustomerFromDatabase(id);
    }

    @Transactional
    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer createCustomer(Customer customer) {
        customer.getPhoneNumbers().forEach(phoneNumber -> customer.addPhoneNumber(phoneNumber));
        customer.addDriversLicense(customer.getDriversLicense());
        return customerRepository.save(customer);
    }

    @Transactional
    private Customer getCustomerFromDatabase(Long id) {
        Optional<Customer> cus = customerRepository.findById(id);

        return cus.orElseThrow(() -> new IllegalArgumentException("Customer does not exist"));
    }

    private Customer getCustomerFromClient(Long id) {
        return customerConnector.getCustomer(id);
    }

}
