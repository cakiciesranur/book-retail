package com.eny.bookretail.exception.runtime;


import com.eny.bookretail.enums.ErrorMessage;

public class AuthenticationException extends ApplicationRuntimeException {

    public AuthenticationException() {
        super(ErrorMessage.AUTHENTICATION_ERROR.getMessage(), ErrorMessage.AUTHENTICATION_ERROR.getCode());
    }
}