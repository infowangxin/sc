package com.wangxin.common.api.model.auth;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wangxin.common.api.model.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
 * @Description 用户对象
 * @author 王鑫 
 * @date Apr 12, 2017 9:11:44 AM  
 */
@ApiModel(value = "User", description = "用户实体对象")
public class User extends BaseEntity<String> {

    private static final long serialVersionUID = 1227495748732942139L;

    @ApiModelProperty(name = "id", value = "ID", dataType = "String")
    private String id;

    @ApiModelProperty(name = "email", value = "用户邮箱地址", dataType = "String")
    private String email;

    @ApiModelProperty(name = "username", value = "用户登录账号", dataType = "String")
    private String username;

    @ApiModelProperty(name = "trueName", value = "用户名称", dataType = "String")
    private String trueName;

    @ApiModelProperty(name = "password", value = "用户登录密码", dataType = "String")
    private String password;

    @ApiModelProperty(name = "salt", value = "salt码", dataType = "String")
    private String salt;

    @ApiModelProperty(name = "status", value = "状态", dataType = "Integer")
    private Integer status;

    @ApiModelProperty(name = "organizeId", value = "工作流审批的组织ID", dataType = "String")
    private String organizeId;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @ApiModelProperty(name = "createTime", value = "创建时间", dataType = "String", example = "2017-01-01 00:00:00.000")
    private Date createTime;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @ApiModelProperty(name = "lastLoginTime", value = "最后登录时间", dataType = "date", example = "2017-01-01 00:00:00.000")
    private Date lastLoginTime;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @ApiModelProperty(name = "modifyTime", value = "用户最后修改时间", dataType = "date", example = "2017-01-01 00:00:00.000")
    private Date modifyTime;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOrganizeId() {
        return organizeId;
    }

    public void setOrganizeId(String organizeID) {
        this.organizeId = organizeID;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

}
