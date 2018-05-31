package cn.loverqi.star.core.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * jdb链接获取
 * @author LoverQi
 * @date 2018年5月31日
 */
public class ConnectionUtil {

    /**
     * 获取jdbc链接对象
     * @param jdbcUrl 链接字符串
     * @param jdbcUserName 用户名
     * @param jdbcPassWord 用户密码
     */
    public static Connection getConnection(String jdbcUrl, String jdbcUserName, String jdbcPassWord) throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", jdbcUserName);
        props.setProperty("password", jdbcPassWord);
        props.setProperty("remarks", "true"); //设置可以获取remarks信息 
        props.setProperty("useInformationSchema", "true");//设置可以获取tables remarks信息
        Connection connection = DriverManager.getConnection(jdbcUrl, props);

        return connection;
    }

}
