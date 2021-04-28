package com.eny.bookretail.exception.runtime;

import com.eny.bookretail.enums.ErrorMessage;

public class StockNotFoundException extends ApplicationRuntimeException {

    public StockNotFoundException() {
        super(ErrorMessage.STOCK_NOT_FOUND.getMessage(), ErrorMessage.STOCK_NOT_FOUND.getCode());
    }
}