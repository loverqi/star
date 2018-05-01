package cn.loverqi.star.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import cn.loverqi.star.core.domain.StarSysMenu;
import cn.loverqi.star.core.mapper.base.BaseMapper;
import cn.loverqi.star.core.mapper.provider.StarSysMenuSqlProvider;

/** 菜单权限管理类
 * @author LoverQi
 * @date 2018年3月5日
 */
public interface StarSysMenuMapper extends BaseMapper<StarSysMenu> {

    @SelectProvider(type = StarSysMenuSqlProvider.class, method = "selectStarSysMenuByPriv")
    List<StarSysMenu> selectStarSysMenuByPriv(@Param("privs") List<String> privs);
}
