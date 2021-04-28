package com.eny.bookretail.service;

import com.eny.bookretail.dto.request.CreateCustomerDto;
import com.eny.bookretail.dto.request.CustomerDto;
import com.eny.bookretail.dto.response.CustomerResponse;
import com.eny.bookretail.model.CustomerEntity;

import java.util.List;

public interface ICustomerService {
    CustomerEntity createCustomer(CreateCustomerDto createCustomerDto);

    List<CustomerResponse> getAllCustomers();

    boolean updateCustomer(long id, CustomerDto dto);

    CustomerResponse getUserByUsernameOrEmail(CustomerDto dto);

    CustomerResponse getCustomerResponseById(Long customerID);

    CustomerEntity getCustomerById(Long id);
}
