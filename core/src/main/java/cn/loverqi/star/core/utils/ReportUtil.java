package cn.loverqi.star.core.utils;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 报表相关的工具类
 * @author LoverQi
 * @date 2018年6月4日
 */
public class ReportUtil {

    /**
     * 根据参数填充方法参数
     * @param func 需要填充的方法名
     * @param values 数据键值对
     * @return
     */
    public static String fillFuncField(String func, Map<String, Object> values) {
        if (func != null) {
            Pattern pattern = Pattern.compile("\\$\\{(?:(?!,).)*\\}");
            Matcher matcher = null;
            while (true) {
                matcher = pattern.matcher(func);
                if (matcher.find()) {
                    String group = matcher.group();
                    String string = group.substring(2, group.length() - 1);
                    String value = null;
                    Object obj = values.get(string);
                    if (obj != null) {
                        if (obj instanceof String) {
                            value = "'" + obj.toString() + "'";
                        } else {
                            value = obj.toString();
                        }
                    } else {
                        value = "null";
                    }

                    func = matcher.replaceFirst(value);
                } else {
                    break;
                }
            }
        }

        return func;
    }

}
