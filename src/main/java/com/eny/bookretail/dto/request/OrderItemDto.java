package com.eny.bookretail.dto.request;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel(value = "Order Item DTO", description = "Order Item Data Transfer Object")
public class OrderItemDto {
    @NotNull
    private String bookId;
    @NotNull
    private int quantity;
    @NotNull
    private double price;
}
