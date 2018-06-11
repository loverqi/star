package cn.loverqi.star.core.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.loverqi.star.core.domain.StarSysReportQuery;

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
                    String string = NameFormatConversionUtil.humpToLine(group.substring(2, group.length() - 1));
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

    /**
     * 根据个数将集合拆分为多个集合的方法
     * @param reportDatas 报表查询集合
     * @param count 拆分阈值
     */
    public static <T> List<List<T>> splitReportDatas(List<T> reportDatas, int countSize) {
        List<List<T>> lists = null;
        if (CollectionUtil.isNotNull(reportDatas)) {
            lists = new ArrayList<List<T>>();
            if (CollectionUtil.isNotNull(reportDatas)) {
                int size = reportDatas.size();
                int count = (int) Math.ceil(((double) size) / countSize);
                for (int i = 0; i < count; i++) {
                    int start = i * countSize;
                    int end = start + countSize;
                    lists.add(reportDatas.subList(start, end > size ? size : end));
                }
            }
        }

        return lists;
    }

    /**
     * 根据查询集合获取查询条件map
     * @param reportDatas 报表查询集合
     */
    public static Map<String, String> getQueryMap(List<StarSysReportQuery> reportDatas) {
        Map<String, String> map = new HashMap<>();
        for (StarSysReportQuery query : reportDatas) {
            String name = query.getName();
            String condition = query.getCondition();

            if (StringUtil.isNotNull(name) && StringUtil.isNotNull(condition)) {
                map.put(name.trim(), condition.trim());
            }
        }

        return map;
    }
    /**
     * 根据查询集合获取查询条件map
     * @param reportDatas 报表查询集合
     */
    public static Map<String, String> getQueryType(List<StarSysReportQuery> reportDatas) {
        Map<String, String> map = new HashMap<>();
        for (StarSysReportQuery query : reportDatas) {
            String name = query.getName();
            String condition = query.getClassType();
            
            if (StringUtil.isNotNull(name) && StringUtil.isNotNull(condition)) {
                map.put(name.trim(), condition.trim());
            }
        }
        
        return map;
    }

    /**
     * 根据参数和类型整理数据类型的方法
     * @param condition
     * @param fieldClass
     * @return
     */
    public static Object getTypeValue(Object value, String condition, String fieldClass) {
        Object obj = null;

        if (condition.equals("in")) {
            List<Object> list = new ArrayList<Object>();
            if (value.getClass().isArray()) {
                String[] valueArr = (String[]) value;
                for (String string : valueArr) {
                    list.add(getTheTypeValue(string, condition, fieldClass));
                }
            } else {
                list.add(getTheTypeValue(value, condition, fieldClass));
            }
            obj = list;
        } else {
            obj = getTheTypeValue(value, condition, fieldClass);
        }

        return obj;
    }

    /**
     * 根据参数和类型整理数据类型的方法
     * @param condition
     * @param fieldClass
     * @return
     */
    private static Object getTheTypeValue(Object value, String condition, String fieldClass) {
        Object obj = null;
        switch (fieldClass) {
        case "short":
        case "int":
        case "integer":
            obj = Integer.parseInt(value.toString());
            break;

        case "float":
        case "double":
            //双精度
            obj = Double.parseDouble(value.toString());
            break;

        case "boolean":
            //布尔型
            obj = Boolean.parseBoolean(value.toString());
            break;

        default:
            obj = value.toString();
            break;
        }

        return obj;
    }

}
