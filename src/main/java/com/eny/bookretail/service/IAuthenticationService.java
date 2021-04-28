package com.eny.bookretail.service;

import com.eny.bookretail.dto.response.GenericResponse;

public interface IAuthenticationService {

    GenericResponse login(String usernameOrEmail, String password);
}
