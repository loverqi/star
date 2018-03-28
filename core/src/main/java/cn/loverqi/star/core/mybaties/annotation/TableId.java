package cn.loverqi.star.core.mybaties.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TableId {

    /**
     * 获取表名的主键，默认是id
     */
    public String idName() default "id";
}
