package cn.loverqi.star.core.mybaties.pojo;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cn.loverqi.star.core.mybaties.annotation.FieldIgnore;
import cn.loverqi.star.core.mybaties.annotation.Table;
import cn.loverqi.star.core.mybaties.annotation.TableId;
import cn.loverqi.star.core.mybaties.exception.PojoStructureException;
import cn.loverqi.star.core.mybaties.utils.AnnotationUtil;
import cn.loverqi.star.core.mybaties.utils.NameFormatConversionUtil;

/**
 * MyBatis通用的POJO基类
 * @author loverqi
 * @date 2018年1月9日
 */
public abstract class MyBatisPojo implements Serializable {

    private static final long serialVersionUID = 7017005956368469919L;

    /**
     * 获取POJO对应的表名，要求数据库中的表名必须和类名对应
     * 优先读取@Table注解
     * @return 根据类名得到的表名
     */
    @JsonIgnore
    public String getTablename() {
        String simpleName = null;
        Table annotation = AnnotationUtil.getAnnotation(getClass(), Table.class);
        if (annotation != null) {
            simpleName = NameFormatConversionUtil.humpToLine(annotation.tableName());
        } else {
            simpleName = getClass().getSimpleName();
        }

        return NameFormatConversionUtil.humpToLine(simpleName);
    }

    /**
     * 或许类的所有非静态属性
     * 排除@FieldIgnore注解, 添加mysql中的关键字转义字符
     * @return 类的所有非静态属性，返回用“,”分割形式的字符换
     */
    @JsonIgnore
    public String getEscapeTableFields() {
        StringBuffer sb = new StringBuffer();
        Field[] declaredField = getClass().getDeclaredFields();
        for (Field field : declaredField) {
            FieldIgnore annotation = AnnotationUtil.getAnnotation(field, FieldIgnore.class);
            //根据注解判断当前字段是否需要隐藏
            if (annotation == null && !Modifier.isStatic(field.getModifiers())) {
                sb.append("`" + NameFormatConversionUtil.humpToLine(field.getName()) + "`" + ",");
            }
        }

        //删除最后一个“,”
        int i = sb.lastIndexOf(",");
        if (i > -1) {
            sb.delete(i, i + 1);
        }

        return sb.toString();
    }

    /**
     * 或许类的所有非静态属性,包括主键
     * 排除@FieldIgnore注解
     * @return 类的所有非静态属性，返回一个list列表
     */
    @JsonIgnore
    public List<String> getTableFieldsList() {
        List<String> list = new ArrayList<String>();
        Field[] declaredField = getClass().getDeclaredFields();
        for (Field field : declaredField) {
            FieldIgnore annotation = AnnotationUtil.getAnnotation(field, FieldIgnore.class);
            //根据注解判断当前字段是否需要隐藏
            if (annotation == null && !Modifier.isStatic(field.getModifiers())) {
                list.add(field.getName());
            }
        }

        return list;
    }

    /**
     * 或许类的所有非静态属性,不包括主键
     * 排除@FieldIgnore注解
     * @return 类的所有非静态属性，返回一个list列表
     */
    @JsonIgnore
    public List<String> getTableOrdinaryFieldsList() {
        List<String> list = new ArrayList<String>();
        Field[] declaredField = getClass().getDeclaredFields();
        for (Field field : declaredField) {
            FieldIgnore annotation = AnnotationUtil.getAnnotation(field, FieldIgnore.class);
            if (annotation == null && !Modifier.isStatic(field.getModifiers())) {
                list.add(field.getName());
            }
        }

        //去除主键
        list.remove(getTablePrimaryKey());

        return list;
    }

    /**
     * 获取POJO中的主键字段名, 默认读取@TableId
     * @return 主键的名称
     */
    @JsonIgnore
    public String getTablePrimaryKey() {
        String idName = null;

        TableId annotation = AnnotationUtil.getAnnotation(getClass(), TableId.class);

        if (annotation != null) {
            idName = NameFormatConversionUtil.humpToLine(annotation.idName());
        } else {

            try {
                Field fieldId = getClass().getDeclaredField("id");
                if (fieldId != null) {
                    idName = NameFormatConversionUtil.humpToLine(fieldId.getName());
                }
            } catch (Exception e) {
                throw new PojoStructureException("主键不存在", e);
            }
            if (idName == null || "".equals(idName)) {
                throw new PojoStructureException("主键不存在");
            }
        }

        return idName != null && "".equals(idName) ? null : idName;
    }

    /**
     * 获取POJO中的主键字段的值
     * @return 主键的值
     */
    @JsonIgnore
    public String getTablePrimaryKeyValue() {

        String idValue = getTableFieldValue(getTablePrimaryKey());

        return idValue;
    }

    /**
     * 根据字段名获取字段的值
     * @return 字段的值
     */
    @JsonIgnore
    public String getTableFieldValue(String fieldName) {

        String fieldValue = null;
        try {
            Class<? extends MyBatisPojo> clazz = getClass();
            Field fieldId = clazz.getDeclaredField(fieldName);
            if (fieldId != null) {
                PropertyDescriptor pd = new PropertyDescriptor(fieldId.getName(), clazz);
                Method method = pd.getReadMethod();//获得读方法  

                Object invoke = method.invoke(this);

                fieldValue = invoke == null ? null : invoke.toString();
            }
        } catch (Exception e) {
            throw new PojoStructureException("字段不存在", e);
        }

        return fieldValue != null && "".equals(fieldValue) ? null : fieldValue;
    }

    /**
     * 根据属性字段名自动赋值的方法
     * @param fieldName 属性名
     * @param fieldValue 属性值
     * @return 方法执行的成功与否    
     */
    public boolean setFieldValueByKey(String fieldName, Object fieldValue) {
        if (fieldName == null) {
            return false;
        }

        try {
            Class<? extends MyBatisPojo> clazz = getClass();

            Field field = clazz.getDeclaredField(fieldName);
            if (field != null) {
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
                Method method = pd.getWriteMethod();//获得读方法  

                method.invoke(this, fieldValue);
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    /**
     * 在使用自动生成主键的时候的回调方法
     * @param keyProperty 注入进来的主键值
     */
    @JsonIgnore
    public void setKeyProperty(Integer keyProperty) {
        this.setFieldValueByKey(getTablePrimaryKey(), keyProperty);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
