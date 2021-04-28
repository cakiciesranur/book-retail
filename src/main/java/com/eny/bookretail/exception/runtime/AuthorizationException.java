package com.eny.bookretail.exception.runtime;


import com.eny.bookretail.enums.ErrorMessage;

public class AuthorizationException extends ApplicationRuntimeException {

    public AuthorizationException() {
        super(ErrorMessage.AUTHORIZATION_ERROR.getMessage(), ErrorMessage.AUTHORIZATION_ERROR.getCode());
    }
}
