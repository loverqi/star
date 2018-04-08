package cn.loverqi.star.domain;

import cn.loverqi.star.core.annotation.ExcelColumn;

/**
 * 
 * @author LoverQi
 * @date 2018年4月8日
 */
public class RefPartExcel {

    @ExcelColumn("原零件号")
    private String partNo;

    @ExcelColumn("原零件名称")
    private String partName;

    @ExcelColumn("参考零件号")
    private String refPartNo;

    @ExcelColumn("参考零件名称")
    private String refPartName;;

    @ExcelColumn("长")
    private String length;

    @ExcelColumn("宽")
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
