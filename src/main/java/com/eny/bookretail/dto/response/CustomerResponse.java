package com.eny.bookretail.dto.response;

import lombok.Data;

@Data
public class CustomerResponse {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String address;
}
