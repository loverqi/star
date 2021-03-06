package cn.loverqi.star.core.basepojo;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.formula.functions.T;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cn.loverqi.star.core.annotation.FieldIgnore;
import cn.loverqi.star.core.annotation.TableId;
import cn.loverqi.star.core.annotation.TableName;
import cn.loverqi.star.core.annotation.TimeNow;
import cn.loverqi.star.core.exception.PojoStructureException;
import cn.loverqi.star.core.mybaties.utils.AnnotationUtil;
import cn.loverqi.star.core.utils.NameFormatConversionUtil;

/**
 * MyBatis通用的POJO基类
 * @author loverqi
 * @date 2018年1月9日
 */
/**
 * 
 * @author LoverQi
 * @date 2018年6月9日
 */
/**
 * 
 * @author LoverQi
 * @date 2018年8月9日
 */
public abstract class BasePojo implements Serializable, Cloneable {

    private static final long serialVersionUID = 7017005956368469919L;

    @FieldIgnore
    private Set<String> nowTimeDate = new HashSet<>(2);

    /**
     * 获取POJO对应的表名，要求数据库中的表名必须和类名对应
     * 优先读取@Table注解
     * @return 根据类名得到的表名
     */
    @JsonIgnore
    public String getTablename() {
        String simpleName = null;
        TableName annotation = AnnotationUtil.getAnnotation(getClass(), TableName.class);
        if (annotation != null) {
            simpleName = NameFormatConversionUtil.humpToLine(annotation.value());
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

        if (isSetNowTime(fieldName)) {
            this.setFieldValueByKey(fieldName, new Date());
        }

        String fieldValue = null;
        try {
            Class<? extends BasePojo> clazz = getClass();
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
     * 根据字段名获取字段的值
     * @return 字段的值
     */
    @JsonIgnore
    public T getTableFieldValue(String fieldName, Class<T> clszz) {
        T fieldValue = null;
        try {
            Class<? extends BasePojo> clazz = getClass();
            Field fieldId = clazz.getDeclaredField(fieldName);
            if (fieldId != null) {
                PropertyDescriptor pd = new PropertyDescriptor(fieldId.getName(), clazz);
                Method method = pd.getReadMethod();//获得读方法  

                Object invoke = method.invoke(this);

                fieldValue = (T) invoke;
            }
        } catch (Exception e) {
            throw new PojoStructureException("字段不存在", e);
        }

        return fieldValue;
    }

    /**
     * 根据字段名获取字段的类型
     * @return 字段的值
     */
    @JsonIgnore
    public String getTableFieldClass(String fieldName) {
        String clazzStr = null;
        fieldName = NameFormatConversionUtil.lineToHump(fieldName);
        try {
            Class<? extends BasePojo> clazz = getClass();
            Field fieldId = clazz.getDeclaredField(fieldName);
            if (fieldId != null) {
                String type = fieldId.getType().getName();
                String[] split = type.split("\\.");

                clazzStr = split[split.length - 1].toLowerCase();
            }
        } catch (Exception e) {
            throw new PojoStructureException("字段不存在", e);
        }

        return clazzStr;
    }

    /**
     * 根据属性字段名自动赋值的方法
     * @param fieldName 属性名
     * @param fieldValue 属性值
     * @return 方法执行的成功与否    
     */
    @JsonIgnore
    public boolean setFieldValueByKey(String fieldName, Object fieldValue) {
        if (fieldName == null) {
            return false;
        }

        try {
            Class<? extends BasePojo> clazz = getClass();

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

    /**
     * 判断当前字段是否需要填充当前时间
     * @return
     */
    @JsonIgnore
    private boolean isSetNowTime(String fieldName) {

        //判断是否添加了注解
        try {
            Field field = getClass().getDeclaredField(fieldName);
            TimeNow timeNow = AnnotationUtil.getAnnotation(field, TimeNow.class);
            if (timeNow != null) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @JsonIgnore
    public void setNowTime(String fieldName) {
        this.setFieldValueByKey(NameFormatConversionUtil.lineToHump(fieldName), new Date());
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

    @Override
    public BasePojo clone() {
        BasePojo obj = null;
        try {
            obj = (BasePojo) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * 复制并根据map赋值
     * @param map
     * @return
     */
    public BasePojo clone(Map<String, Object> map) {
        BasePojo obj = this.clone();
        for (String key : map.keySet()) {
            obj.setFieldValueByKey(NameFormatConversionUtil.lineToHump(key), map.get(key));
        }

        return obj;
    }

}
