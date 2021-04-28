package com.eny.bookretail.controller;

import com.eny.bookretail.dto.request.OrderDto;
import com.eny.bookretail.dto.request.UpdateOrderDto;
import com.eny.bookretail.dto.response.GenericResponse;
import com.eny.bookretail.dto.response.OrderResponse;
import com.eny.bookretail.service.GenericResponseService;
import com.eny.bookretail.service.IOrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private GenericResponseService genericResponseService;

    @PostMapping("/")
    @ApiOperation(value = "This creates a new order")
    public GenericResponse createOrder(@Valid @RequestBody OrderDto dto) {
        boolean isCreated = orderService.createOrder(dto);
        return genericResponseService.createResponseNoError("Created order successfully!", isCreated);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "This gets order info by id")
    public GenericResponse getOrderById(@PathVariable("id") long id) {
        OrderResponse response = orderService.getOrderById(id);
        return genericResponseService.createResponseNoError(" ", response);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "This updates an existing order")
    public GenericResponse updateOrder(@PathVariable("id") long id, @Valid @RequestBody UpdateOrderDto request) {
        boolean isUpdated = orderService.updateOrder(id, request);
        return genericResponseService.createResponseNoError("Updated customer successfully!", isUpdated);
    }

    @GetMapping("/getCustomerOrders/{id}")
    @ApiOperation(value = "This gets order info by id")
    public GenericResponse getCustomerOrders(@PathVariable("id") long customerId) {
        List<OrderResponse> response = orderService.getCustomerOrders(customerId);
        return genericResponseService.createResponseNoError(" ", response);
    }
}