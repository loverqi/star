package cn.loverqi.star.core.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 此类可以取得Spring的上下文.
 * Spring 使new方法创建的对象可以引用spring管理的bean.
 * @author LoverQi
 * @date 2018年4月5日
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

    protected static ApplicationContext context;

    /*
     * 设置ApplicationContext
     * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
     */
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    /**
     * 获取ApplicationContext的方法
     * @return ApplicationContext
     */
    public static ApplicationContext getContext() {
        return context;
    }

    /**
     * 根据类型获取Bean
     * @param t 想要获取的类型
     * @return 获得到的Bean
     */
    public static <T> T getBean(Class<T> clazz) {
        return (T) context.getBean(clazz);
    }

    /**
     * 根据名字获取Bean
     * @param beanName 想要获取的名字
     * @return 获得到的Bean
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanName, Class<T> clazz) {
        return (T) context.getBean(beanName);
    }

}
