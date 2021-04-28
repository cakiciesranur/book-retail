package com.eny.bookretail.dto.request;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel(value ="Stock DTO", description ="Stock Information")
public class StockDto {

    @NotNull
    private int quantity;
}
