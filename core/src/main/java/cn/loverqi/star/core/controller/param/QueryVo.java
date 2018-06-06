package cn.loverqi.star.core.controller.param;

import java.util.HashMap;
import java.util.Map;

/**
 * 将查询数据包装为map
 * @author LoverQi
 * @date 2018年6月7日
 */
public class QueryVo {
    private Map<String, Object> params = new HashMap<String, Object>();

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}