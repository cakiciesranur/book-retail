package com.eny.bookretail.exception.runtime;

import com.eny.bookretail.enums.ErrorMessage;

public class OrderUpdateNotAllowedException  extends ApplicationRuntimeException {

    public OrderUpdateNotAllowedException() {
        super(ErrorMessage.ORDER_STATUS_ERROR.getMessage(), ErrorMessage.ORDER_STATUS_ERROR.getCode());
    }
}
