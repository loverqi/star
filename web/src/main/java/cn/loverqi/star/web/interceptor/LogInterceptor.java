package cn.loverqi.star.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 统一日志记录拦截器
 * @author LoverQi
 * @date 2018年4月19日
 */
public class LogInterceptor extends HandlerInterceptorAdapter {

    private static final ThreadLocal<Long> mailogthreadLocal = new ThreadLocal<Long>();

    //前置拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return super.preHandle(request, response, handler);
        }
        mailogthreadLocal.set(System.currentTimeMillis());
        return super.preHandle(request, response, handler);
    }

    //后置拦截
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
             super.preHandle(request, response, handler);
             return;
        }
        HandlerMethod method = (HandlerMethod)handler;
        MainAnnotation mainlog = method.getMethodAnnotation(MainAnnotation.class);
        if(mainlog != null) {
            String desc = mainlog.desc();
            int maintype = mainlog.maintype();
            String type = mainlog.type();
            String tables = mainlog.tables();
            String username = (String) request.getSession().getAttribute("username");
            long costtime = (int) (System.currentTimeMillis()-get());
            LogUtil.writeMainLog(new MainLogEntity(maintype, username, tables, desc, costtime),list);//异步插入数据库日志记录

        }
    }