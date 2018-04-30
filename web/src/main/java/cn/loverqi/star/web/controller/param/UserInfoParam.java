package cn.loverqi.star.web.controller.param;

import cn.loverqi.star.core.domain.StarSysUserInfo;

/**
 * UserInfo的查询类
 * @author LoverQi
 * @date 2018年4月3日
 */
public class UserInfoParam extends StarSysUserInfo {

    private static final long serialVersionUID = -5211766008524372865L;

    /** 页码*/
    private Integer page;

    /** 每页的个数*/
    private Integer pageSize;

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

}
