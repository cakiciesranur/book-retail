package com.eny.bookretail.service.impl;

import com.eny.bookretail.dto.request.CreateCustomerDto;
import com.eny.bookretail.dto.request.CustomerDto;
import com.eny.bookretail.dto.response.CustomerResponse;
import com.eny.bookretail.enums.RoleName;
import com.eny.bookretail.exception.runtime.*;
import com.eny.bookretail.mapper.CustomerMapper;
import com.eny.bookretail.model.CustomerEntity;
import com.eny.bookretail.model.RoleEntity;
import com.eny.bookretail.repository.CustomerRepository;
import com.eny.bookretail.repository.RoleRepository;
import com.eny.bookretail.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public CustomerEntity createCustomer(CreateCustomerDto createCustomerDto) {
        if (customerRepository.existsByUsername(createCustomerDto.getUsername())) {
            throw new UsernameExistException();
        }

        if (customerRepository.existsByEmail(createCustomerDto.getEmail())) {
            throw new EmailAlreadyExistsException();
        }

        // Creating customer's account
        CustomerEntity customer = new CustomerEntity(createCustomerDto.getFirstName(), createCustomerDto.getLastName(), createCustomerDto.getUsername(),
                createCustomerDto.getEmail(), createCustomerDto.getPassword(), createCustomerDto.getAddress());

        customer.setPassword(passwordEncoder.encode(customer.getPassword()));

        RoleEntity userRole = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(ProcessException::new);

        customer.setRoles(Collections.singleton(userRole));

        return customerRepository.save(customer);
    }

    @Override
    public List<CustomerResponse> getAllCustomers() {
        List<CustomerEntity> customers = customerRepository.findAll();

        if (!customers.isEmpty()) {
            return customers.stream().map(a -> customerMapper.toResource(a)).collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    public boolean updateCustomer(long id, CustomerDto dto) {
        Optional<CustomerEntity> customerOpt = customerRepository.findById(id);

        if (customerOpt.isEmpty()) {
            throw new CustomerNotFoundException();
        }

        CustomerEntity customer = customerOpt.get();
        if (dto.getFirstName() != null) {
            customer.setFirstName(dto.getFirstName());
        }

        if (dto.getLastName() != null) {
            customer.setLastName(dto.getLastName());
        }

        if (dto.getAddress() != null) {
            customer.setAddress(dto.getAddress());
        }
        customerRepository.save(customer);

        return true;
    }

    @Override
    public CustomerResponse getUserByUsernameOrEmail(CustomerDto dto) {
        CustomerEntity entity = customerMapper.toEntity(dto);
        Optional<CustomerEntity> customer = customerRepository.findByUsernameOrEmail(entity.getUsername(), entity.getEmail());
        if (customer.isPresent()) {
            return customerMapper.toResource(customer.get());
        } else {
            throw new CustomerNotFoundException();
        }
    }

    @Override
    public CustomerResponse getCustomerResponseById(Long customerID) {
        return customerMapper.toResource(getCustomerById(customerID));
    }

    @Override
    public CustomerEntity getCustomerById(Long id) {
        Optional<CustomerEntity> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return customer.get();
        } else {
            throw new CustomerNotFoundException();
        }
    }
}