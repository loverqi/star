package cn.loverqi.star.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.loverqi.star.core.domain.StarSysMenu;
import cn.loverqi.star.core.mapper.StarSysMenuMapper;
import cn.loverqi.star.core.mybaties.example.Example;
import cn.loverqi.star.core.service.StarSysMenuService;
import cn.loverqi.star.core.service.base.impl.BaseServiceImpl;
import cn.loverqi.star.core.treedata.TreeBuilder;

/**
 * 菜单权限操作类的实现类
 * @author LoverQi
 * @date 2018年3月5日
 */
@Service
public class StarSysMenuServiceImpl extends BaseServiceImpl<StarSysMenu> implements StarSysMenuService {

    @Autowired
    private StarSysMenuMapper starSysMenuMapper;

    /**
     * 根据菜单的父级id查询指定的菜单项，不自动加载子层菜单
     * @param parentId 菜单的id
     * @return 查询到的菜单项
     */
    @Override
    public List<StarSysMenu> selectByParentByPrimaryKey(String parentId) {
        Example example = new Example();
        example.createCriteria().andFieldEqualTo("parent", parentId).andFieldEqualTo("enable", true)
                .andFieldEqualTo("isLeaf", false);
        List<StarSysMenu> starSysMenus = baseMapper.selectByExample(StarSysMenu.class, example);

        return starSysMenus;
    }

    /**
     * 查询所有的顶层目录，不自动加载子层菜单
     * @return 所有的顶层目录
     */
    @Override
    public List<StarSysMenu> selectStarSysMenus() {
        Example example = new Example();
        example.createCriteria().andFieldEqualTo("enable", true).andFieldEqualTo("isLeaf", false)
                .andFieldEqualTo("parent", "#");
        List<StarSysMenu> starSysMenus = baseMapper.selectByExample(StarSysMenu.class, example);

        return starSysMenus;
    }

    /*
     * 查询所有的顶层目录，自动加载子层菜单
     * @return 所有的目录
     */
    @Override
    public List<StarSysMenu> selectStarSysMenuWithChildren() {

        Example example = new Example();
        example.createCriteria().andFieldEqualTo("enable", true).andFieldEqualTo("isLeaf", false);
        List<StarSysMenu> starSysMenus = baseMapper.selectByExample(StarSysMenu.class, example);

        //拼装树形json字符串
        starSysMenus = new TreeBuilder<StarSysMenu>().buildTree(starSysMenus);
        return starSysMenus;
    }

    @Override
    public List<StarSysMenu> selectStarSysMenuByPriv(List<String> privs) {
        List<StarSysMenu> starSysMenus = starSysMenuMapper.selectStarSysMenuByPriv(privs);

        //拼装树形json字符串
        starSysMenus = new TreeBuilder<StarSysMenu>().buildTree(starSysMenus);

        return starSysMenus;
    }

}
