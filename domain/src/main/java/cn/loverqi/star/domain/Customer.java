package cn.loverqi.star.domain;

import java.util.Date;

import cn.loverqi.star.core.annotation.FieldIgnore;
import cn.loverqi.star.core.mybaties.pojo.MyBatisPojo;

/**
 * 客户类
 * @author LoverQi
 * @date 2018年4月3日
 */
public class Customer extends MyBatisPojo {
    private static final long serialVersionUID = 4087956886528178194L;

    private Integer id;

    /** QQ号*/
    private String qqNumber;

    /** QQ名*/
    private String qqName;

    /** 微信号*/
    private String wechatNumber;

    /** 微信名*/
    private String wechatName;

    /** 创建人*/
    private Integer createUser;

    /** 创建人*/
    @FieldIgnore
    private UserInfo createUserBean;

    /** 创建时间*/
    private Date createDate;

    /** 客户来源*/
    private String customerSource;

    /** 客户类型*/
    private String customerType;

    private boolean ifSee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQqNumber() {
        return qqNumber;
    }

    public void setQqNumber(String qqNumber) {
        this.qqNumber = qqNumber == null ? null : qqNumber.trim();
    }

    public String getQqName() {
        return qqName;
    }

    public void setQqName(String qqName) {
        this.qqName = qqName == null ? null : qqName.trim();
    }

    public String getWechatNumber() {
        return wechatNumber;
    }

    public void setWechatNumber(String wechatNumber) {
        this.wechatNumber = wechatNumber == null ? null : wechatNumber.trim();
    }

    public String getWechatName() {
        return wechatName;
    }

    public void setWechatName(String wechatName) {
        this.wechatName = wechatName == null ? null : wechatName.trim();
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCustomerSource() {
        return customerSource;
    }

    public void setCustomerSource(String customerSource) {
        this.customerSource = customerSource == null ? null : customerSource.trim();
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType == null ? null : customerType.trim();
    }

    public void setCreateUserBean(UserInfo createUserBean) {
        this.createUserBean = createUserBean;
    }

    public UserInfo getCreateUserBean() {
        return createUserBean;
    }

    public boolean isIfSee() {
        return ifSee;
    }

    public void setIfSee(boolean ifSee) {
        this.ifSee = ifSee;
    }

}