package cn.loverqi.star.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.loverqi.star.core.utils.SystemConfiguration;

/**
 * 进入页面前的拦截器，用户加载系统的系统配置
 * @author LoverQi
 * @date 2018年4月19日
 */
@Component
public class SystemConfigInterceptor extends HandlerInterceptorAdapter {

    //前置拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();

        if (session.getAttribute("config") == null) {
            session.setAttribute("config", SystemConfiguration.getConfigs());

        }

        return super.preHandle(request, response, handler);
    }
}