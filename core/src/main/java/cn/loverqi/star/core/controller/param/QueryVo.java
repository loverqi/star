package cn.loverqi.star.core.controller.param;

import java.util.HashMap;
import java.util.Map;

/**
 * 将查询数据包装为map
 * @author LoverQi
 * @date 2018年6月7日
 */
public class QueryVo {
    /** 数据集*/
    private Map<String, Object> params = new HashMap<String, Object>();

    /** page页*/
    private Integer page;

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

}