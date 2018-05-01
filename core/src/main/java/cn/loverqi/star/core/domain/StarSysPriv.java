package cn.loverqi.star.core.domain;

import cn.loverqi.star.core.basepojo.BasePojo;

/**
 * 角色授权实体类
 * @author LoverQi
 * @date 2018年4月30日
 */
public class StarSysPriv extends BasePojo {
    private static final long serialVersionUID = -1764618894603593208L;

    /** 主键id*/
    private Integer id;

    /** 角色id*/
    private Integer roleId;

    /** 菜单权限id*/
    private String menuId;

    /** 是否启用*/
    private Boolean enable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}