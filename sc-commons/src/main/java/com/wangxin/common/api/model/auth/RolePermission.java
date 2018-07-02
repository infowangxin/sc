package com.wangxin.common.api.model.auth;

import com.wangxin.common.api.model.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
 * @Description 角色与菜单关系对象
 * @author 王鑫 
 * @date Apr 12, 2017 9:11:20 AM  
 */
@ApiModel(value = "RolePermission", description = "角色与菜单关系对象")
public class RolePermission extends BaseEntity<String> {

    private static final long serialVersionUID = -7948507636703811294L;

    @ApiModelProperty(name = "id", value = "ID", dataType = "String")
    private String id;

    @ApiModelProperty(name = "roleId", value = "角色ID", dataType = "String")
    private String roleId;

    @ApiModelProperty(name = "permissionId", value = "菜单ID", dataType = "String")
    private String permissionId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

}
