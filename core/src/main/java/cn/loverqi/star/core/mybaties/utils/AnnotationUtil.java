package cn.loverqi.star.core.mybaties.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 对于自定义注解使用的工具类
 * @author loverqi
 * @date 2018年1月16日
 */
public class AnnotationUtil {

    /**
     * 根据字段名获取到字段上指定的注解的方法
     */
    public static <T extends Annotation> T getAnnotation(Field field, Class<T> annotationClass) {
        T t = null;
        boolean annotationPresent = field.isAnnotationPresent(annotationClass);

        if (annotationPresent) {
            t = field.getAnnotation(annotationClass);
        }

        return t;
    }

    /**
     * 根据字段名获取到方法上指定的注解的方法
     */
    public static <T extends Annotation> T getAnnotation(Method method, Class<T> annotationClass) {
        T t = null;
        boolean annotationPresent = method.isAnnotationPresent(annotationClass);

        if (annotationPresent) {
            t = method.getAnnotation(annotationClass);
        }

        return t;
    }

    /**
     * 根据字段名获取到类上指定的注解的方法
     */
    public static <T extends Annotation> T getAnnotation(Class<?> clazz, Class<T> annotationClass) {
        T t = null;
        boolean annotationPresent = clazz.isAnnotationPresent(annotationClass);

        if (annotationPresent) {
            t = clazz.getAnnotation(annotationClass);
        }

        return t;
    }

}
