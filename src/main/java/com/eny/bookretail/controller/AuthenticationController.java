package com.eny.bookretail.controller;

import com.eny.bookretail.dto.request.LoginDto;
import com.eny.bookretail.dto.response.GenericResponse;
import com.eny.bookretail.service.IAuthenticationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@Api(value = "Authentication Services")
public class AuthenticationController {

    @Autowired
    private IAuthenticationService authenticationService;

    @PostMapping("/login")
    @ApiOperation(value="This does authentication for user")
    public GenericResponse authenticateUser(@Valid @RequestBody LoginDto loginRequest) {
        return authenticationService.login(loginRequest.getUsernameOrEmail(), (loginRequest.getPassword()));
    }
}