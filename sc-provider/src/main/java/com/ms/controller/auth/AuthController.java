package com.ms.controller.auth;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.ms.api.model.auth.PermissionVo;
import com.ms.api.model.auth.Role;
import com.ms.api.model.auth.User;
import com.ms.api.service.auth.AuthService;
import com.ms.api.service.auth.PermissionService;
import com.ms.api.service.auth.RoleService;
import com.ms.controller.BaseController;

@RestController
@RequestMapping("/auth")
public class AuthController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthService authService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @GetMapping("/findUserByName/{username}")
    ResponseEntity<User> findUserByName(@PathVariable String username) {
        User user = authService.findUserByName(username);
        String result = JSON.toJSONString(user);
        log.debug("{}", result);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/findRoleByUserId/{userId}")
    ResponseEntity<List<Role>> findRoleByUserId(@PathVariable String userId) {
        List<Role> roles = roleService.findRoleByUserId(userId);
        String result = JSON.toJSONString(roles);
        log.debug("{}", result);
        // return result;
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/getPermissions/{userId}")
    ResponseEntity<List<PermissionVo>> getPermissions(@PathVariable String userId) {
        List<PermissionVo> pers = permissionService.getPermissions(userId);
        String result = JSON.toJSONString(pers);
        log.debug("{}", result);
        // return result;
        return new ResponseEntity<>(pers, HttpStatus.OK);
    }

}
