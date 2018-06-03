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

    /** 数据源*/
    private String beanClass;

    /** 每页的页数*/
    private Integer pageSize;

    /** 创建时间*/
    private Date createTime;

    /** 显示上传按钮*/
    private Integer operationUpload;

    /** 显示下载按钮*/
    private Integer operationDownload;

    /** 查看操作JS方法*/
    private Integer operationViewFunc;

    /** 编辑操作JS方法*/
    private Integer operationEditFunc;

    /** 删除操作JS方法*/
    private Integer operationDeleteFunc;

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

    public void setOperationUpload(Integer operationUpload) {
        this.operationUpload = operationUpload;
    }

    public Integer getOperationUpload() {
        return operationUpload;
    }

    public void setOperationDownload(Integer operationDownload) {
        this.operationDownload = operationDownload;
    }

    public Integer getOperationDownload() {
        return operationDownload;
    }

    public void setOperationViewFunc(Integer operationViewFunc) {
        this.operationViewFunc = operationViewFunc;
    }

    public Integer getOperationViewFunc() {
        return operationViewFunc;
    }

    public void setOperationEditFunc(Integer operationEditFunc) {
        this.operationEditFunc = operationEditFunc;
    }

    public Integer getOperationEditFunc() {
        return operationEditFunc;
    }

    public void setOperationDeleteFunc(Integer operationDeleteFunc) {
        this.operationDeleteFunc = operationDeleteFunc;
    }

    public Integer getOperationDeleteFunc() {
        return operationDeleteFunc;
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