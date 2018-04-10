package cn.loverqi.star.core.basepojo;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cn.loverqi.star.core.annotation.ExcelColumn;
import cn.loverqi.star.core.annotation.ExcelName;
import cn.loverqi.star.core.bean.ExcelColumnMapping;
import cn.loverqi.star.core.mybaties.utils.AnnotationUtil;
import cn.loverqi.star.core.mybaties.utils.NameFormatConversionUtil;

/**
 * 可以导出和导入excel通用的POJO基类
 * @author loverqi
 * @date 2018年4月10日
 */
public abstract class ExcelPojo extends BasePojo {

    private static final long serialVersionUID = -4988999567010012717L;

    /**
     * 或许类的所有的excel非静态字段，并排序
     * 排除@FieldIgnore注解
     * @return 类的所有非静态属性，返回一个list列表
     */
    @JsonIgnore
    public List<ExcelColumnMapping> getTableExcelFieldsList() {
        List<ExcelColumnMapping> list = new ArrayList<ExcelColumnMapping>();
        Field[] declaredField = getClass().getDeclaredFields();
        for (Field field : declaredField) {
            ExcelColumn annotation = AnnotationUtil.getAnnotation(field, ExcelColumn.class);
            //根据注解判断当前字段是否需要隐藏
            if (annotation != null && !Modifier.isStatic(field.getModifiers())) {
                list.add(new ExcelColumnMapping(annotation.value(), field.getName(), annotation.order()));
            }
        }

        //对字段进行排序
        Collections.sort(list);

        return list;
    }

    /**
     * 获取POJO对应的excel表格名
     * 优先读取@Table注解
     * @return 根据类名得到的表名
     */
    @JsonIgnore
    public String getExcelname() {
        String simpleName = null;
        ExcelName annotation = AnnotationUtil.getAnnotation(getClass(), ExcelName.class);
        if (annotation != null) {
            simpleName = NameFormatConversionUtil.humpToLine(annotation.value());
        }

        return simpleName;
    }

}
