package cn.loverqi.star.domain;

import java.util.Date;

import cn.loverqi.star.core.annotation.ExcelColumn;
import cn.loverqi.star.core.annotation.ExcelName;
import cn.loverqi.star.core.annotation.FieldIgnore;
import cn.loverqi.star.core.basepojo.ExcelPojo;
import cn.loverqi.star.core.domain.StarSysUserInfo;
import cn.loverqi.star.core.utils.StringUtil;

/**
 * 客户类
 * @author LoverQi
 * @date 2018年4月3日
 */
@ExcelName("林晟传媒客户详情")
public class Customer extends ExcelPojo {
    private static final long serialVersionUID = 4087956886528178194L;

    private Integer id;

    /** QQ号*/
    @ExcelColumn(value = "QQ号", order = 1)
    private String qqNumber;

    /** QQ名*/
    @ExcelColumn(value = "QQ名", order = 2)
    private String qqName;

    /** 微信号*/
    @ExcelColumn(value = "微信号", order = 2)
    private String wechatNumber;

    /** 微信名*/
    @ExcelColumn(value = "微信名", order = 4)
    private String wechatName;

    /** 创建人*/
    private Integer createUser;

    /** 创建人*/
    @FieldIgnore
    private StarSysUserInfo createUserBean;

    @FieldIgnore
    @ExcelColumn(value = "创建人", order = 5, width = 6)
    private String createUserName;

    /** 创建时间*/
    @ExcelColumn(value = "创建时间", order = 6)
    private Date createDate;

    /** 客户来源*/
    private String customerSource;

    /** 客户来源*/
    @FieldIgnore
    @ExcelColumn(value = "客户来源", order = 7, width = 5)
    private String customerSourceString;

    /** 客户类型*/
    private String customerType;

    @FieldIgnore
    @ExcelColumn(value = "客户类型", order = 8, width = 6)
    private String customerTypeString;

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

    public void setCreateUserBean(StarSysUserInfo createUserBean) {
        this.createUserBean = createUserBean;
    }

    public StarSysUserInfo getCreateUserBean() {
        return createUserBean;
    }

    public boolean isIfSee() {
        return ifSee;
    }

    public void setIfSee(boolean ifSee) {
        this.ifSee = ifSee;
    }

    public String getCreateUserName() {
        return createUserBean == null ? "-" : createUserBean.getName();
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getCustomerSourceString() {
        String csStr = "-";
        if (StringUtil.isNotNull(customerSource)) {
            switch (customerSource) {
            case "tg":
                csStr = "推广";
                break;
            case "dd":
                csStr = "单导";
                break;
            case "zmt":
                csStr = "自媒体";
                break;
            }
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
        case "自媒体":
            csStr = "zmt";
            break;
        }
        this.customerSourceString = customerSourceString.trim();
        this.customerSource = csStr;
    }

    public String getCustomerTypeString() {
        String bsStr = "-";
        if (StringUtil.isNotNull(customerType)) {
            switch (customerType) {
            case "yhf":
                bsStr = "回复客户";
                break;
            case "whf":
                bsStr = "未回复客户";
                break;
            case "th":
                bsStr = "同行";
                break;
            }
        }

        return bsStr;
    }

    public void setCustomerTypeString(String customerTypeString) {
        String bsStr = "-";
        switch (customerTypeString.trim()) {
        case "回复客户":
            bsStr = "yhf";
            break;
        case "未回复客户":
            bsStr = "whf";
            break;
        case "同行":
            bsStr = "th";
            break;
        }

        this.customerTypeString = customerTypeString.trim();
        this.customerType = bsStr;
    }

}