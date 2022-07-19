package com.nutcracker.openfeign.client.response;

import java.io.Serializable;

/**
 * 响应结果包装类
 *
 * @author 胡桃夹子
 * @date 2022-05-03 16:40
 */
public class BaseResponse<T> implements Serializable {
    private static final long serialVersionUID = -4001308558105657575L;

    /**
     * 响应状态
     */
    private Integer status;

    /**
     * 响应描述
     */
    private String message;

    /**
     * 结果实体对象
     */
    private T body;

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getBody() {
        return this.body;
    }

    public void setBody(T body) {
        this.body = body;
    }


    public BaseResponse() {

    }

    public BaseResponse(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public BaseResponse(Integer status, String message, T body) {
        this.status = status;
        this.message = message;
        this.body = body;
    }

}
