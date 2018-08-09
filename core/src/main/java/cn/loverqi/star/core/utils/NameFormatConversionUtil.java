package cn.loverqi.star.core.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.thymeleaf.util.StringUtils;

/**
 * 对象字段名称格式转换工具类
 * @author loverqi
 * @date 2018年1月9日
 */
public class NameFormatConversionUtil {
    private static Pattern linePattern = Pattern.compile("_(\\w)");
    private static Pattern humpPattern = Pattern.compile("[A-Z]");

    /**
     * 下划线转驼峰
     * @param str 下划线格式的字段名
     * @return 驼峰格式的字段名
     */
    public static String lineToHump(String str) {
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);

        //如果存在就替换最后一个字符
        int i = sb.lastIndexOf("_");
        if (i > -1) {
            sb.delete(i, i + 1);
        }

        return sb.toString();
    }

    /**
     * 下划线转驼峰,首字母大写
     * @param str 下划线格式的字段名
     * @return 驼峰格式的字段名
     */
    public static String lineToHumpAndUpperCase(String str) {
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        int count = sb.indexOf("_");
        while (count != 0) {
            int num = sb.indexOf("_", count);
            count = num + 1;
            if (num != -1) {
                char ss = sb.charAt(count);
                char ia = (char) (ss - 32);
                sb.replace(count, count + 1, ia + "");
            }
        }
        String result = sb.toString().replaceAll("_", "");
        return StringUtils.capitalize(result);
    }

    /**
     * 驼峰转下划线
     * @param str 驼峰格式的字段名
     * @return 下划线格式的字段名
     */
    public static String humpToLine(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);

        //如果用“_”开头就去除下划线
        if (sb.length() > 0 && sb.charAt(0) == '_') {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }

}
