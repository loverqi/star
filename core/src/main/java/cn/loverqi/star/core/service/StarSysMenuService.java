package cn.loverqi.star.core.service;

import java.util.List;

import cn.loverqi.star.core.domain.StarSysMenu;
import cn.loverqi.star.core.service.base.BaseService;

/**
 * 菜单权限操作类
 * @author LoverQi
 * @date 2018年3月5日
 */
public interface StarSysMenuService extends BaseService<StarSysMenu> {

    /**
     * 根据菜单的父级id查询指定的菜单项，不自动加载子层菜单
     * @param parentId 菜单的id
     * @return 查询到的菜单项
     */
    List<StarSysMenu> selectByParentByPrimaryKey(String parentId);

    /**
     * 查询所有的顶层目录，不自动加载子层菜单
     * @return 所有的顶层目录
     */
    List<StarSysMenu> selectStarSysMenus();

    /**
     * 查询所有的顶层目录，自动加载所有可能的子层菜单
     * @return 所有的顶层目录
     */
    List<StarSysMenu> selectStarSysMenuWithChildren();

    /**
     * 查询所有已经授权的目录，自动加载所有可能的子层菜单,
     * @return 所有的顶层目录
     */
    List<StarSysMenu> selectStarSysMenuByPriv(List<String> privs);

}
