package cn.loverqi.star.core.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 解析url字符串的工具类
 * @author loverqi
 * @date 2018年2月10日
 */
public class URLUtil {
    /**
     * 解析出url请求的路径，包括页面
     * @param strURL url地址
     * @return url路径
     */
    public static String urlPage(String strURL) {
        String strPage = null;
        String[] arrSplit = null;

        strURL = strURL.trim().toLowerCase();

        arrSplit = strURL.split("[?]");
        if (strURL.length() > 0) {
            if (arrSplit.length > 1) {
                if (arrSplit[0] != null) {
                    strPage = arrSplit[0];
                }
            }
        }

        return strPage;
    }

    /**
     * 解析出url参数中的键值对
     * 如 "index.jsp?Action=del&id=123"，解析出Action:del,id:123存入map中
     * @param URL  url地址
     * @return  url请求参数部分
     */
    public static Map<String, String> urlRequest(String URL) {
        Map<String, String> mapRequest = new HashMap<String, String>();

        String[] arrSplit = null;

        String strUrlParam = truncateUrlPage(URL);
        if (strUrlParam == null) {
            return mapRequest;
        }
        //每个键值为一组
        arrSplit = strUrlParam.split("[&]");
        for (String strSplit : arrSplit) {
            String[] arrSplitEqual = null;
            arrSplitEqual = strSplit.split("[=]");

            //解析出键值
            if (arrSplitEqual.length > 1) {
                //正确解析
                mapRequest.put(arrSplitEqual[0], arrSplitEqual[1]);

            } else {
                if (arrSplitEqual[0] != "") {
                    //只有参数没有值，不加入
                    mapRequest.put(arrSplitEqual[0], "");
                }
            }
        }
        return mapRequest;
    }

    /** urlEncode编码的方法
     * @param str 需要编码码的字符串
     * @return
     */
    public static String urlEncode(String str) {
        return URLUtil.urlEncode(str, "utf-8", 1);
    }

    /** urlEncode编码的方法
     * @param str 需要编码码的字符串
     * @param count 进行几次循环编码
     * @return
     */
    public static String urlEncode(String str, int count) {
        return URLUtil.urlEncode(str, "utf-8", count);
    }

    /** urlEncode编码的方法
     * @param str 需要编码码的字符串
     * @param enc 编码方式
     * @param count 进行几次循环编码
     * @return
     */
    public static String urlEncode(String str, String enc, int count) {
        try {
            if (count > 1) {
                str = URLUtil.urlEncode(str, "utf-8", --count);
            }
            str = URLEncoder.encode(str, "utf-8");

        } catch (UnsupportedEncodingException e) {
        }

        return str;
    }

    /** urlDecoder解码的方法
     * @param str 需要解码的字符串
     * @return
     */
    public static String urlDecoder(String str) {
        return URLUtil.urlDecoder(str, "utf-8", 1);
    }

    /** urlDecoder解码的方法
     * @param str 需要解码的字符串
     * @param count 进行几次循环解码
     * @return
     */
    public static String urlDecoder(String str, int count) {
        return URLUtil.urlDecoder(str, "utf-8", count);
    }

    /** urlDecoder解码的方法
     * @param str 需要解码的字符串
     * @param enc 编码方式
     * @param count 进行几次循环解码
     * @return
     */
    public static String urlDecoder(String str, String enc, int count) {
        try {
            if (count > 1) {
                str = URLUtil.urlDecoder(str, "utf-8", --count);
            }
            str = URLDecoder.decode(str, "utf-8");

        } catch (UnsupportedEncodingException e) {
        }

        return str;
    }

    /** 
     * 向url链接追加参数(单个) 
     * @param url 
     * @param name String 
     * @param value String 
     * @return 
     */
    public static String appendParam(String url, String name, String value) {
        if (StringUtil.isNull(url)) {
            return "";
        } else if (StringUtil.isNull(name)) {
            return url.trim();
        } else {
            Map<String, String> params = new HashMap<String, String>();
            params.put(name, value);
            return URLUtil.appendParams(url, params);
        }
    }

    /** 
     * 向url链接追加参数 
     * @param url 
     * @param params Map<String, String> 
     * @return 
     */
    public static String appendParams(String url, Map<String, String> params) {
        if (StringUtil.isNull(url)) {
            return "";
        } else if (params == null || params.isEmpty()) {
            return url.trim();
        } else {
            StringBuffer sb = new StringBuffer("");
            Set<String> keys = params.keySet();
            for (String key : keys) {
                sb.append(key).append("=").append(params.get(key).replace("\n", "").replace("\r", "").trim())
                        .append("&");
            }
            sb.deleteCharAt(sb.length() - 1);

            url = url.trim();
            int length = url.length();
            int index = url.indexOf("?");
            if (index > -1) {//url说明有问号  
                if ((length - 1) == index) {//url最后一个符号为？，如：http://wwww.baidu.com?  
                    url += sb.toString();
                } else {//情况为：http://wwww.baidu.com?aa=11  
                    url += "&" + sb.toString();
                }
            } else {//url后面没有问号，如：http://wwww.baidu.com  
                url += "?" + sb.toString();
            }

            return url;
        }
    }

    /**
     * 去掉url中的路径，留下请求参数部分
     * @param strURL url地址
     * @return url请求参数部分
     */
    private static String truncateUrlPage(String strURL) {
        String strAllParam = null;
        String[] arrSplit = null;

        strURL = strURL.trim().toLowerCase();

        arrSplit = strURL.split("[?]");
        if (strURL.length() > 1) {
            if (arrSplit.length > 1) {
                if (arrSplit[1] != null) {
                    strAllParam = arrSplit[1];
                }
            }
        }

        return strAllParam;
    }

    private URLUtil() throws ClassNotFoundException {
        throw new ClassNotFoundException();
    }

}
