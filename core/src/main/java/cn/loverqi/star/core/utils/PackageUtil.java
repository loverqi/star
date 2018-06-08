package cn.loverqi.star.core.utils;

import cn.loverqi.star.core.basepojo.BasePojo;

/**
 * 有关包和类的工具类
 * @author LoverQi
 * @date 2018年6月4日
 */
public class PackageUtil {

    /**
     * 根据类的完全限定名全名获取类名的方法
     * @param fullName 类的完全限定名
     * @return 类名
     */
    public static String getClassName(String fullName) {
        String className = null;
        try {
            Class<?> clazz = Class.forName(fullName);
            if (clazz != null) {
                className = clazz.getSimpleName();
            }
        } catch (ClassNotFoundException e) {
        }

        return className;
    }

    /**
     * 根据类的完全限定名全名获取类类型的方法
     * @param fullName 类的完全限定名
     * @return 类的类型
     */
    public static Class<?> getClassType(String fullName) {
        Class<?> clazz = null;
        try {
            clazz = Class.forName(fullName);
        } catch (ClassNotFoundException e) {
        }

        return clazz;
    }

    /**
     * 根据类的类型获取类对象的方法
     * @param clazz 类的类型
     * @return 类对象
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    public static <T> T getClassBean(Class<T> clazz) {
        T newInstance = null;
        try {
            newInstance = clazz.newInstance();
        } catch (Exception e) {
        }

        return newInstance;
    }

    /**
     * 根据类的类型获取类对象的方法
     * @param fullName 类的完全限定名
     * @return 类对象
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    public static BasePojo getClassBean(String fullName) {
        BasePojo newInstance = null;
        try {
            Class<?> clazz = Class.forName(fullName);
            newInstance = (BasePojo) clazz.newInstance();
        } catch (Exception e) {
        }

        return newInstance;
    }
}
