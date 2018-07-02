package com.wangxin.provider.web.remote.impl.auth;

import java.util.List;

import com.wangxin.provider.service.auth.RoleService;
import com.wangxin.feign.web.remote.auth.AuthRemoteClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.wangxin.common.api.model.auth.PermissionVo;
import com.wangxin.common.api.model.auth.Role;
import com.wangxin.common.api.model.auth.User;
import com.wangxin.provider.service.auth.AuthService;
import com.wangxin.provider.service.auth.PermissionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(tags = "权限模块接口类")
@RestController
@RequestMapping("/auth")
public class AuthRemoteClientImpl implements AuthRemoteClient {

    private static final Logger log = LoggerFactory.getLogger(AuthRemoteClientImpl.class);

    @Autowired
    private AuthService authService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @Override
    @ApiOperation(value = "查询用户", notes = "根据用户名查询用户")
    @ApiImplicitParam(name = "username", value = "用户登录账号", required = true, dataType = "String", paramType = "path")
    public User findUserByName(@PathVariable("username") String username) {
        log.debug("# findUserByName , parameter={} ", username);
        User user = authService.findUserByName(username);
        log.debug("# findUserByName , result={}", JSON.toJSONString(user));
        return user;
    }

    @Override
    @ApiOperation(value = "查询用户的角色", notes = "根据用户查询对应所有角色")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "String", paramType = "path")
    public List<Role> findRoleByUserId(@PathVariable("userId") String userId) {
        log.debug("# findRoleByUserId , parameter={} ", userId);
        List<Role> roles = roleService.findRoleByUserId(userId);
        log.debug("# findRoleByUserId , result={}", JSON.toJSONString(roles));
        return roles;
    }

    @Override
    @ApiOperation(value = "查询用户的菜单", notes = "查询用户所能访问的所有菜单")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "String", paramType = "path")
    public List<PermissionVo> getPermissions(@PathVariable("userId") String userId) {
        log.debug("# getPermissions , parameter={} ", userId);
        List<PermissionVo> pers = permissionService.getPermissions(userId);
        log.debug("# getPermissions , result={}", JSON.toJSONString(pers));
        return pers;
    }

}
