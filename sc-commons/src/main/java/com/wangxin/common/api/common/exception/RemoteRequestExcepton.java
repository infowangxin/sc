package com.wangxin.common.api.common.exception;

public class RemoteRequestExcepton extends BusinessException{


    private static final long serialVersionUID = 2480398104523852817L;

    public RemoteRequestExcepton(String code, String message, Exception cause) {
        super(code + ":" + message, cause);
    }

    public RemoteRequestExcepton(String code, String message) {
        super(code + ":" + message);
    }

    public RemoteRequestExcepton() {
        super();
    }

    public RemoteRequestExcepton(String message, Throwable cause) {
        super(message, cause);
    }

    public RemoteRequestExcepton(String message) {
        super(message);
    }

    public RemoteRequestExcepton(Throwable cause) {
        super(cause);
    }

}
