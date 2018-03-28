package cn.loverqi.star.core.mybaties.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 属性隐藏自定义注解
 * @author loverqi
 * @date 2018年1月16日
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldIgnore {

}
