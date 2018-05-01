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

import cn.loverqi.star.core.SystemConfiguration;
import cn.loverqi.star.core.annotation.FieldIgnore;
import cn.loverqi.star.core.basepojo.BasePojo;
import cn.loverqi.star.core.utils.DateUtil;

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

    /** 真实姓名*/
    private String name;

    /** 密码*/
    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;

    /** 用户角色*/
    private Integer roleId;

    /** 联系方式*/
    private String contact;

    /** 创建时间*/
    private Date createDate;

    /** 修改密码时间*/
    private Date updatePwdTime;

    /** 账号是否未锁定*/
    private Boolean isUnlock;

    /** 是否启用*/
    private Boolean enable;

    /** 用户所拥有的权限*/
    @FieldIgnore
    private List<GrantedAuthority> authorities;

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

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Boolean getIsUnlock() {
        return isUnlock;
    }

    public void setIsUnlock(Boolean isUnlock) {
        this.isUnlock = isUnlock;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
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

    public Date getUpdatePwdTime() {
        return updatePwdTime;
    }

    public void setUpdatePwdTime(Date updatePwdTime) {
        this.updatePwdTime = updatePwdTime;
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
     * 设置权限组
     */
    public void addAuthoritiesGlSysPrivs(List<String> glSysPrivs) {
        for (String string : glSysPrivs) {
            addAuthoritiesGlSysPriv(string);
        }
    }

    /**
     * 设置单个权限
     */
    public void addAuthoritiesGlSysPriv(String authoritieName) {
        addAuthoritiesGlSysPriv(new SimpleGrantedAuthority("ROLE_" + authoritieName));
    }

    /**
     * 设置单个权限
     */
    private void addAuthoritiesGlSysPriv(GrantedAuthority authoritie) {
        if (authorities == null) {
            synchronized (StarSysUserInfo.class) {
                if (authorities == null) {
                    authorities = new ArrayList<GrantedAuthority>();
                }
            }
        }

        authorities.add(authoritie);
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    /**
     * 用户拥有的权限
     */
    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities == null ? new ArrayList<GrantedAuthority>() : authorities;
    }

    /**
     * 账户是否未过期
     */
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        boolean isAccountNon = false;
        if (updatePwdTime != null) {
            int millisecond = DateUtil.differentDaysByMillisecond(System.currentTimeMillis(), updatePwdTime.getTime());
            isAccountNon = millisecond < SystemConfiguration.getPasswordUpdateDays();
        }
        return isAccountNon;
    }

    /**
     * 帐户是否未锁定
     */
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return isUnlock == null ? false : isUnlock;
    }

    /**
     * 用户密码是否未过期
     */
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return isAccountNonExpired();
    }

    /**
     * 用户是否可用
     */
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return enable == null ? false : enable;
    }
}
