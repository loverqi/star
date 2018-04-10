package cn.loverqi.star.domain;

import java.util.Date;

import cn.loverqi.star.core.annotation.FieldIgnore;
import cn.loverqi.star.core.basepojo.BasePojo;

/**
 * 账单类
 * @author LoverQi
 * @date 2018年4月3日
 */
public class Bill extends BasePojo {
    private static final long serialVersionUID = -5020016840646173358L;

    private Integer id;

    /** 微信号*/
    private String wechatNumber;

    /** 微信名*/
    private String wechatName;

    private String imgPath;

    private Integer peopleNumber;

    private Double moneySum;

    /** 创建人*/
    private Integer createUser;

    /** 创建人*/
    @FieldIgnore
    private UserInfo createUserBean;

    /** 创建时间*/
    private Date createDate;

    /** 客户来源*/
    private String customerSource;

    /** 账单状态*/
    private String billingStatus;

    private boolean ifSee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(Integer peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    public Double getMoneySum() {
        return moneySum;
    }

    public void setMoneySum(Double moneySum) {
        this.moneySum = moneySum;
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

    public String getBillingStatus() {
        return billingStatus;
    }

    public void setBillingStatus(String billingStatus) {
        this.billingStatus = billingStatus == null ? null : billingStatus.trim();
    }

    public boolean isIfSee() {
        return ifSee;
    }

    public void setIfSee(boolean ifSee) {
        this.ifSee = ifSee;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public UserInfo getCreateUserBean() {
        return createUserBean;
    }

    public void setCreateUserBean(UserInfo createUserBean) {
        this.createUserBean = createUserBean;
    }

}