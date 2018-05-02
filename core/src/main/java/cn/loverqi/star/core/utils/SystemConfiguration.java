package cn.loverqi.star.core.utils;

/**
 * 系统配置类
 * 该类会在系统启动时启动，切为静态类，只有接到刷新命令时才会刷新
 * @author LoverQi
 * @date 2018年5月1日
 */
public class SystemConfiguration {

    // 系统名称
    private static String systemName;

    // 是否开启用户密码定期日数
    private static int passwordUpdateDays;

    // 错误密码次数
    private static int pwdFailsCount;

    static {
        passwordUpdateDays = 30;
        systemName = "Star 快速开发平台";
        pwdFailsCount = 5;
    }

    public static int getPasswordUpdateDays() {
        return passwordUpdateDays;
    }

    public static void setPasswordUpdateDays(int passwordUpdateDays) {
        SystemConfiguration.passwordUpdateDays = passwordUpdateDays;
    }

    public static String getSystemName() {
        return systemName;
    }

    public static void setSystemName(String systemName) {
        SystemConfiguration.systemName = systemName;
    }

    public static int getPwdFailsCount() {
        return pwdFailsCount;
    }

    public static void setPwdFailsCount(int pwdFailsCount) {
        SystemConfiguration.pwdFailsCount = pwdFailsCount;
    }

    private SystemConfiguration() throws ClassNotFoundException {
        throw new ClassNotFoundException();
    }

}
