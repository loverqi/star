package cn.loverqi.star.domain;

import java.util.Date;
import cn.loverqi.star.core.basepojo.ExcelPojo;

/**
 * 评分模板项目配置表实体类
 * @author LoverQi
 * @date 2018年8月07日
 */
public class StarTeEvaluationTemplateItem extends ExcelPojo {

    /** 默认序列号*/
    private static final long serialVersionUID = 1L;

    /** 规则id*/
    private Integer id;

    /** 模板d*/
    private Integer templateId;

    /** 条目名称*/
    private String name;

    /** 默认初始分值*/
    private Double defaultScore;

    /** 是否正向计分；0为负向计分，1为正向计分*/
    private Boolean forwardScore;

    /** 该项分值上限*/
    private Double scoreUpperLimit;

    /** 一票否决分值下限*/
    private Double scoreLowerLimit;

    /** 评分规则说明*/
    private String ruleDescription;

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

    public void setDefaultScore(Double defaultScore) {
        this.defaultScore = defaultScore;
    }
    
    public Double getDefaultScore() {
        return defaultScore;
    }

    public void setForwardScore(Boolean forwardScore) {
        this.forwardScore = forwardScore;
    }
    
    public Boolean getForwardScore() {
        return forwardScore;
    }

    public void setScoreUpperLimit(Double scoreUpperLimit) {
        this.scoreUpperLimit = scoreUpperLimit;
    }
    
    public Double getScoreUpperLimit() {
        return scoreUpperLimit;
    }

    public void setScoreLowerLimit(Double scoreLowerLimit) {
        this.scoreLowerLimit = scoreLowerLimit;
    }
    
    public Double getScoreLowerLimit() {
        return scoreLowerLimit;
    }

    public void setRuleDescription(String ruleDescription) {
        this.ruleDescription = ruleDescription == null ? null : ruleDescription.trim();
    }
    
    public String getRuleDescription() {
        return ruleDescription;
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