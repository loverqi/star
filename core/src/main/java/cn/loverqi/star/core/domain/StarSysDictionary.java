package cn.loverqi.star.core.domain;

import java.util.Date;

import cn.loverqi.star.core.basepojo.BasePojo;

/**
 * 字典表
 * @author LoverQi
 * @date 2018年5月5日
 */
public class StarSysDictionary extends BasePojo {
    /** */
    private static final long serialVersionUID = -3302540389259957225L;

    /** 主键id*/
    private Integer id;

    /** 字典名*/
    private String name;

    /** 字典注释*/
    private String text;

    /** 字典值*/
    private String value;

    /** 更新时间*/
    private Date updateTime;

    /** 更新人*/
    private Integer updateUser;

    /** 是否启用*/
    private Boolean enable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}