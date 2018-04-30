package cn.loverqi.star.core.domain;

import java.util.Date;

import cn.loverqi.star.core.basepojo.BasePojo;

/**
 * 报表主题类
 * @author LoverQi
 * @date 2018年4月21日
 */
public class Report extends BasePojo {
    /** */
    private static final long serialVersionUID = -2361616553048868287L;

    /** 主键*/
    private Integer id;

    /** 报表名称*/
    private String name;

    /** 报表标题*/
    private String title;

    /** 数据源*/
    private String beanClass;

    /** 每页的页数*/
    private Integer pageSize;

    /** 创建时间*/
    private Date createTime;

    /** 操作按钮，根据000-111*/
    private Integer operation;

    /** 是否启用权限*/
    private Byte permissionsEnable;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(String beanClass) {
        this.beanClass = beanClass == null ? null : beanClass.trim();
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getOperation() {
        return operation;
    }

    public void setOperation(Integer operation) {
        this.operation = operation;
    }

    public Byte getPermissionsEnable() {
        return permissionsEnable;
    }

    public void setPermissionsEnable(Byte permissionsEnable) {
        this.permissionsEnable = permissionsEnable;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}