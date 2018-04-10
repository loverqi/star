package cn.loverqi.star.domain;

import cn.loverqi.star.core.annotation.ExcelColumn;
import cn.loverqi.star.core.basepojo.ExcelPojo;

/**
 * 测试的账户
 * @author LoverQi
 * @date 2018年4月8日
 */
public class RefPartExcel extends ExcelPojo {

    private static final long serialVersionUID = -7269708280850428947L;

    @ExcelColumn(value = "原零件号", order = 1)
    private String partNo;

    @ExcelColumn(value = "原零件名称", order = 1)
    private String partName;

    @ExcelColumn(value = "参考零件号", order = 1)
    private String refPartNo;

    @ExcelColumn(value = "参考零件名称", order = 1)
    private String refPartName;;

    @ExcelColumn(value = "长", order = 1)
    private String length;

    @ExcelColumn(value = "宽", order = 1)
    private String width;

    public String getPartNo() {
        return partNo;
    }

    public void setPartNo(String partNo) {
        this.partNo = partNo;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getRefPartNo() {
        return refPartNo;
    }

    public void setRefPartNo(String refPartNo) {
        this.refPartNo = refPartNo;
    }

    public String getRefPartName() {
        return refPartName;
    }

    public void setRefPartName(String refPartName) {
        this.refPartName = refPartName;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

}
