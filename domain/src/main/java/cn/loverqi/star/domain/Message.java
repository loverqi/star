package cn.loverqi.star.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 消息展示
 * @author LoverQi
 * @date 2018年4月6日
 */
public class Message implements Serializable {

    private static final long serialVersionUID = 606677703603654398L;

    private Integer billMsgCount;

    private Integer cuntomerMsgCount;

    private Date billMsgDate;

    private Date cuntomerMsgDate;

    public Integer getBillMsgCount() {
        return billMsgCount;
    }

    public void setBillMsgCount(Integer billMsgCount) {
        this.billMsgCount = billMsgCount;
    }

    public Integer getCuntomerMsgCount() {
        return cuntomerMsgCount;
    }

    public void setCuntomerMsgCount(Integer cuntomerMsgCount) {
        this.cuntomerMsgCount = cuntomerMsgCount;
    }

    public Date getBillMsgDate() {
        return billMsgDate;
    }

    public void setBillMsgDate(Date billMsgDate) {
        this.billMsgDate = billMsgDate;
    }

    public Date getCuntomerMsgDate() {
        return cuntomerMsgDate;
    }

    public void setCuntomerMsgDate(Date cuntomerMsgDate) {
        this.cuntomerMsgDate = cuntomerMsgDate;
    }

}
