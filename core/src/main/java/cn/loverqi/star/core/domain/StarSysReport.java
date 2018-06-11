package cn.loverqi.star.core.domain;

import java.util.Date;

import cn.loverqi.star.core.basepojo.BasePojo;

/**
 * 报表实体类
 * @author LoverQi
 * @date 2018年6月03日
 */
public class StarSysReport extends BasePojo {

    /** 默认序列号*/
    private static final long serialVersionUID = -324723302732813798L;

    /** 主键*/
    private Integer id;

    /** 报表名称*/
    private String name;

    /** 报表标题*/
    private String title;

    /** 工作空间(用于指定js地址)*/
    private String namespace;

    /** 数据源*/
    private String beanClass;

    /** 查询sql，与beanClass不能同时为空*/
    private String querySql;

    /** 每页的页数*/
    private Integer pageSize;

    /** 创建时间*/
    private Date createTime;

    /** 显示上传按钮*/
    private Boolean operationUpload;

    /** 显示下载按钮*/
    private Boolean operationDownload;

    /** 查看操作JS方法*/
    private String operationViewFunc;

    /** 编辑操作JS方法*/
    private String operationEditFunc;

    /** 删除操作JS方法*/
    private String operationDeleteFunc;

    /** 是否启用权限*/
    private Boolean permissionsEnable;

    /** 是否启用*/
    private Boolean enable;

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

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public void setBeanClass(String beanClass) {
        this.beanClass = beanClass == null ? null : beanClass.trim();
    }

    public String getBeanClass() {
        return beanClass;
    }

    public String getQuerySql() {
        return querySql;
    }

    public void setQuerySql(String querySql) {
        this.querySql = querySql;
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

    public void setOperationUpload(Boolean operationUpload) {
        this.operationUpload = operationUpload;
    }

    public Boolean getOperationUpload() {
        return operationUpload;
    }

    public void setOperationDownload(Boolean operationDownload) {
        this.operationDownload = operationDownload;
    }

    public Boolean getOperationDownload() {
        return operationDownload;
    }

    public void setOperationViewFunc(String operationViewFunc) {
        this.operationViewFunc = operationViewFunc == null ? null : operationViewFunc.trim();
    }

    public String getOperationViewFunc() {
        return operationViewFunc;
    }

    public void setOperationEditFunc(String operationEditFunc) {
        this.operationEditFunc = operationEditFunc == null ? null : operationEditFunc.trim();
    }

    public String getOperationEditFunc() {
        return operationEditFunc;
    }

    public void setOperationDeleteFunc(String operationDeleteFunc) {
        this.operationDeleteFunc = operationDeleteFunc == null ? null : operationDeleteFunc.trim();
    }

    public String getOperationDeleteFunc() {
        return operationDeleteFunc;
    }

    public void setPermissionsEnable(Boolean permissionsEnable) {
        this.permissionsEnable = permissionsEnable;
    }

    public Boolean getPermissionsEnable() {
        return permissionsEnable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Boolean getEnable() {
        return enable;
    }
}