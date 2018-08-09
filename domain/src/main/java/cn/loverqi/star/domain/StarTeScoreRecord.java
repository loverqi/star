package cn.loverqi.star.domain;

import java.util.Date;
import cn.loverqi.star.core.basepojo.ExcelPojo;

/**
 * 评分记录表实体类
 * @author LoverQi
 * @date 2018年8月09日
 */
public class StarTeScoreRecord extends ExcelPojo {

    /** 默认序列号*/
    private static final long serialVersionUID = 1L;

    /** 分数id*/
    private Integer id;

    /** 评分条目id*/
    private Integer itemId;

    /** 关联活动id*/
    private Integer activityId;

    /** 分数*/
    private Double score;

    /** 是否正向计分；0为负向计分，1为正向计分*/
    private Boolean forwardScore;

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

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }
    
    public Integer getItemId() {
        return itemId;
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

    public void setForwardScore(Boolean forwardScore) {
        this.forwardScore = forwardScore;
    }
    
    public Boolean getForwardScore() {
        return forwardScore;
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