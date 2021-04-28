package com.eny.bookretail.exception.runtime;

import com.eny.bookretail.enums.ErrorMessage;

public class ProcessException extends ApplicationRuntimeException {

    public ProcessException() {
        super(ErrorMessage.PROCESS_ERROR.getMessage(), ErrorMessage.PROCESS_ERROR.getCode());
    }
}
