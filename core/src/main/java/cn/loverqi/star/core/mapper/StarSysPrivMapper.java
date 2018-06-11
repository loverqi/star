package cn.loverqi.star.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.loverqi.star.core.domain.StarSysPriv;
import cn.loverqi.star.core.mapper.base.BaseMapper;
import cn.loverqi.star.core.utils.TableName;

/** 角色授权管理类
 * @author LoverQi
 * @date 2018年5月1日
 */
public interface StarSysPrivMapper extends BaseMapper<StarSysPriv> {

    /**
     * @param roleId
     * @return
     */
    @Select("SELECT m.func_name FROM " + TableName.SYS_PRIV + " AS p INNER JOIN " + TableName.SYS_MENU
            + " AS m ON m.id = p.menu_id " + "WHERE p.role_id = #{roleId} "
            + "AND p.`enable` = true AND m.`enable` = true AND m.`is_juris` = true AND m.`func_name` IS NOT NULL")
    List<String> selectPrivByRoleId(Integer roleId);
}
