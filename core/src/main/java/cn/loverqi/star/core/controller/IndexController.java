package cn.loverqi.star.core.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.loverqi.star.core.domain.StarSysUserInfo;
import io.swagger.annotations.Api;

/**
 * 首页相关
 * @author LoverQi
 * @date 2018年3月28日
 */
@Controller
@Api(tags = "登陆")
@RequestMapping("/")
public class IndexController {
    
    @RequestMapping(value = { "/", "/index.html" }, method = RequestMethod.GET)
    public String index(HttpSession session) {
        return "index";
    }

    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
    public String login(Integer msg, Boolean error, Model model, HttpSession session) {
        String massage = null;
        if (msg != null) {
            if (msg == 1) {
                massage = "已注销登陆";
            } else if (msg == 2) {
                massage = "当前用户已在其他终端登陆。";
            }
        }
        if (error != null && error) {
            try {
                throw (AuthenticationException) session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
            } catch (UsernameNotFoundException exception) {
                massage = "用户名不存在";
            } catch (BadCredentialsException exception) {
                massage = "用户名或密码错误";
            } catch (AccountExpiredException exception) {
                massage = "账户已过期";
            } catch (LockedException exception) {
                massage = "账户被锁定";
            } catch (DisabledException exception) {
                massage = "账户不可用";
            } catch (CredentialsExpiredException exception) {
                massage = "密码已过期";
            } catch (InsufficientAuthenticationException exception) {
                massage = exception.getMessage();
            } catch (Exception exception) {
                massage = "系统异常";
            }
        }

        model.addAttribute("user", new StarSysUserInfo());
        model.addAttribute("massage", massage);

        return "login";
    }

}
