package com.nutcarcker.openfeign.entity;

import java.io.Serializable;


/**
 * 消息实体对象
 *
 * @author 胡桃夹子
 * @date 2022/1/24 10:00
 */
public class AppEntity implements Serializable {

    private static final long serialVersionUID = 4732186081041434484L;

    /**
     * 应用名称
     */
    private String name;

    /**
     * 端口
     */
    private Integer port;

    /**
     * 差
     */
    private Integer diff;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPort() {
        return this.port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getDiff() {
        return diff;
    }

    public void setDiff(Integer diff) {
        this.diff = diff;
    }

    @Override
    public String toString() {
        String sb = getClass().getSimpleName() +
                " {" +
                "\"name\":\"" +
                name + '\"' +
                ",\"point\":" +
                port +
                ",\"diff\":" +
                diff +
                '}';
        return sb;
    }
}
