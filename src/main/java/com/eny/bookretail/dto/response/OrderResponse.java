package com.eny.bookretail.dto.response;

import com.eny.bookretail.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {

    private long id;
    private OrderStatus status;
    List<OrderDetailsResponse> orderDetails = new ArrayList<>();
}
