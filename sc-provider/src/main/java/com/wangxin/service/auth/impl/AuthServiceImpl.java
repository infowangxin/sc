package com.wangxin.service.auth.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangxin.api.model.auth.Role;
import com.wangxin.api.model.auth.User;
import com.wangxin.mapper.auth.RoleMapper;
import com.wangxin.mapper.auth.UserMapper;
import com.wangxin.service.auth.AuthService;

@Service("authService")
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public User findUserByName(String username) {
        return userMapper.findUserByName(username);
    }

    @Override
    public Role findRoleByRoleCode(String roleCode) {
        return roleMapper.findRoleByCode(roleCode);
    }

    @Override
    public List<User> findUserByRoleCode(String roleCode) {
        return userMapper.findUserByRoleCode(roleCode);
    }

}
