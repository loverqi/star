package cn.loverqi.star.core.mybaties.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据表名称注解，默认值为类名称
 * @author loverqi
 * @date 2018年1月16日
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
    /**
     * 数据表名称注解，默认值为类名称
     */
    public String tableName() default "className";
}
