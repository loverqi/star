package cn.loverqi.star.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 使用poi导出的时候，用于指定excel文件的标题名
 * @author LoverQi
 * @date 2018年4月8日
 */
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcelName {
    /**
     * @return  文件的标题名
     */
    public String value() default "";

}
