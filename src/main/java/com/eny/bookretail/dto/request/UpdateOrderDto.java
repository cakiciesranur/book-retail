package com.eny.bookretail.dto.request;

import com.eny.bookretail.enums.OrderStatus;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel(value = "Update Order DTO", description = "Information for updating order status")
public class UpdateOrderDto {
    @NotNull
    private OrderStatus newOrderStatus;

}
