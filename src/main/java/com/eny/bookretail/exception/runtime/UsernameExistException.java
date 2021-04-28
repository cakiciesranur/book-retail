package com.eny.bookretail.exception.runtime;

import com.eny.bookretail.enums.ErrorMessage;

public class UsernameExistException extends ApplicationRuntimeException {

    public UsernameExistException() {
        super(ErrorMessage.USERNAME_EXIST.getMessage(), ErrorMessage.USERNAME_EXIST.getCode());
    }
}
