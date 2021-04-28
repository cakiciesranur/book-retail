package com.eny.bookretail.dto.request;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel(value = "Update Book DTO", description = "Information for updating book")
public class UpdateBookDto {
    @NotNull
    private long bookId;

    private String name;

    private String author;

    private String description;

    private double unitPrice;

    private StockDto stock;
}
