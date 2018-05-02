package cn.loverqi.star.core.utils;

/**
 * 常量工具类
 * @author LoverQi
 * @date 2018年5月3日
 */
public class ConstantUtil {
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


    /**
     * 基本的常用符号
     */
    //逗号
    public static final String SYMBOL_COMMA = ",";
    //分号
    public static final String SYMBOL_SEMICOLON = ";";
    //井号
    public static final String SYMBOL_NUMBER_SIGN = "#";
    //斜杠
    public static final String SYMBOL_SLASH = "/";
    //连接号
    public static final String SYMBOL_HYPHEN = "-";
    //下划线
    public static final String SYMBOL_UNDERLINE = "_";
    //加号
    public static final String SYMBOL_PLUS = "+";
    //冒号
    public static final String SYMBOL_COLON = ":";
    //百分号
    public static final String SYMBOL_PERCENT = "%";


    //制表符
    public static final String SYMBOL_TAB = "\t";
    //换行
    public static final String SYMBOL_NEWLINE = "\n";
    //回车
    public static final String SYMBOL_CARRIAGE_RETURN = "\r";
    //回车换行
    public static final String SYMBOL_ENTER = "\r\n";

    /**
     * 常用字符
     */
    //空
    public static final String STRING_EMPTY = "";
    //空格
    public static final String STRING_SPACE = " ";


    /**
     * 基本数字
     */
    public static final int NUMBER_ZERO = 0;
    public static final int NUMBER_ONE = 1;
    public static final int NUMBER_TWO = 2;
    public static final int NUMBER_THREE = 3;
    public static final int NUMBER_FOUR = 4;
    public static final int NUMBER_FIVE = 5;
    public static final int NUMBER_SIX = 6;
    public static final int NUMBER_SEVEN = 7;
    public static final int NUMBER_EIGHT = 8;
    public static final int NUMBER_NINE = 9;

    /**
     * 字符串数字
     */
    public static final String STRING_ZERO = "0";
    public static final String STRING_ONE = "1";
    public static final String STRING_TWO = "2";
    public static final String STRING_THREE = "3";
    public static final String STRING_FOUR = "4";
    public static final String STRING_FIVE = "5";
    public static final String STRING_SIX = "6";
    public static final String STRING_SEVEN = "7";
    public static final String STRING_EIGHT = "8";
    public static final String STRING_NINE = "9";
    public static final String STRING_ZERO_ZERO = "00";
    public static final String STRING_ZERO_ONE = "01";
    public static final String STRING_ZERO_TWO = "02";
    public static final String STRING_ZERO_THREE = "03";
    public static final String STRING_ZERO_FOUR = "04";
    public static final String STRING_ZERO_FIVE = "05";
    public static final String STRING_ZERO_SIX = "06";
    public static final String STRING_ZERO_SEVEN = "07";
    public static final String STRING_ZERO_EIGHT = "08";
    public static final String STRING_ZERO_NINE = "09";

    /**
     * 字符編碼
     */
    public static final String CHAR_ENCODE_UTF_8 = "UTF-8";

    private ConstantUtil() throws ClassNotFoundException {
        throw new ClassNotFoundException();
    }
}
