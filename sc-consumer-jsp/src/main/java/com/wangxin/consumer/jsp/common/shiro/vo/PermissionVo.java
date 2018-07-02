package com.wangxin.consumer.jsp.common.shiro.vo;

import java.util.List;

import com.wangxin.common.api.model.auth.Permission;

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
