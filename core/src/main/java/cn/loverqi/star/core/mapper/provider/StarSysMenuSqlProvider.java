package cn.loverqi.star.core.mapper.provider;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import cn.loverqi.star.core.domain.StarSysMenu;
import cn.loverqi.star.core.utils.TableName;

/**
 * 
 * @author LoverQi
 * @date 2018年5月1日
 */
public class StarSysMenuSqlProvider {

    private StarSysMenu starSysMenu;

    public StarSysMenuSqlProvider() {
        starSysMenu = new StarSysMenu();
    }

    public String selectStarSysMenuByPriv(final Map<String, Object> map) {

        @SuppressWarnings("unchecked")
        List<String> privs = (List<String>) map.get("privs");
        final boolean ifHasRule = privs != null && !privs.isEmpty();

        String sql = new SQL() {
            {
                SELECT_DISTINCT(starSysMenu.getEscapeTableFields());
                FROM(TableName.SYS_MENU);
                WHERE("`enable` = TRUE");
                WHERE("is_leaf = FALSE");
                if (ifHasRule) {
                    final StringBuffer sb = new StringBuffer();
                    for (String priv : privs) {
                        if (priv.startsWith("ROLE_")) {
                            priv = priv.substring("ROLE_".length(), priv.length());
                        }
                        sb.append("'");
                        sb.append(priv);
                        sb.append("'");
                        sb.append(",");
                    }

                    //删除最后的一个逗号
                    int i = sb.lastIndexOf(",");
                    if (i > -1) {
                        sb.delete(i, i + 1);
                    }

                    String sqlList = new SQL() {
                        {
                            SELECT_DISTINCT("mt.id");
                            FROM(TableName.SYS_MENU + " AS mt");
                            WHERE("mt.`enable` = TRUE");
                            WHERE("mt.func_name IN (" + sb.toString() + ")");
                        }
                    }.toString();

                    WHERE("(is_juris = FALSE OR id IN (" + sqlList + "))");
                } else {
                    WHERE("is_juris = FALSE");
                }
                ORDER_BY("id");
            }
        }.toString();
System.err.println(sql);
        return sql;
    }
}