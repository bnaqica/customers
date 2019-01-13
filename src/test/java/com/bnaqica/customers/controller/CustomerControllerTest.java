package com.bnaqica.customers.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static com.bnaqica.customers.TestUtils.getResourceAsString;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:schema.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:customerInsert.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:customerDelete.sql"),
})
public class CustomerControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testGetCustomers() throws Exception {
        mockMvc.perform(get("/customers")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$.[0].id", is(1)))
                .andExpect(jsonPath("$.[0].firstName", is("John")))
                .andExpect(jsonPath("$.[0].lastName", is("Doe")))
                .andExpect(jsonPath("$.[0].gender", is("male")))
                .andExpect(jsonPath("$.[0].phoneNumbers", hasSize(2)))
                .andExpect(jsonPath("$.[0].phoneNumbers.[0].id", notNullValue()))
                .andExpect(jsonPath("$.[0].phoneNumbers.[0].number", notNullValue()))
                .andExpect(jsonPath("$.[0].phoneNumbers.[0].type", notNullValue()))
                .andExpect(jsonPath("$.[1].id", is(2)))
                .andExpect(jsonPath("$.[2].id", is(3)));
    }

    @Test
    public void testGetCustomer() throws Exception {
        mockMvc.perform(get("/customers/2")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(2)))
                .andExpect(jsonPath("$.firstName", is("Max")))
                .andExpect(jsonPath("$.lastName", is("Zion")))
                .andExpect(jsonPath("$.gender", is("male")))
                .andExpect(jsonPath("$.phoneNumbers", hasSize(1)))
                .andExpect(jsonPath("$.phoneNumbers.[0].id", notNullValue()))
                .andExpect(jsonPath("$.phoneNumbers.[0].number", notNullValue()))
                .andExpect(jsonPath("$.phoneNumbers.[0].type", notNullValue()));
    }

    @Test
    public void testGetCustomer_NonExistingCustomer() throws Exception {
        mockMvc.perform(get("/customers/10")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", containsString("Illegal Argument Exception: Customer does not exist")));
    }

    @Test
    public void testCreateCustomer() throws Exception {
        String customerCreateJson = getResourceAsString("createCustomer.json");
        mockMvc.perform(post("/customers")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(customerCreateJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(4)))
                .andExpect(jsonPath("$.firstName", is("Tom")))
                .andExpect(jsonPath("$.lastName", is("Chung")))
                .andExpect(jsonPath("$.gender", is("male")))
                .andExpect(jsonPath("$.phoneNumbers", hasSize(3)))
                .andExpect(jsonPath("$.phoneNumbers.[0].id", notNullValue()))
                .andExpect(jsonPath("$.phoneNumbers.[0].number", notNullValue()))
                .andExpect(jsonPath("$.phoneNumbers.[0].type", notNullValue()));
    }
}