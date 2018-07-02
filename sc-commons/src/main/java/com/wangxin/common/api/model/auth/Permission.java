package com.wangxin.common.api.model.auth;

import com.wangxin.common.api.model.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description 菜单对象
 * @author 王鑫
 * @date Apr 12, 2017 9:10:38 AM
 */
@ApiModel(value = "Permission", description = "菜单实体类")
public class Permission extends BaseEntity<String> {

    private static final long serialVersionUID = -7141829387338999544L;

    @ApiModelProperty(name = "id", value = "ID", dataType = "String")
    private String id;

    @ApiModelProperty(name = "name", value = "菜单名称", dataType = "String")
    private String name;

    @ApiModelProperty(name = "cssClass", value = "菜单样式图标名称", dataType = "String")
    private String cssClass;

    @ApiModelProperty(name = "key", value = "菜单编码", dataType = "String")
    private String key;

    @ApiModelProperty(name = "hide", value = "菜单是否显示", dataType = "Integer")
    private Integer hide;

    @ApiModelProperty(name = "lev", value = "菜单级别，最多三级", dataType = "Integer")
    private Integer lev;

    @ApiModelProperty(name = "url", value = "菜单URL", dataType = "String")
    private String url;

    @ApiModelProperty(name = "sort", value = "显示顺序", dataType = "Integer")
    private Integer sort;

    @ApiModelProperty(name = "parentKey", value = "父菜单编码", dataType = "String")
    private String parentKey;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getHide() {
        return hide;
    }

    public void setHide(Integer hide) {
        this.hide = hide;
    }

    public Integer getLev() {
        return lev;
    }

    public void setLev(Integer lev) {
        this.lev = lev;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getParentKey() {
        return parentKey;
    }

    public void setParentKey(String parentKey) {
        this.parentKey = parentKey;
    }

}
