package cn.loverqi.star.domain;

import cn.loverqi.star.core.basepojo.BasePojo;

/**
 * 测试表实体类
 * @author LoverQi
 * @date 2018年5月31日
 */
public class Test extends BasePojo {

    private static final long serialVersionUID = 1L;

    /** 主键*/
    private Integer id;

    /** 报表id*/
    private Integer reportId;

    /** 字段名*/
    private String name;

    /** 字段标题*/
    private String title;

    /** 字段类型(包括字典值)*/
    private Integer type;

    /** 默认值*/
    private String defaultValue;

    /** 对比条件*/
    private String condition;

    /** 是否启用*/
    private Integer enable;

    /** 测试字段*/
    private Double date;

    /** 测试字段*/
    private Double number;

    /** 测试字段*/
    private Double number2;

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return id;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }
    
    public Integer getReportId() {
        return reportId;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
    
    public String getName() {
        return name;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
    
    public String getTitle() {
        return title;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    
    public Integer getType() {
        return type;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue == null ? null : defaultValue.trim();
    }
    
    public String getDefaultValue() {
        return defaultValue;
    }

    public void setCondition(String condition) {
        this.condition = condition == null ? null : condition.trim();
    }
    
    public String getCondition() {
        return condition;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }
    
    public Integer getEnable() {
        return enable;
    }

    public void setDate(Double date) {
        this.date = date;
    }
    
    public Double getDate() {
        return date;
    }

    public void setNumber(Double number) {
        this.number = number;
    }
    
    public Double getNumber() {
        return number;
    }

    public void setNumber2(Double number2) {
        this.number2 = number2;
    }
    
    public Double getNumber2() {
        return number2;
    }

}