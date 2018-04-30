package cn.loverqi.star.core.security.manager;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

/**
 * 判断用户是否有权限的决策类
 * @author loverqi
 * @date 2018年1月16日
 */
@Component
public class DynamicAccessDecisionManager implements AccessDecisionManager {

    /*
     * 该方法是判定是否拥有权限的决策方法
     * @see org.springframework.security.access.AccessDecisionManager#decide(org.springframework.security.core.Authentication, java.lang.Object, java.util.Collection)
     * 
     * authentication 是释CustomUserService中循环添加到 GrantedAuthority 对象中的权限信息集合.
     * object 包含客户端发起的请求的requset信息，可转换为 HttpServletRequest
     * configAttributes 为MyInvocationSecurityMetadataSource的getAttributes(Object object)这个方法返回的结果，此方法是为了判定用户请求的url 是否在权限表中，如果在权限表中，则返回给 decide 方法，用来判定用户是否有此权限。如果不在权限表中则放行。
     */
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
            throws AccessDeniedException, InsufficientAuthenticationException {

        if (null == configAttributes || configAttributes.size() <= 0) {
            return;
        }
        ConfigAttribute c = null;
        String needRole = null;
        for (Iterator<ConfigAttribute> iter = configAttributes.iterator(); iter.hasNext();) {
            c = iter.next();
            needRole = c.getAttribute();

            //authentication为用户所拥有的权限
            for (GrantedAuthority ga : authentication.getAuthorities()) {
                if (needRole.trim().equals(ga.getAuthority())) {
                    return;
                }
            }
        }

        throw new AccessDeniedException("no right");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}