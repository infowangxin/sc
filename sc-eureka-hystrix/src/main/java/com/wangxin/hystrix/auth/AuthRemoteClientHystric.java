package com.wangxin.hystrix.auth;

import com.wangxin.api.model.auth.PermissionVo;
import com.wangxin.api.model.auth.Role;
import com.wangxin.api.model.auth.User;
import com.wangxin.web.auth.AuthRemoteClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class AuthRemoteClientHystric implements AuthRemoteClient {

    private static final Logger log = LoggerFactory.getLogger(AuthRemoteClientHystric.class);

    @Override
    public User findUserByName(String username) {
        log.error("#Hystric findUserByName error ");
        return null;
    }

    @Override
    public List<Role> findRoleByUserId(String userId) {
        log.error("#Hystric findRoleByUserId error ");
        return null;
    }

    @Override
    public List<PermissionVo> getPermissions(String userId) {
        log.error("#Hystric getPermissions error ");
        return null;
    }
}
