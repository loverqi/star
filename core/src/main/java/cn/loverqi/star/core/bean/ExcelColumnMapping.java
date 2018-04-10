package cn.loverqi.star.core.bean;

import java.io.Serializable;

/**
 * 用于指定excel字段的名称等信息
 * @author LoverQi
 * @date 2018年4月10日
 */
public class ExcelColumnMapping implements Serializable, Comparable<ExcelColumnMapping> {

    private static final long serialVersionUID = 4840812379091958707L;

    /** 字段名*/
    private String name;
    /** 字段的英文名*/
    private String fieldName;
    /** 排序字段*/
    private int order;

    private boolean ifUtf;

    public ExcelColumnMapping() {
        super();
    }

    public ExcelColumnMapping(String name, String fieldName, int order, boolean ifUtf) {
        super();
        this.name = name;
        this.fieldName = fieldName;
        this.order = order;
        this.ifUtf = ifUtf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isIfUtf() {
        return ifUtf;
    }

    public void setIfUtf(boolean ifUtf) {
        this.ifUtf = ifUtf;
    }

    @Override
    public int compareTo(ExcelColumnMapping o) {
        return this.getOrder() - o.getOrder();
    }

}
