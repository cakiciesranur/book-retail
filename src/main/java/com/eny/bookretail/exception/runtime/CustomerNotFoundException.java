package com.eny.bookretail.exception.runtime;

import com.eny.bookretail.enums.ErrorMessage;

public class CustomerNotFoundException extends ApplicationRuntimeException {

    public CustomerNotFoundException() {
        super(ErrorMessage.CUSTOMER_NOT_FOUND.getMessage(), ErrorMessage.CUSTOMER_NOT_FOUND.getCode());
    }
}
