package com.ms.common.shiro.vo;

import java.util.List;

import com.ms.api.model.auth.Permission;

public class PermissionVo extends Permission {

    private static final long serialVersionUID = -2051933842290600230L;

    private List<PermissionVo> children;

    public List<PermissionVo> getChildren() {
        return children;
    }

    public void setChildren(List<PermissionVo> children) {
        this.children = children;
    }

}
