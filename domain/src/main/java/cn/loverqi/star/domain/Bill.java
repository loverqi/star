package cn.loverqi.star.domain;

import java.util.Date;

import cn.loverqi.star.core.annotation.ExcelColumn;
import cn.loverqi.star.core.annotation.ExcelName;
import cn.loverqi.star.core.annotation.FieldIgnore;
import cn.loverqi.star.core.basepojo.ExcelPojo;

/**
 * 账单类
 * @author LoverQi
 * @date 2018年4月3日
 */
@ExcelName("账单")
public class Bill extends ExcelPojo {
    private static final long serialVersionUID = -5020016840646173358L;

    private Integer id;

    /** 微信号*/
    @ExcelColumn(value = "微信号", order = 1)
    private String wechatNumber;

    /** 微信名*/
    @ExcelColumn(value = "微信名", order = 2)
    private String wechatName;

    private String imgPath;

    @ExcelColumn(value = "人数", order = 3)
    private Integer peopleNumber;

    @ExcelColumn(value = "金额", order = 4)
    private Double moneySum;

    /** 创建人*/
    private Integer createUser;

    @FieldIgnore
    @ExcelColumn(value = "创建人", order = 5)
    private String createUserName;

    /** 创建人*/
    @FieldIgnore
    private UserInfo createUserBean;

    /** 创建时间*/
    @ExcelColumn(value = "创建时间", order = 6)
    private Date createDate;

    /** 客户来源*/
    @FieldIgnore
    @ExcelColumn(value = "客户来源", order = 7)
    private String customerSourceString;

    private String customerSource;

    /** 账单状态*/
    private String billingStatus;

    @FieldIgnore
    @ExcelColumn(value = "账单状态", order = 8)
    private String billingStatusString;

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

    public String getCreateUserName() {
        return createUserBean == null ? "-" : createUserBean.getName();
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getCustomerSourceString() {
        String csStr = "-";
        switch (customerSource) {
        case "tg":
            csStr = "推广";
            break;
        case "dd":
            csStr = "单导";
            break;
        }
        return csStr;
    }

    public void setCustomerSourceString(String customerSourceString) {
        String csStr = "-";
        switch (customerSourceString.trim()) {
        case "推广":
            csStr = "tg";
            break;
        case "单导":
            csStr = "dd";
            break;
        }
        this.customerSourceString = customerSourceString.trim();
        this.customerSource = csStr;
    }

    public String getBillingStatusString() {
        String bsStr = "-";
        switch (billingStatus) {
        case "wdk":
            bsStr = "未打款";
            break;
        case "ydk":
            bsStr = "已打款";
            break;
        }

        return bsStr;
    }

    public void setBillingStatusString(String billingStatusString) {
        String bsStr = "-";
        switch (customerSourceString.trim()) {
        case "未打款":
            bsStr = "wdk";
            break;
        case "已打款":
            bsStr = "ydk";
            break;
        }
        this.billingStatusString = billingStatusString.trim();
        this.billingStatus = bsStr;
    }

}