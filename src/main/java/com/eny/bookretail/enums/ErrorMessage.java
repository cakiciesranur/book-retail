package com.eny.bookretail.enums;

public enum ErrorMessage {
    NO_ERROR(-1, "No error"),
    AUTHENTICATION_ERROR(1, "You have to login!"),
    PARSE_ERROR(2, "Something wrong in your information!"),
    PROCESS_ERROR(3, "Something happened while process. Please try again"),
    JWT_EXPIRED_ERROR(4, "Your session has been expired, please login again."),
    BAD_CREDENTIALS_ERROR(5, "Username or password wrong!"),
    USERNAME_EXIST(6, "The username or email already using!"),
    NOT_FOUND(404, "Nothing found, something wrong!"),
    AUTHORIZATION_ERROR(401, "You are not authorized!"),
    UNKNOWN_ERROR(999, "Unknown Error!"),
    CUSTOMER_NOT_FOUND(1000, "Customer not found, something wrong!"),
    PRODUCT_NOT_FOUND(1001, "Product not found, something wrong!"),
    STOCK_NOT_AVAILABLE(1002, "Stock not available!"),
    ORDER_NOT_FOUND(1003, "Order not found, something wrong!"),
    STOCK_NOT_FOUND(1004, "Stock not found, something wrong!"),
    VALIDATION_ERROR(1010, "Some fields are missing!"),
    ORDER_STATUS_ERROR(1011, "Order status not allowed to update!"),
    ORDER_CANCEL_ERROR(1011, "Order could not cancel, Something is wrong!");

    private int code;
    private String message;

    private ErrorMessage(int errorCode, String message) {
        this.code = errorCode;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
