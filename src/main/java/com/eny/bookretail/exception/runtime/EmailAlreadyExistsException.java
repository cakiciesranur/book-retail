package com.eny.bookretail.exception.runtime;

import com.eny.bookretail.enums.ErrorMessage;

public class EmailAlreadyExistsException extends ApplicationRuntimeException {

    public EmailAlreadyExistsException() {
        super(ErrorMessage.USERNAME_EXIST.getMessage(), ErrorMessage.USERNAME_EXIST.getCode());
    }
}