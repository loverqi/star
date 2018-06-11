package cn.loverqi.star.core.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import cn.loverqi.star.core.utils.ConstantUtil;
import cn.loverqi.star.core.utils.StringUtil;

/**
 * 为登陆添加验证码
 * @author LoverQi
 * @date 2018年5月30日
 */
public class KaptchaAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    private String servletPath;
    private String codeParameter;

    public KaptchaAuthenticationFilter(String servletPath, String failureUrl, String codeParameter) {
        super(servletPath);
        this.servletPath = servletPath;
        this.codeParameter = codeParameter;
        setAuthenticationFailureHandler(new SimpleUrlAuthenticationFailureHandler(failureUrl));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if ("POST".equalsIgnoreCase(req.getMethod()) && servletPath.equals(req.getServletPath())) {
            String expect = (String) req.getSession().getAttribute(ConstantUtil.KAPTCHA_SESSION_KEY);
            if (expect != null) {
                String msg = null;
                String parameter = req.getParameter(codeParameter);
                if (StringUtil.isNull(parameter)) {
                    msg = "请输入验证码";
                } else if (!expect.equalsIgnoreCase(parameter)) {
                    msg = "验证码不正确";
                }

                if (StringUtil.isNotNull(msg)) {
                    unsuccessfulAuthentication(req, res, new InsufficientAuthenticationException(msg));
                    return;
                }
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {
        return null;
    }
}