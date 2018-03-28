package cn.loverqi.star.core.utils;

/**
 * 数据库表名
 */
public class TableName {

    /**
     * 系统表
     */
    //用户表
    public static final String SYS_USER = "gl_sys_user";
    //方法表
    public static final String SYS_FUNC = "gl_sys_func";
    //字典表
    public static final String SYS_CODE = "gl_sys_code";
    //权限表
    public static final String SYS_PRIV = "gl_sys_priv";
    //部门表
    public static final String SYS_DEPT = "gl_sys_dept";
    //岗位表
    public static final String SYS_POST = "gl_sys_post";


    /**
     * 业务表
     */
    //业务表
    public static final String BS_MORTGATE = "business_mortgage";
    //巡核库表
    public static final String BS_INSPECTION = "business_inspection";
    //巡核库详情表
    public static final String BS_INSPECTION_DETAIL = "business_inspection_detail";
    //业务到期
    public static final String BS_DEAD_LINE = "budead_line";
    //业务流程表
    public static final String BS_FLOW = "business_flow";

    /**
     * 业务字典表
     */
    //巡核库巡核频率表
    public static final String BS_INSPECT_FREQ = "gl_inspect_freq";
    //监管机构表
    public static final String BS_SUPER_UNIT = "gl_super_unit";


    /**
     * 定时业务
     */
    //定时业务表
    public static final String CRON_TASK = "gl_cron_task";
}
