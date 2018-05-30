package cn.loverqi.star.domain;

import java.util.List;
import cn.loverqi.star.core.basepojo.INode;
import cn.loverqi.star.core.basepojo.ExcelPojo;

/**
 * 质量问题实体类
 * @author loverqi
 * @date 2018年5月30日
 */
public class Test extends ExcelPojo implements INode<Test>{

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
    private Boolean enable;

    /** */
    private Double date;

    /** */
    private Double number;

    /** */
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

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
    
    public Boolean getEnable() {
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

    /**
     * 获取当前节点的id
     * @return 当前节点的id
     */
    @Override
    public String getOId() {
        // TODO 自动生成的方法存根
        return null;
    }

    /**
     * 获取当前节点的父节点id
     * @return 当前节点的父节点id
     */
    @Override
    public String getPid() {
        // TODO 自动生成的方法存根
        return null;
    }

    /**
     * 设置当前节点的孩子节点
     * @param children 当前节点的孩子节点
     */
    @Override
    public void setChildren(List<Test> children) {
        // TODO 自动生成的方法存根
        
    }
}