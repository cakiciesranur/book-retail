package com.eny.bookretail.controller;

import com.eny.bookretail.dto.request.CreateCustomerDto;
import com.eny.bookretail.dto.request.CustomerDto;
import com.eny.bookretail.dto.response.CustomerResponse;
import com.eny.bookretail.dto.response.GenericResponse;
import com.eny.bookretail.model.CustomerEntity;
import com.eny.bookretail.service.GenericResponseService;
import com.eny.bookretail.service.ICustomerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private GenericResponseService genericResponseService;

    @GetMapping("/{id}")
    @ApiOperation(value = "This gets customer info by id")
    public GenericResponse getCustomerById(@PathVariable("id") long id) {
        CustomerResponse response = customerService.getCustomerResponseById(id);
        return genericResponseService.createResponseNoError(" ", response);
    }

    @PostMapping("/getUserByUsernameOrEmail")
    @ApiOperation(value = "This gets customer informations by username or email")
    public GenericResponse getUserByUsernameOrEmail(@Valid @RequestBody CustomerDto dto) {
        CustomerResponse response = customerService.getUserByUsernameOrEmail(dto);
        return genericResponseService.createResponseNoError("", response);

    }

    @PostMapping("/createCustomer")
    @ApiOperation(value = "This creates a new customer")
    public GenericResponse createCustomer(@Valid @RequestBody CreateCustomerDto createCustomerDto) {

        CustomerEntity customer = customerService.createCustomer(createCustomerDto);
        return genericResponseService.createResponseNoError("Created customer successfully!", customer);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "This updates an existing customer")
    public GenericResponse updateCustomer(@PathVariable("id") long id, @Valid @RequestBody CustomerDto request) {
        boolean isUpdated = customerService.updateCustomer(id, request);
        return genericResponseService.createResponseNoError("Updated customer successfully!", isUpdated);
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "This gives a list of all customers.")
    public GenericResponse getCustomers() {
        List<CustomerResponse> customers = customerService.getAllCustomers();
        return genericResponseService.createResponseNoError("", customers);
    }
}
