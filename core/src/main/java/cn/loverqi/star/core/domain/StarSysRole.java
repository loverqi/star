package cn.loverqi.star.core.domain;

import cn.loverqi.star.core.basepojo.BasePojo;

/**
 * 角色实体类
 * @author LoverQi
 * @date 2018年4月30日
 */
public class StarSysRole extends BasePojo {
    private static final long serialVersionUID = -8526164005778919208L;

    /** 主键id*/
    private Integer id;

    /** 部门id*/
    private Integer postId;

    /** 角色名称*/
    private String name;

    /** 是否启用*/
    private Boolean enable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}