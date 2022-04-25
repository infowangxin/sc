package com.nutcarcker.openfeign.exception;

/**
 * 自定义异常类
 *
 * @author 胡桃夹子
 * @date 2020/2/21 18:08
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 2248546206040115304L;

    private String errorCode;

    public BusinessException() {

    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public BusinessException(Throwable caused) {
        super(caused);
    }

    public String getErrorCode() {
        return errorCode;
    }
}
