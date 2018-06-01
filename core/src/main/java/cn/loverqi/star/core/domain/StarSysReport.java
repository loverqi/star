package cn.loverqi.star.core.domain;

import java.util.Date;

import cn.loverqi.star.core.basepojo.BasePojo;

/**
 * 报表实体类
 * @author LoverQi
 * @date 2018年6月01日
 */
public class StarSysReport extends BasePojo {

    /** */
    private static final long serialVersionUID = 903636686463298995L;

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
    private Integer permissionsEnable;

    /** 是否启用*/
    private Integer enable;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getName() {
        return name;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setBeanClass(String beanClass) {
        this.beanClass = beanClass == null ? null : beanClass.trim();
    }

    public String getBeanClass() {
        return beanClass;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setOperation(Integer operation) {
        this.operation = operation;
    }

    public Integer getOperation() {
        return operation;
    }

    public void setPermissionsEnable(Integer permissionsEnable) {
        this.permissionsEnable = permissionsEnable;
    }

    public Integer getPermissionsEnable() {
        return permissionsEnable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Integer getEnable() {
        return enable;
    }

}