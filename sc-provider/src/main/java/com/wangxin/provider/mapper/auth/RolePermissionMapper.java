package com.wangxin.provider.mapper.auth;

import org.apache.ibatis.annotations.Mapper;

import com.wangxin.common.api.model.auth.RolePermission;
import com.wangxin.provider.mapper.BaseMapper;

/** 
 * @Description 角色与菜单关系Mapper
 * @author 王鑫 
 * @date Apr 12, 2017 9:13:04 AM  
 */
@Mapper
public interface RolePermissionMapper extends BaseMapper<String, RolePermission> {

    public RolePermission findRolePermission(RolePermission per);

}
