package com.eny.bookretail.dto.request;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel(value = "New Book DTO", description = "Information for creating book")
public class BookDto {

    private long bookId;

    @NotNull
    private String name;

    @NotNull
    private String author;

    private String description;

    @NotNull
    private double unitPrice;

    private StockDto stock;
}