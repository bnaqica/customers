package com.bnaqica.customers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomersApplicationTests {
	@Autowired
	CustomerRepository repository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testGetCustomers() {
		Iterable<Customer> customers = repository.findAll();

		assertNotNull(customers);
		customers.forEach(c -> System.out.println(c));
	}

}

