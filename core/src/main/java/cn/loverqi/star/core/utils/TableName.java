package cn.loverqi.star.core.utils;

/**
 * 数据库表名
 */
public class TableName {

    /**
     * 系统表
     */
    //用户表
    public static final String SYS_USER = "star_sys_user_info";
    //菜单表
    public static final String SYS_MENU = "star_sys_menu";
    //授权表
    public static final String SYS_PRIV = "star_sys_priv";
    //角色表
    public static final String SYS_ROLE = "star_sys_role";
    
    private TableName() throws ClassNotFoundException {
        throw new ClassNotFoundException();
    }
}
