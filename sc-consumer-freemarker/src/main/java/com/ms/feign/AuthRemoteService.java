package com.ms.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ms.api.model.auth.PermissionVo;
import com.ms.api.model.auth.Role;
import com.ms.api.model.auth.User;

@FeignClient(path = "auth", value = "providerServer")
public interface AuthRemoteService {

    @RequestMapping(value = "/findUserByName/{username}", method = RequestMethod.GET)
    User findUserByName(@PathVariable("username") String username);

    @RequestMapping(value = "/findRoleByUserId/{userId}", method = RequestMethod.GET)
    List<Role> findRoleByUserId(@PathVariable("userId") String userId);

    @RequestMapping(value = "/getPermissions/{userId}", method = RequestMethod.GET)
    List<PermissionVo> getPermissions(@PathVariable("userId") String userId);

}
