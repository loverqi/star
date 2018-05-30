package cn.loverqi.star.core.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    
    // 联系人邮箱
    public static String SYSTEM_EMAIL;

    // 系统导航栏logo，路径
    public static String SYSTEM_LOGO_BAR;

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

    // 是否启用系统日志
    public static boolean SYSTEM_LOG_ENABLE;
   
    // 是否启用系统日志
    public static boolean CODE_ENABLE;

    static {
        SYSTEM_NAME = "Star 快速开发平台";
        SYSTEM_EMAIL = "admin@loverqi.cn";
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
            } else if ("SYSTEM_EMAIL".equals(config.getName().trim())) {
                SYSTEM_EMAIL = config.getValue();
            } else if ("SYSTEM_LOGO_BAR".equals(config.getName().trim())) {
                SYSTEM_LOGO_BAR = config.getValue();
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
            } else if ("SYSTEM_LOG_ENABLE".equals(config.getName().trim())) {
                SYSTEM_LOG_ENABLE = Boolean.parseBoolean(config.getValue());
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

    /**
     * 以map形式回去所有的配置文件字段
     * @return
     */
    public static Map<String, Object> getConfigs() {
        Map<String, Object> map = new HashMap<String, Object>();
        Field[] fields = SystemConfiguration.class.getDeclaredFields();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())) {
                Object object = null;
                try {
                    object = field.get(null);
                } catch (Exception e) {
                }
                map.put(field.getName(), object);
            }
        }

        return map;
    }

    private SystemConfiguration() throws ClassNotFoundException {
        throw new ClassNotFoundException();
    }
}
