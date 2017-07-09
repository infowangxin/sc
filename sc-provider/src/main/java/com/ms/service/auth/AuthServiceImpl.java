package com.ms.service.auth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.api.model.auth.Role;
import com.ms.api.model.auth.User;
import com.ms.mapper.auth.RoleMapper;
import com.ms.mapper.auth.UserMapper;

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
