package com.eny.bookretail.service.impl;

import com.eny.bookretail.dto.response.CustomerResponse;
import com.eny.bookretail.mapper.CustomerMapper;
import com.eny.bookretail.model.CustomerEntity;
import com.eny.bookretail.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CustomerServiceImplTest {
    @InjectMocks
    CustomerServiceImpl customerService;

    @Mock
    CustomerRepository repository;

    @Spy
    CustomerMapper customerMapper;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllCustomersTest() {
        List<CustomerEntity> list = new ArrayList<>();
        CustomerEntity customer1 = new CustomerEntity("Test1", "User1", "testuser1", "testuser1@test.com", "test1234", "address");
        CustomerEntity customer2 = new CustomerEntity("Test2", "User2", "testuser2", "testuser2@test.com", "test1234", "address");
        CustomerEntity customer3 = new CustomerEntity("Test3", "User3", "testuser3", "testuser3@test.com", "test1234", "address");

        list.add(customer1);
        list.add(customer2);
        list.add(customer3);

        when(repository.findAll()).thenReturn(list);

        //test
        List<CustomerResponse> response = customerService.getAllCustomers();

        assertEquals(list.size(), response.size());
        verify(repository, times(1)).findAll();
    }
}