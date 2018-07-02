package com.wangxin.common.api.model;

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

}
