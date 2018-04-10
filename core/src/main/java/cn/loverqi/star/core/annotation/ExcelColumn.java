package cn.loverqi.star.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 使用poi导出的时候，用于指定excel标题的注解
 * @author LoverQi
 * @date 2018年4月8日
 */
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcelColumn {
    /**
     * @return  字段的标题
     */
    public String value() default "";

    /**
     * @return 字段的排序
     */
    public int order() default 0;
}
