package com.eny.bookretail.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@ApiModel(value ="User DTO", description ="User Transfer Object")
public class CustomerDto implements Serializable {
    private static final long serialVersionUID = -5864930635003583949L;

    @ApiModelProperty(value="first name field", required = true)
    @Size(min = 4, max = 40)
    private String firstName;

    @ApiModelProperty(value="last name field", required = true)
    @Size(min = 4, max = 40)
    private String lastName;

    @ApiModelProperty(value="username field", required = true)
    @Size(min = 3, max = 15)
    private String username;

    @ApiModelProperty(value="email field", required = true)
    @Size(max = 40)
    @Email
    private String email;

    @ApiModelProperty(value="address field")
    @Size(max = 250)
    private String address;

}
