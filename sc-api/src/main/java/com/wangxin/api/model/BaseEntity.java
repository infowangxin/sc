package com.wangxin.api.model;

import java.io.Serializable;

/**
 * @Description 实体基类
 * @author 王鑫
 * @date Mar 16, 2017 3:25:15 PM
 * @param <E>
 */
public abstract class BaseEntity<E extends Serializable> implements Serializable {

    private static final long serialVersionUID = -1975107873497237831L;

    public abstract E getId();

    private String resultStatus;

    private String resultMessage;

    public String getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

}
