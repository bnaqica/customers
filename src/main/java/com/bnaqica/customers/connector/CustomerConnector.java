package com.bnaqica.customers.connector;

import com.bnaqica.customers.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class CustomerConnector {
    private RestTemplate restTemplate;

    @Value("${customers.baseUrl}")
    private String baseUrl;

    @Value("${customers.customerUrl}")
    private String customerUrl;

    @Value("${customers.version}")
    private String version;

    @Autowired
    public CustomerConnector(@Qualifier("customersRestTemplate") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Customer getCustomer(Long id) {
        String formattedUrl = UriComponentsBuilder.fromHttpUrl(baseUrl + customerUrl + version + id.toString()).build().toString();

        HttpEntity<String> entity = new HttpEntity<>(new HttpHeaders());
        ParameterizedTypeReference<Customer> typeReference = new ParameterizedTypeReference<Customer>() {
        };
        ResponseEntity<Customer> response = restTemplate.exchange(formattedUrl, HttpMethod.GET, entity, typeReference);

        return response == null ? new Customer() : response.getBody();
    }
}
