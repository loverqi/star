package cn.loverqi.star.core.basepojo;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cn.loverqi.star.core.annotation.ExcelColumn;
import cn.loverqi.star.core.annotation.ExcelName;
import cn.loverqi.star.core.bean.ExcelColumnMapping;
import cn.loverqi.star.core.mybaties.exception.PojoStructureException;
import cn.loverqi.star.core.mybaties.utils.AnnotationUtil;
import cn.loverqi.star.core.mybaties.utils.NameFormatConversionUtil;
import cn.loverqi.star.core.utils.ConstantUtil;
import cn.loverqi.star.core.utils.DateUtil;

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
    public List<ExcelColumnMapping> getExcelFieldsList() {
        List<ExcelColumnMapping> list = new ArrayList<ExcelColumnMapping>();
        Field[] declaredField = getClass().getDeclaredFields();
        for (Field field : declaredField) {
            ExcelColumn annotation = AnnotationUtil.getAnnotation(field, ExcelColumn.class);
            //根据注解判断当前字段是否需要隐藏
            if (annotation != null && !Modifier.isStatic(field.getModifiers())) {
                list.add(new ExcelColumnMapping(annotation.value(), field.getName(), annotation.order(),
                        annotation.width(), field.getType()));
            }
        }

        //对字段进行排序
        Collections.sort(list);

        return list;
    }

    @JsonIgnore
    public Map<String, ExcelColumnMapping> getExcelFieldsMap() {
        Map<String, ExcelColumnMapping> map = new HashMap<String, ExcelColumnMapping>();
        Field[] declaredField = getClass().getDeclaredFields();
        for (Field field : declaredField) {
            ExcelColumn annotation = AnnotationUtil.getAnnotation(field, ExcelColumn.class);
            //根据注解判断当前字段是否需要隐藏
            if (annotation != null && !Modifier.isStatic(field.getModifiers())) {
                map.put(annotation.value(), new ExcelColumnMapping(annotation.value(), field.getName(),
                        annotation.order(), annotation.width(), field.getType()));
            }
        }

        return map;
    }

    /**
     * 获取POJO对应的excel表格名
     * 优先读取@Table注解
     * @return 根据类名得到的表名
     */
    @JsonIgnore
    public String getExcelName() {
        String simpleName = null;
        ExcelName annotation = AnnotationUtil.getAnnotation(getClass(), ExcelName.class);
        if (annotation != null) {
            simpleName = NameFormatConversionUtil.humpToLine(annotation.value());
        }

        return simpleName;
    }

    /**
     * 根据字段名获取字段的值
     * @return 字段的值
     */
    @JsonIgnore
    public String getExcelFieldValue(String fieldName) {
        String fieldValue = null;
        try {
            Class<? extends BasePojo> clazz = getClass();
            Field fieldId = clazz.getDeclaredField(fieldName);
            if (fieldId != null) {
                PropertyDescriptor pd = new PropertyDescriptor(fieldId.getName(), clazz);
                Method method = pd.getReadMethod();//获得读方法  

                Object invoke = method.invoke(this);

                if (invoke == null) {
                    fieldValue = "";
                } else if (fieldId.getType().equals(Date.class)) {
                    fieldValue = DateUtil.format((Date) invoke, ConstantUtil.DATE_FMT_SECOND);
                } else if (fieldId.getType().equals(Double.class)) {
                    fieldValue = String.format("%.2f", invoke);
                } else {
                    fieldValue = invoke.toString();
                }
            }
        } catch (Exception e) {
            throw new PojoStructureException("字段不存在", e);
        }

        return fieldValue;
    }

}
