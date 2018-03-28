package cn.loverqi.star.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import cn.loverqi.star.core.mybaties.pojo.MyBatisPojo;

/**
 * 用户实体类
 * @author LoverQi
 * @date 2018年3月28日
 */
public class UserInfo extends MyBatisPojo {

    private static final long serialVersionUID = 1694602064261623685L;

    /** 主键id*/
    private Integer id;

    /** 用户名*/
    private String username;

    /** 密码*/
    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;

    /** 用户角色*/
    private String role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

}
