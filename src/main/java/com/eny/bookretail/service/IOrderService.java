package com.eny.bookretail.service;

import com.eny.bookretail.dto.request.OrderDto;
import com.eny.bookretail.dto.request.UpdateOrderDto;
import com.eny.bookretail.dto.response.OrderResponse;

import java.util.List;

public interface IOrderService {
    boolean createOrder(OrderDto dto);

    OrderResponse getOrderById(long id);

    boolean updateOrder(long id, UpdateOrderDto dto);

    List<OrderResponse> getCustomerOrders(long customerId);
}
