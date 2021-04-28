package com.eny.bookretail.dto.response;

import com.eny.bookretail.dto.request.StockDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {
    private long id;
    private String name;
    private String author;
    private String description;
    private double unitPrice;
    private StockDto stock;
}
