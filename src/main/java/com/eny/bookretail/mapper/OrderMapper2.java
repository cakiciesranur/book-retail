package com.eny.bookretail.mapper;

import com.eny.bookretail.dto.response.OrderDetailsResponse;
import com.eny.bookretail.dto.response.OrderResponse;
import com.eny.bookretail.model.OrderDetailEntity;
import com.eny.bookretail.model.OrderEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class OrderMapper2 {
    public OrderResponse toResource(OrderEntity entity) {
        if (entity != null) {
            OrderResponse response = new OrderResponse();
            if (entity.getId() != null) {
                response.setId(entity.getId());
            }
            response.setOrderDetails(orderDetailEntityListToOrderDetailsResponseList(entity.getOrderDetails()));
            return response;
        }
        return null;
    }

    protected List<OrderDetailsResponse> orderDetailEntityListToOrderDetailsResponseList(List<OrderDetailEntity> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        List<OrderDetailsResponse> list1 = new ArrayList<>(list.size());
        for (OrderDetailEntity orderDetailEntity : list) {
            list1.add(orderDetailEntityToOrderDetailsResponse(orderDetailEntity));

        }
        return list1;
    }

    protected OrderDetailsResponse orderDetailEntityToOrderDetailsResponse(OrderDetailEntity orderDetailEntity) {
        if (orderDetailEntity == null) {
            return null;
        }

        OrderDetailsResponse orderDetailsResponse = new OrderDetailsResponse();

        orderDetailsResponse.setQuantity(orderDetailEntity.getQuantity());
        orderDetailsResponse.setTotalPrice(orderDetailEntity.getTotalPrice());
        orderDetailsResponse.setPrice(orderDetailEntity.getPrice());
        //orderDetailsResponse.setBookId(orderDetailEntity.getBook().getId());

        return orderDetailsResponse;
    }
}
