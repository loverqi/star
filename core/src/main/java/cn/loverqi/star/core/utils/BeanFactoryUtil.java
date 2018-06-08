package cn.loverqi.star.core.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 
 * @author LoverQi
 * @date 2018年5月3日
 */
@Component
public class BeanFactoryUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    private BeanFactoryUtil() {
    }

    /**
     * 获取ApplicationContext的方法
     * @return ApplicationContext
     */
    public static ApplicationContext getContext() {
        return applicationContext;
    }

    /**
     * 根据类型获取Bean
     * @param t 想要获取的类型
     * @return 获得到的Bean
     */
    public static <T> T getBean(Class<T> clazz) {
        T bean = null;
        if (applicationContext != null) {
            bean = applicationContext.getBean(clazz);
        }

        return bean;
    }

    /**
     * 根据名字获取Bean
     * @param beanName 想要获取的名字
     * @return 获得到的Bean
     */
    public static Object getBean(String name) {
        Object bean = null;
        if (applicationContext != null) {
            bean = applicationContext.getBean(name);
        }

        return bean;
    }

    /*
     * 注入spring的applicationContext对象
     * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BeanFactoryUtil.applicationContext = applicationContext;
    }

}
