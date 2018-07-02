package com.wangxin.feign.web.hystrix.auth;

import com.wangxin.common.api.common.exception.BusinessException;
import com.wangxin.common.api.common.exception.RemoteRequestExcepton;
import com.wangxin.common.api.model.auth.PermissionVo;
import com.wangxin.common.api.model.auth.Role;
import com.wangxin.common.api.model.auth.User;
import com.wangxin.feign.web.remote.auth.AuthRemoteClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthRemoteClientHystrix implements AuthRemoteClient {

    private static final Logger log = LoggerFactory.getLogger(AuthRemoteClientHystrix.class);

    @Override
    public User findUserByName(String username) throws BusinessException {
        log.error("# findUserByName Hystrix");
        // TODO business something
        // return null;
        throw new RemoteRequestExcepton("查询用户失败");
    }

    @Override
    public List<Role> findRoleByUserId(String userId) throws BusinessException {
        log.error("# findRoleByUserId Hystrix");
        // TODO business something
        //return null;
        throw new RemoteRequestExcepton("查询用户对应的角色失败");
    }

    @Override
    public List<PermissionVo> getPermissions(String userId) throws BusinessException {
        log.error("# getPermissions Hystrix");
        // TODO business something
        //return null;
        throw new RemoteRequestExcepton("获取用户权限菜单数据失败");
    }
}
