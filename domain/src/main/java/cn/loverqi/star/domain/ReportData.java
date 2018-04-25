package cn.loverqi.star.domain;

import cn.loverqi.star.core.basepojo.BasePojo;

/**
 * 报表数据源显示数据配置类
 * @author LoverQi
 * @date 2018年4月21日
 */
public class ReportData extends BasePojo {
    /** */
    private static final long serialVersionUID = 8534860347356802941L;

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

    /** 格式化显示*/
    private String format;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue == null ? null : defaultValue.trim();
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format == null ? null : format.trim();
    }
}