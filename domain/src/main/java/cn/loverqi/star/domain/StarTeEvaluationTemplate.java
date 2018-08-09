package cn.loverqi.star.domain;

import java.util.Date;
import cn.loverqi.star.core.basepojo.ExcelPojo;

/**
 * 评价模板表实体类
 * @author LoverQi
 * @date 2018年8月09日
 */
public class StarTeEvaluationTemplate extends ExcelPojo {

    /** 默认序列号*/
    private static final long serialVersionUID = 1L;

    /** 模板id*/
    private Integer id;

    /** 模板名称*/
    private String name;

    /** 模板状态*/
    private Integer state;

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