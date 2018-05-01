package cn.loverqi.star.core;

/**
 * 系统配置类
 * 该类会在系统启动时启动，切为静态类，只有接到刷新命令时才会刷新
 * @author LoverQi
 * @date 2018年5月1日
 */
public class SystemConfiguration {

    // 是否开启用户密码定期更新
    private static boolean passwordUpdateEnable;
    // 是否开启用户密码定期日数
    private static int passwordUpdateDays;

    static {
        passwordUpdateEnable = true;
        passwordUpdateDays = 30;
    }

    public static boolean isPasswordUpdateEnable() {
        return passwordUpdateEnable;
    }

    public static void setPasswordUpdateEnable(boolean passwordUpdateEnable) {
        SystemConfiguration.passwordUpdateEnable = passwordUpdateEnable;
    }

    public static int getPasswordUpdateDays() {
        return passwordUpdateDays;
    }

    public static void setPasswordUpdateDays(int passwordUpdateDays) {
        SystemConfiguration.passwordUpdateDays = passwordUpdateDays;
    }

}
