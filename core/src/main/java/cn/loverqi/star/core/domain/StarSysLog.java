package cn.loverqi.star.core.domain;

import java.util.Date;

import cn.loverqi.star.core.basepojo.BasePojo;

/**
 * 日志对象
 * @author LoverQi
 * @date 2018年5月5日
 */
public class StarSysLog extends BasePojo {
    private static final long serialVersionUID = 4393402158238021333L;

    /** 主键id*/
    private Integer id;

    /** 访问路径*/
    private String path;

    /** 功能权限名*/
    private String text;

    /** 访问地址*/
    private String ipAddr;

    /** 访问时间*/
    private Date accessTime;

    /** 访问用户*/
    private Integer accessUser;

    /** 是否启用*/
    private Boolean enable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public Date getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(Date accessTime) {
        this.accessTime = accessTime;
    }

    public Integer getAccessUser() {
        return accessUser;
    }

    public void setAccessUser(Integer accessUser) {
        this.accessUser = accessUser;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}