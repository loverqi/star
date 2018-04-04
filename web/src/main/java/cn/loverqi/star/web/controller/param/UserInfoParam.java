package cn.loverqi.star.web.controller.param;

import cn.loverqi.star.domain.UserInfo;

/**
 * UserInfo的查询类
 * @author LoverQi
 * @date 2018年4月3日
 */
public class UserInfoParam extends UserInfo {

    private static final long serialVersionUID = -5211766008524372865L;

    /** 页码*/
    private Integer page;

    /** 每页的个数*/
    private Integer pageSize;

    /**
     * @return page
     */
    public Integer getPage() {
        return page;
    }

    /**
     * @param page 要设置的 page
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     * @return pageSize
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize 要设置的 pageSize
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
