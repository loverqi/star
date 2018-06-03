package cn.loverqi.star.core.utils;

import java.util.Collection;
import java.util.Map;

/**
 * 集合类工具类
 * @author LoverQi
 * @date 2018年6月3日
 */
public class CollectionUtil {

    /**
     * 判断集合是否为空
     */
    public static boolean isNull(Collection<?> collection) {
        return collection == null || collection.size() < 1;
    }

    /**
     * 判断集合是否不为空
     */
    public static boolean isNotNull(Collection<?> collection) {
        return collection != null && collection.size() > 0;
    }

    /**
     * 判断集合是否为空
     */
    public static boolean isNull(Map<?, ?> map) {
        return map == null || map.size() < 1;
    }

    /**
     * 判断集合是否不为空
     */
    public static boolean isNotNull(Map<?, ?> map) {
        return map != null && map.size() > 0;
    }

}
