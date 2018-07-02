package com.wangxin.common.api.model.simple;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wangxin.common.api.model.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description 新闻对象
 * @author 王鑫
 * @date Mar 16, 2017 3:25:39 PM
 */
@ApiModel(value = "News", description = "新闻实体类")
public class News extends BaseEntity<String> {

    private static final long serialVersionUID = 3624947930970250778L;

    @ApiModelProperty(name = "id", value = "ID", dataType = "String")
    private String id;

    @ApiModelProperty(name = "title", value = "新闻标题", dataType = "String")
    private String title;

    @ApiModelProperty(name = "description", value = "新闻内容", dataType = "String")
    private String description;

    @ApiModelProperty(name = "address", value = "新闻发生地址", dataType = "String")
    private String address;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @ApiModelProperty(name = "newsTime", value = "新闻发生时间", dataType = "date", example = "2017-01-01 00:00:00.000")
    private Date newsTime;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @ApiModelProperty(name = "createTime", value = "新闻发布时间", dataType = "date", example = "2017-01-01 00:00:00.000")
    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getNewsTime() {
        return newsTime;
    }

    public void setNewsTime(Date newsTime) {
        this.newsTime = newsTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
