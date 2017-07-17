package com.ms.remote.impl.auth;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.ms.api.model.auth.PermissionVo;
import com.ms.api.model.auth.Role;
import com.ms.api.model.auth.User;
import com.ms.remote.auth.AuthRemoteClient;
import com.ms.service.auth.AuthService;
import com.ms.service.auth.PermissionService;
import com.ms.service.auth.RoleService;

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

    // @RequestMapping(value = "/findUserByName/{username}", method = RequestMethod.GET)
    // @GetMapping("/findUserByName/{username}")
    @Override
    public User findUserByName(@PathVariable("username") String username) {
        log.debug("# findUserByName , parameter={} ", username);
        User user = authService.findUserByName(username);
        log.debug("# findUserByName , result={}", JSON.toJSONString(user));
        return user;
    }

    // @RequestMapping(value = "/findRoleByUserId/{userId}", method = RequestMethod.GET)
    // @GetMapping("/findRoleByUserId/{userId}")
    @Override
    public List<Role> findRoleByUserId(@PathVariable("userId") String userId) {
        log.debug("# findRoleByUserId , parameter={} ", userId);
        List<Role> roles = roleService.findRoleByUserId(userId);
        log.debug("# findRoleByUserId , result={}", JSON.toJSONString(roles));
        return roles;
    }

    // @RequestMapping(value = "/getPermissions/{userId}", method = RequestMethod.GET)
    // @GetMapping("/getPermissions/{userId}")
    @Override
    public List<PermissionVo> getPermissions(@PathVariable("userId") String userId) {
        log.debug("# getPermissions , parameter={} ", userId);
        List<PermissionVo> pers = permissionService.getPermissions(userId);
        log.debug("# getPermissions , result={}", JSON.toJSONString(pers));
        return pers;
    }

}
