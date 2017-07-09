package com.ms.api.model;

import java.io.Serializable;


/** 
 * @Description 实体基类
 * @author 王鑫 
 * @date Mar 16, 2017 3:25:15 PM 
 * @param <E> 
 */
public interface BaseEntity<E extends Serializable> extends Serializable {

	public E getId();

}
