package cn.loverqi.star.domain;

import java.util.Date;
import cn.loverqi.star.core.basepojo.ExcelPojo;

/**
 * 学生评价分数表实体类
 * @author LoverQi
 * @date 2018年8月07日
 */
public class StarTeStudentScore extends ExcelPojo {

    /** 默认序列号*/
    private static final long serialVersionUID = 1L;

    /** 分数id*/
    private Integer id;

    /** 关联用户id*/
    private Integer userId;

    /** 关联活动id*/
    private Integer activityId;

    /** 分数*/
    private Double score;

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

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public Integer getUserId() {
        return userId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }
    
    public Integer getActivityId() {
        return activityId;
    }

    public void setScore(Double score) {
        this.score = score;
    }
    
    public Double getScore() {
        return score;
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