package com.ms.mapper.auth;

import org.apache.ibatis.annotations.Mapper;

import com.ms.api.model.auth.UserRole;
import com.ms.mapper.BaseMapper;

/** 
 * @Description 用户与角色关系Mapper
 * @author 王鑫 
 * @date Apr 12, 2017 9:13:44 AM  
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<String, UserRole> {

}
