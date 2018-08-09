package cn.loverqi.star.domain;

import java.util.Date;
import cn.loverqi.star.core.basepojo.ExcelPojo;

/**
 * 教师信息扩展表实体类
 * @author LoverQi
 * @date 2018年8月09日
 */
public class StarTeTeacherDetail extends ExcelPojo {

    /** 默认序列号*/
    private static final long serialVersionUID = 1L;

    /** 教师id*/
    private Integer id;

    /** 关联用户id*/
    private Integer userId;

    /** 学校*/
    private String school;

    /** 学院*/
    private String college;

    /** 组别nick(冗余）*/
    private String group;

    /** 职称*/
    private String title;

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

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }
    
    public String getSchool() {
        return school;
    }

    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
    }
    
    public String getCollege() {
        return college;
    }

    public void setGroup(String group) {
        this.group = group == null ? null : group.trim();
    }
    
    public String getGroup() {
        return group;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
    
    public String getTitle() {
        return title;
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