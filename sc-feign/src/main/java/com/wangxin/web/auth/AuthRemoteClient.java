package com.wangxin.web.auth;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wangxin.api.model.auth.PermissionVo;
import com.wangxin.api.model.auth.Role;
import com.wangxin.api.model.auth.User;

@FeignClient(path = "auth", value = "provider")
public interface AuthRemoteClient {

    @RequestMapping(value = "/findUserByName/{username}", method = RequestMethod.GET)
    public User findUserByName(@PathVariable("username") String username);

    @RequestMapping(value = "/findRoleByUserId/{userId}", method = RequestMethod.GET)
    public List<Role> findRoleByUserId(@PathVariable("userId") String userId);

    @RequestMapping(value = "/getPermissions/{userId}", method = RequestMethod.GET)
    public List<PermissionVo> getPermissions(@PathVariable("userId") String userId);

}
