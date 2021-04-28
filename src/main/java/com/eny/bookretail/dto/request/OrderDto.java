package com.eny.bookretail.dto.request;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(value ="Create Order DTO", description ="Create Order Data Transfer Object")
public class OrderDto {
    @NotNull
    private String customerId;
    @NotNull
    private List<OrderItemDto> orderItems = new ArrayList<>();
    @NotNull
    private double totalPrice;

}
