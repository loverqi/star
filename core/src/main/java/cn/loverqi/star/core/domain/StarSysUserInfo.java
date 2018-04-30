package cn.loverqi.star.core.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import cn.loverqi.star.core.basepojo.BasePojo;

/**
 * 用户实体类
 * @author LoverQi
 * @date 2018年3月28日
 */
public class StarSysUserInfo extends BasePojo implements UserDetails {

    private static final long serialVersionUID = 1694602064261623685L;

    /** 主键id*/
    private Integer id;

    /** 用户名*/
    private String username;

    /** 真是姓名*/
    private String name;

    /** 密码*/
    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;

    /** 用户角色*/
    private String role;

    /** 创建时间*/
    private Date createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取用户名
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * 获取用户密码
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * 用户拥有的权限
     */
    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        roles.add(new SimpleGrantedAuthority("ROLE_" + role));
        if ("ADMIN".equals(role)) {
            roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return roles;
    }

    /**
     * 账户是否未过期
     */
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 帐户是否未锁定
     */
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 用户密码是否未过期
     */
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 用户是否可用
     */
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }

}
