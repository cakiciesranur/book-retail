package com.eny.bookretail.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@ApiModel(value ="Login DTO", description ="Login Data Transfer Object")
public class LoginDto implements Serializable {

	private static final long serialVersionUID = 2814677594358347811L;

	@ApiModelProperty(value="username or Email field", required = true)
	@NotBlank
	private String usernameOrEmail;

	@ApiModelProperty(value="password field", required = true)
	@NotBlank
	private String password;
}
