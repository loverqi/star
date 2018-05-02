package cn.loverqi.star.core.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.loverqi.star.core.domain.StarSysMenu;
import cn.loverqi.star.core.security.util.SecurityUtil;
import cn.loverqi.star.core.service.StarSysMenuService;
import cn.loverqi.star.core.utils.BeanFactoryUtils;

/**
 * 进入页面前的拦截器，用户加载系统的菜单信息
 * @author LoverQi
 * @date 2018年4月19日
 */
public class MenuInterceptor extends HandlerInterceptorAdapter {

    //前置拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();

        if (session.getAttribute("SPRING_SECURITY_CONTEXT") != null) {
            StarSysMenuService starSysMenuService = BeanFactoryUtils.getBean(StarSysMenuService.class);

            if (session.getAttribute("menus") == null) {
                List<StarSysMenu> starSysMenus = starSysMenuService
                        .selectStarSysMenuByPriv(SecurityUtil.getUserAuthorities());
                session.setAttribute("menus", starSysMenus);
            }
        }

        return super.preHandle(request, response, handler);
    }
}