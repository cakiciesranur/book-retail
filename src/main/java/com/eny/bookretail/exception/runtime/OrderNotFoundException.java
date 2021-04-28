package com.eny.bookretail.exception.runtime;

import com.eny.bookretail.enums.ErrorMessage;

public class OrderNotFoundException extends ApplicationRuntimeException {

    public OrderNotFoundException() {
        super(ErrorMessage.ORDER_NOT_FOUND.getMessage(), ErrorMessage.ORDER_NOT_FOUND.getCode());
    }
}