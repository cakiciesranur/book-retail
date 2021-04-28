package com.eny.bookretail.service.impl;

import com.eny.bookretail.dto.response.GenericResponse;
import com.eny.bookretail.dto.response.JwtAuthenticationResponse;
import com.eny.bookretail.security.JwtTokenProvider;
import com.eny.bookretail.service.GenericResponseService;
import com.eny.bookretail.service.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;


    @Autowired
    private GenericResponseService genericResponseService;

    @Override
    public GenericResponse login(String usernameOrEmail, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usernameOrEmail, password));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);

        return genericResponseService.createResponseNoError("", new JwtAuthenticationResponse(jwt));
    }
}
