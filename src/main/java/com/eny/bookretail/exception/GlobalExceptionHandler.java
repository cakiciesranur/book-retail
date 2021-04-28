package com.eny.bookretail.exception;

import com.eny.bookretail.dto.response.GenericResponse;
import com.eny.bookretail.enums.ErrorMessage;
import com.eny.bookretail.exception.runtime.ApplicationRuntimeException;
import com.eny.bookretail.exception.runtime.AuthenticationException;
import com.eny.bookretail.service.GenericResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    GenericResponseService genericResponseService;

    @ExceptionHandler({AuthenticationException.class})
    public final ResponseEntity<GenericResponse<Object>> handleAuthenticationException(RuntimeException e) {
        return new ResponseEntity<GenericResponse<Object>>(genericResponseService.createResponseWithError(e.getMessage()),
                HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({AccessDeniedException.class})
    public final ResponseEntity<GenericResponse<Object>> handleAuthenticationException(AccessDeniedException e) {
        return new ResponseEntity<GenericResponse<Object>>(genericResponseService.createResponseWithError(e.getMessage()),
                HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({BadCredentialsException.class})
    public final ResponseEntity<GenericResponse<Object>> handleBadCredentialsException(BadCredentialsException e) {
        return new ResponseEntity<GenericResponse<Object>>(genericResponseService.createResponseWithError(ErrorMessage.BAD_CREDENTIALS_ERROR.getMessage(), e.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ApplicationRuntimeException.class})
    public final ResponseEntity<GenericResponse<Object>> handleApplicationRuntimeException(ApplicationRuntimeException e) {
        return new ResponseEntity<GenericResponse<Object>>(genericResponseService.createResponseWithError(e.getMessage(), e.getErrorCode()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public final ResponseEntity<GenericResponse<Object>> handleApplicationRuntimeException(MethodArgumentNotValidException e) {
        return new ResponseEntity<GenericResponse<Object>>(genericResponseService.createResponseWithError(ErrorMessage.VALIDATION_ERROR.getMessage(), e.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({Exception.class})
    public final ResponseEntity<GenericResponse<Object>> handleOtherException(Exception e) {
        return new ResponseEntity<GenericResponse<Object>>(genericResponseService.createResponseWithError(ErrorMessage.UNKNOWN_ERROR.getMessage()),
                HttpStatus.BAD_REQUEST);

    }

}
