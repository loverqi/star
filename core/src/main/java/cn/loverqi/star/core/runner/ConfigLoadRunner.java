package cn.loverqi.star.core.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 系统启动时从数据库加载配置文件
 * @author LoverQi
 * @date 2018年5月4日
 */
@Order(1)
@Component
public class ConfigLoadRunner implements CommandLineRunner {

    /*
     * 启动时执行，从数据库加载文件
     * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
     */
    @Override
    public void run(String... args) throws Exception {
        System.err.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作<<<<<<<<<<<<<");
    }

}
