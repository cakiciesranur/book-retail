package com.eny.bookretail.exception.runtime;


import com.eny.bookretail.enums.ErrorMessage;

public class NotFoundException extends ApplicationRuntimeException {

    public NotFoundException() {
        super(ErrorMessage.NOT_FOUND.getMessage(), ErrorMessage.NOT_FOUND.getCode());
    }
}