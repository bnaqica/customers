package com.bnaqica.customers;

import com.bnaqica.customers.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomersApplicationTests {
	@Autowired
	CustomerRepository repository;

	@Test
	public void contextLoads() {
	}

}

