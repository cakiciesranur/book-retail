package com.eny.bookretail.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsResponse {
    private BookResponse book;
    private int quantity;
    private double totalPrice;
    private double price; //TODO: subPrice

}
