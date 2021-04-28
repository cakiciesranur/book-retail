package com.eny.bookretail.exception.runtime;

import com.eny.bookretail.enums.ErrorMessage;

public class ProductNotFoundException extends ApplicationRuntimeException {
    public ProductNotFoundException() {
        super(ErrorMessage.PRODUCT_NOT_FOUND.getMessage(), ErrorMessage.PRODUCT_NOT_FOUND.getCode());
    }
}
