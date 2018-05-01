package cn.loverqi.star.core.security.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import cn.loverqi.star.core.domain.StarSysMenu;
import cn.loverqi.star.core.mybaties.example.Example;
import cn.loverqi.star.core.service.StarSysMenuService;
import cn.loverqi.star.core.utils.StringUtil;

/**
 * 自动加载数据库中的权限信息，实现动态的加载
 * @author loverqi
 * @date 2018年1月16日
 */
@Component
public class DynamicInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private StarSysMenuService starSysMenuService;

    private HashMap<String, Collection<ConfigAttribute>> map = null;

    /**
     * 加载权限表中所有权限
     */
    public void loadResourceDefine() {

        map = new HashMap<String, Collection<ConfigAttribute>>();
        ConfigAttribute cfg = null;
        Example example = new Example();
        //只查询启用的权限
        example.createCriteria().andFieldEqualTo("enable", true).andFieldEqualTo("isJuris", true)
                .andFieldIsNotNull("funcName");
        List<StarSysMenu> starSysMenus = starSysMenuService.selectByExample(example);

        Collection<ConfigAttribute> array = null;
        for (StarSysMenu starSysMenu : starSysMenus) {
            if (StringUtil.isNotNull(starSysMenu.getFuncName()) && StringUtil.isNotNull(starSysMenu.getPath())) {
                array = new ArrayList<ConfigAttribute>();
                cfg = new SecurityConfig("ROLE_" + starSysMenu.getFuncName());
                //此处添加的信息将会作为MyAccessDecisionManager类的decide的第三个参数。
                array.add(cfg);
                //用权限的path 作为map的key，用ConfigAttribute的集合作为 value，
                map.put(starSysMenu.getPath(), array);
            }
        }

    }

    /*
     * 此方法返回本次访问需要的权限，可以有多个权限
     * 在上面的实现中如果没有匹配的url直接返回null，也就是没有配置权限的url默认都为白名单
     * @see org.springframework.security.access.SecurityMetadataSource#getAttributes(java.lang.Object)
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if (map == null) {
            synchronized (DynamicInvocationSecurityMetadataSource.class) {
                if (map == null) {
                    loadResourceDefine();
                }
            }
        }
        //object 中包含用户请求的request 信息
        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
        AntPathRequestMatcher matcher;
        String resUrl = null;
        for (Iterator<String> iter = map.keySet().iterator(); iter.hasNext();) {
            resUrl = iter.next();
            matcher = new AntPathRequestMatcher(resUrl);
            if (matcher.matches(request)) {
                return map.get(resUrl);
            }
        }

        return null;
    }

    /*
     * 如果返回了所有定义的权限资源，Spring Security会在启动时校验每个ConfigAttribute是否配置正确，不需要校验直接返回null
     * @see org.springframework.security.access.SecurityMetadataSource#getAllConfigAttributes()
     */
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}