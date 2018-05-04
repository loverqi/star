package cn.loverqi.star.core.utils;

/**
 * 系统配置类
 * 该类会在系统启动时启动，切为静态类，只有接到刷新命令时才会刷新
 * @author LoverQi
 * @date 2018年5月1日
 */
public class SystemConfiguration {

    // 系统名称
    public static String SYSTEM_NAME;

    // 密码定期日数, 0为不限制
    public static int PASSWORD_UPDATE_DAYS;

    // 密码长度最小, 0为不限制
    public static int PASSWORD_COUNT_MIN;

    // 密码长度最大, 0为不限制
    public static int PASSWORD_COUNT_MAX;

    // 密码复杂度要求, 0为不限制
    public static int PASSWORD_COMPLEXITY;

    // 错误密码次数, 0为不限制
    public static int PASSWORD_FAILS_COUNT;

    static {
        SYSTEM_NAME = "Star 快速开发平台";
        PASSWORD_UPDATE_DAYS = 30;
        PASSWORD_COUNT_MIN = 6;
        PASSWORD_COUNT_MAX = 15;
        PASSWORD_COMPLEXITY = 2;
        PASSWORD_FAILS_COUNT = 3;
    }

    /**
     * 获取系统的密码复杂度要求
     */
    public static String getPasswordComplexity() {
        String passwordComplexityValue = null;
        switch (PASSWORD_COMPLEXITY) {
        case 1: //简单（只包含数字或字母）
            passwordComplexityValue = "^(?:\\d+|[a-zA-Z]+|[!@#$%^&*]+)$";
            break;
        case 2: //中级（包含字母和数字）
            passwordComplexityValue = "^(?![a-zA-z]+$)(?!\\d+$)(?![!@#$%^&*]+$)[a-zA-Z\\d!@#$%^&*]+$";
            break;
        case 3: //复杂（同时包含数字，字母，特殊符号）
            passwordComplexityValue = "^^(?![a-zA-z]+$)(?!\\d+$)(?![!@#$%^&*_-]+$)(?![a-zA-z\\d]+$)(?![a-zA-z!@#$%^&*_-]+$)(?![\\d!@#$%^&*_-]+$)[a-zA-Z\\d!@#$%^&*_-]+$";
            break;
        }

        return passwordComplexityValue;
    }

    public static void setPASSWORD_COMPLEXITY(int pASSWORD_COMPLEXITY) {
        PASSWORD_COMPLEXITY = pASSWORD_COMPLEXITY;
    }

    private SystemConfiguration() throws ClassNotFoundException {
        throw new ClassNotFoundException();
    }
}
