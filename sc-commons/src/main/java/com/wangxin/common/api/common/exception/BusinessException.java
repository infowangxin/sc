package com.wangxin.common.api.common.exception;

public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1144969267587138347L;

    public BusinessException(String code, String message, Exception cause) {
        super(code + ":" + message, cause);
    }

    public BusinessException(String code, String message) {
        super(code + ":" + message);
    }

    public BusinessException() {
        super();
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

}
