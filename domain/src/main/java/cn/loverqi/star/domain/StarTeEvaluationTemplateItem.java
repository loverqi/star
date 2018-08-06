package cn.loverqi.star.domain;

import cn.loverqi.star.core.basepojo.ExcelPojo;

/**
 * 评分模板项目配置表实体类
 * @author LoverQi
 * @date 2018年8月06日
 */
public class StarTeEvaluationTemplateItem extends ExcelPojo {

    /** 默认序列号*/
    private static final long serialVersionUID = 1L;

    /** 规则id*/
    private Integer id;

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return id;
    }

}