package cn.loverqi.star.domain;

import java.util.Date;
import cn.loverqi.star.core.basepojo.ExcelPojo;

/**
 * 评分活动表实体类
 * @author LoverQi
 * @date 2018年8月07日
 */
public class StarTeEvaluationActivity extends ExcelPojo {

    /** 默认序列号*/
    private static final long serialVersionUID = 1L;

    /** 活动id*/
    private Integer id;

    /** 模板d*/
    private Integer templateId;

    /** 活动名称*/
    private String name;

    /** 活动状态*/
    private Integer state;

    /** 相关用户组，暂时不维护多对多的关系*/
    private String groupIds;

    /** 活动开始时间*/
    private Date starTime;

    /** 活动结束时间*/
    private Date endTime;

    /** 备注*/
    private String remark;

    /** 创建时间*/
    private Date createDate;

    /** 最后修改时间*/
    private Date updateDate;

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return id;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }
    
    public Integer getTemplateId() {
        return templateId;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
    
    public String getName() {
        return name;
    }

    public void setState(Integer state) {
        this.state = state;
    }
    
    public Integer getState() {
        return state;
    }

    public void setGroupIds(String groupIds) {
        this.groupIds = groupIds == null ? null : groupIds.trim();
    }
    
    public String getGroupIds() {
        return groupIds;
    }

    public void setStarTime(Date starTime) {
        this.starTime = starTime;
    }
    
    public Date getStarTime() {
        return starTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    
    public Date getEndTime() {
        return endTime;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
    
    public String getRemark() {
        return remark;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
    public Date getCreateDate() {
        return createDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    
    public Date getUpdateDate() {
        return updateDate;
    }

}