package cn.loverqi.star.core.utils;

import java.util.List;

import cn.loverqi.star.core.domain.StarSysConfig;

/**
 * 系统配置类
 * 该类会在系统启动时启动，切为静态类，只有接到刷新命令时才会刷新
 * @author LoverQi
 * @date 2018年5月1日
 */
public class SystemConfiguration {

    // 系统名称
    public static String SYSTEM_NAME;

    // 密码定期更新天数, 0为不限制
    public static int PASSWORD_UPDATE_DAYS;

    // 密码长度最小, 0为不限制
    public static int PASSWORD_LENGTH_MIN;

    // 密码长度最大, 0为不限制
    public static int PASSWORD_LENGTH_MAX;

    // 密码复杂度要求, 0为不限制
    public static int PASSWORD_COMPLEXITY;

    // 密码复杂度要求正则, PASSWORD_COMPLEXITY为4时启用
    public static String PASSWORD_COMPLEXITY_VALUE;

    // 错误密码次数, 0为不限制
    public static int PASSWORD_FAILS_COUNT;

    static {
        SYSTEM_NAME = "Star 快速开发平台";
    }

    public static int setConfig(List<StarSysConfig> configs) {
        int count = 0;
        for (StarSysConfig starSysConfig : configs) {
            count += setConfig(starSysConfig);
        }

        return count;
    }

    public static int setConfig(StarSysConfig config) {
        int count = 1;
        SYSTEM_NAME = "Star 快速开发平台";

        if (config.getEnable()) {
            if ("SYSTEM_NAME".equals(config.getName().trim())) {
                SYSTEM_NAME = config.getValue();
            } else if ("PASSWORD_UPDATE_DAYS".equals(config.getName().trim())) {
                PASSWORD_UPDATE_DAYS = Integer.parseInt(config.getValue());
            } else if ("PASSWORD_LENGTH_MIN".equals(config.getName().trim())) {
                PASSWORD_LENGTH_MIN = Integer.parseInt(config.getValue());
            } else if ("PASSWORD_LENGTH_MAX".equals(config.getName().trim())) {
                PASSWORD_LENGTH_MAX = Integer.parseInt(config.getValue());
            } else if ("PASSWORD_COMPLEXITY".equals(config.getName().trim())) {
                PASSWORD_COMPLEXITY = Integer.parseInt(config.getValue());
            } else if ("PASSWORD_COMPLEXITY_VALUE".equals(config.getName().trim())) {
                PASSWORD_COMPLEXITY_VALUE = config.getValue();
            } else if ("PASSWORD_FAILS_COUNT".equals(config.getName().trim())) {
                PASSWORD_FAILS_COUNT = Integer.parseInt(config.getValue());
            } else {
                count--;
            }
        }

        return count;

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
        case 4: //其他
            if (StringUtil.isNotNull(PASSWORD_COMPLEXITY_VALUE)) {
                passwordComplexityValue = PASSWORD_COMPLEXITY_VALUE;
            }

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
