package cn.loverqi.star.core.bean;

/**
 * Response的返回值类型
 * @author loverqi
 * @date 2018年1月5日
 */
public class ResponseDataCode {

    /** 操作成功 */
    public static int SUCCESS = 0;
    public static String SUCCESS_MESSAGE = "操作成功";

    /*系统模块  ==================================>*/
    
    /** 系统异常 */
    public static int SYSTEM_ABNORMALITY = 1000;
    public static String SYSTEM_ABNORMALITY_MESSAGE = "系统异常";

    /** 用户未登陆 */
    public static int NOT_LOGIN = 1001;
    public static String NOT_LOGIN_MESSAGE = "用户未登录";

    /** 权限不足 */
    public static int LACK_AUTHORITY = 1002;
    public static String LACK_AUTHORITY_MESSAGE = "权限不足";

    /** 参数异常 */
    public static int PARAMETER_ANOMALY = 1003;
    public static String PARAMETER_ANOMALY_MESSAGE = "参数异常";
    
    /*系统模块  ================================== 结束*/
   
    /*登录模块  ==================================>*/
    
    /** 用户名或密码错误 */
    public static int  USERNAME_OR_PASSWORD_ERROR  = 2001;
    public static String USERNAME_OR_PASSWORD_ERROR_MESSAGE = "用户名或密码错误";
    
    public static int  NOT_FIND_USER_ERROR  = 2002;
    public static String NOT_FIND_USER_MESSAGE = "用户不存在";
    
    public static int  PASSWORD_ERROR  = 2003;
    public static String PASSWORD_ERROR_MESSAGE = "密码错误";
    
    public static int  FIND_USER_ERROR  = 2004;
    public static String FIND_USER_MESSAGE = "用户已存在";
    
    public static int  PASSWORD_COMPLEXITY_ERROR  = 2003;
    public static String PASSWORD_COMPLEXITY_ERROR_MESSAGE = "密码复杂度不符合要求";
    
    /*登录模块  ================================== 结束*/

}
