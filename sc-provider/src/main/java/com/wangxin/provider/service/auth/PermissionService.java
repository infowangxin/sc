package com.wangxin.provider.service.auth;

import java.util.List;

import com.wangxin.common.api.model.auth.Permission;
import com.wangxin.common.api.model.auth.PermissionVo;

public interface PermissionService {

    /**
     * 查询用户所能访问的所有菜单
     *
     * @param userId 用户ID
     * @return permissions 菜单
     */
    public List<PermissionVo> getPermissions(String userId);

    /**
     * 添加 菜单
     *
     * @param permission 菜单项
     */
    public void addPermission(Permission permission);
}
