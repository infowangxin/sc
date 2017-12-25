package com.wangxin.service.auth.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wangxin.api.common.exception.BusinessException;
import com.wangxin.api.model.auth.Permission;
import com.wangxin.api.model.auth.Role;
import com.wangxin.api.model.auth.RolePermission;
import com.wangxin.common.id.RedisIdGenerator;
import com.wangxin.mapper.auth.PermissionMapper;
import com.wangxin.mapper.auth.RoleMapper;
import com.wangxin.mapper.auth.RolePermissionMapper;
import com.wangxin.service.auth.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    private final static Logger log = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Autowired
    private RedisIdGenerator redisIdGenerator;

    @Transactional
    public void addRole(Role role) {
        if (role == null || StringUtils.isBlank(role.getName())) {
            return;
        }
        if (log.isDebugEnabled()) {
            log.debug("## 添加角色 : {}", role.getName());
        }
        Role r = findRoleByCode(role.getCode());
        if (r == null) {
            role.setId(redisIdGenerator.nextUniqueId("T_ROLE_PERMISSION"));
            roleMapper.insert(role);
        }
    }

    @Override
    public Role findRoleByCode(String code) {
        if (log.isDebugEnabled()) {
            log.debug("## 根据编码查询角色 :　{}", code);
        }
        return roleMapper.findRoleByCode(code);
    }

    @Override
    public List<Role> findRoleByUserId(String userId) {
        return roleMapper.findRoleByUserId(userId);
    }

    @Transactional
    @Override
    public void addRolePermission(String roleCode, String permissionKey) {
        Role role = findRoleByCode(roleCode);
        if (role == null) {
            throw new BusinessException("role-fail", "## 给角色授权失败， 角色编码错误");
        }
        Permission permis = permissionMapper.findPermissionByKey(permissionKey);
        if (permis == null) {
            throw new BusinessException("role-fail", "## 给角色授权失败， 菜单KEY不存在，key=" + permissionKey);
        }

        RolePermission rolePermission = new RolePermission();
        rolePermission.setRoleId(role.getId());
        rolePermission.setPermissionId(permis.getId());

        RolePermission rp = rolePermissionMapper.findRolePermission(rolePermission);
        if (rp == null) {
            rolePermission.setId(redisIdGenerator.nextUniqueId("T_ROLE_PERMISSION"));
            rolePermissionMapper.insert(rolePermission);
        }

    }
}
