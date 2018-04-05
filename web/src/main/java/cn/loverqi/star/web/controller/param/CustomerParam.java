package cn.loverqi.star.web.controller.param;

import cn.loverqi.star.domain.Customer;

/**
 * Customer的查询类
 * @author LoverQi
 * @date 2018年4月3日
 */
public class CustomerParam extends Customer {

    private static final long serialVersionUID = 6607969548662713493L;

    /** 页码*/
    private Integer page;

    /** 每页的个数*/
    private Integer pageSize;

    /** 开始时间*/
    private String startTime;

    /** 结束时间*/
    private String endTime;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

}
