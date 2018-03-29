package cn.loverqi.star.web.security.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import cn.loverqi.star.domain.UserInfo;

/**
 * 与登录、权限相关的工具类
 * @author loverqi
 * @date 2018年1月17日
 */
public class SecurityUtil {

    /**
     * 获取已经登录用户的用户名
     * @return 不为空时为当前用户的用户名，否则当前用户未登录
     */
    public static UserInfo getUser() {
        return (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    /**
     * 获取当前用户所拥有的权限
     * @return
     */
    public static List<String> getUserAuthorities() {
        List<String> authoritieStrings = new ArrayList<String>();
        Collection<? extends GrantedAuthority> gas = getAuthentication().getAuthorities();
        for (GrantedAuthority ga : gas) {
            authoritieStrings.add(ga.getAuthority());
        }

        return authoritieStrings;
    }

    private static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

}
