package com.eny.bookretail.exception.runtime;

import com.eny.bookretail.enums.ErrorMessage;

public class CancelOrderException  extends ApplicationRuntimeException {

    public CancelOrderException() {
        super(ErrorMessage.ORDER_CANCEL_ERROR.getMessage(), ErrorMessage.ORDER_CANCEL_ERROR.getCode());
    }
}