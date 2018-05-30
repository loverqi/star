package cn.loverqi.star.core.utils;

/**
 * 常量工具类
 * @author LoverQi
 * @date 2018年5月3日
 */
public class ConstantUtil {
    
    //验证码的key
    public static final String KAPTCHA_SESSION_KEY = "STAR_KAPTCHA_SESSION_KEY";
    
    /**
     * 时间格式
     */
    //默认时间格式-精确到分
    public static final String DATE_FMT_DEFAULT = "yyyy-MM-dd HH:mm";
    //时间格式-精确到天
    public static final String DATE_FMT_DAY = "yyyy-MM-dd";
    //时间格式-精确到秒
    public static final String DATE_FMT_SECOND = "yyyy-MM-dd HH:mm:ss";
    //时间格式-精确到毫秒
    public static final String DATE_FMT_MSEC = "yyyy-MM-dd HH:mm:ss SSS";
    //时间格式-精确到小时
    public static final String DATE_FMT_HOUR = "yyyyMMddHH";

    /**
     * 时间字符代表
     */
    //符号-年
    public static final String SYMBOL_DATE_YEAR = "yyyy";
    //符号-月
    public static final String SYMBOL_DATE_MONTH = "MM";
    //符号-日
    public static final String SYMBOL_DATE_DAY = "dd";
    //符号-时
    public static final String SYMBOL_DATE_HOUR = "HH";
    //符号-分
    public static final String SYMBOL_DATE_MINUTE = "mm";
    //符号-秒
    public static final String SYMBOL_DATE_SECOND = "ss";
    //符号-毫秒
    public static final String SYMBOL_DATE_MILLISECOND = "SSS";

    /**
     * 时间秒
     */
    public static final long TIME_MSEC_SECOND = 1000L;
    public static final long TIME_MSEC_MINUTE = 60000L; //1000L * 60
    public static final long TIME_MSEC_HOUR = 3600000L; //1000L * 60 * 60
    public static final long TIME_MSEC_DAY = 86400000L; //1000L * 60 * 60 * 24


    private ConstantUtil() throws ClassNotFoundException {
        throw new ClassNotFoundException();
    }
}
