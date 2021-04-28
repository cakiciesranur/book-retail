package com.eny.bookretail.exception.runtime;

import com.eny.bookretail.enums.ErrorMessage;

public class StockNotAvailableException extends ApplicationRuntimeException {

    public StockNotAvailableException() {
        super(ErrorMessage.STOCK_NOT_AVAILABLE.getMessage(), ErrorMessage.STOCK_NOT_AVAILABLE.getCode());
    }
}
