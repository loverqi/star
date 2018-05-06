package cn.loverqi.star.core.interceptor;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.loverqi.star.core.domain.StarSysLog;
import cn.loverqi.star.core.domain.StarSysMenu;
import cn.loverqi.star.core.mybaties.example.Example;
import cn.loverqi.star.core.security.util.SecurityUtil;
import cn.loverqi.star.core.service.StarSysLogService;
import cn.loverqi.star.core.service.StarSysMenuService;
import cn.loverqi.star.core.utils.BeanFactoryUtils;
import cn.loverqi.star.core.utils.HostAddrUtil;
import cn.loverqi.star.core.utils.SystemConfiguration;

/**
 * 统一日志记录拦截器
 * @author LoverQi
 * @date 2018年4月19日
 */
@Component
public class LogInterceptor extends HandlerInterceptorAdapter {

    //前置拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        ServletContext servletContext = request.getServletContext();

        //加载菜单map
        if (SystemConfiguration.SYSTEM_LOG_ENABLE && servletContext.getAttribute("menuMaps") == null) {
            Example example = new Example();
            example.createCriteria().andFieldEqualTo("enable", true);
            List<StarSysMenu> starSysMenuServices = BeanFactoryUtils.getBean(StarSysMenuService.class)
                    .selectByExample(example);
            Map<String, String> menuMaps = new HashMap<String, String>();
            for (StarSysMenu starSysMenu : starSysMenuServices) {
                menuMaps.put(starSysMenu.getPath(), starSysMenu.getText());
            }

            servletContext.setAttribute("menuMaps", menuMaps);
        } else if (!SystemConfiguration.SYSTEM_LOG_ENABLE && servletContext.getAttribute("menuMaps") != null) {
            servletContext.removeAttribute("menuMaps");
        }

        return super.preHandle(request, response, handler);
    }

    //后置拦截
    @SuppressWarnings("unchecked")
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

        if (SystemConfiguration.SYSTEM_LOG_ENABLE) {
            String servletPath = request.getServletPath();
            if (!servletPath.endsWith(".jpg") && !servletPath.endsWith(".gif") && !servletPath.endsWith(".png")
                    && !servletPath.endsWith(".css") && !servletPath.endsWith(".ttf") && !servletPath.endsWith(".woff")
                    && !servletPath.endsWith(".js") && !servletPath.endsWith(".ico")
                    && !servletPath.endsWith("/login.html") && !servletPath.endsWith("/error")) { //忽略掉静态资源

                StarSysLog starSysLog = new StarSysLog();
                starSysLog.setPath(servletPath);
                starSysLog.setAccessTime(new Date());
                starSysLog.setIpAddr(HostAddrUtil.getIpAddr(request));
                if (request.getSession().getAttribute("SPRING_SECURITY_CONTEXT") != null) {
                    starSysLog.setAccessUser(SecurityUtil.getUser().getId());
                }

                //加载菜单列表
                Map<String, String> menuMaps = (Map<String, String>) request.getServletContext()
                        .getAttribute("menuMaps");
                starSysLog.setText(menuMaps.get(servletPath));

                BeanFactoryUtils.getBean(StarSysLogService.class).insertSelective(starSysLog);
            }
        }

        super.postHandle(request, response, handler, modelAndView);
    }
}