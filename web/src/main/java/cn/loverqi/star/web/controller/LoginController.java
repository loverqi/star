package cn.loverqi.star.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.loverqi.star.core.domain.StarSysUserInfo;
import io.swagger.annotations.Api;

/**
 * 登陆
 * @author LoverQi
 * @date 2018年3月28日
 */
@Controller
@Api(tags = "登陆")
@RequestMapping("/")
public class LoginController {

    @RequestMapping(value = { "/", "/index.html" }, method = RequestMethod.GET)
    public String index(HttpSession session) {
        return "index";
    }

    @RequestMapping(value = "/index2.html", method = RequestMethod.GET)
    public String index2(HttpSession session) {
        return "22";
    }

    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
    public String login(Integer msg, Integer err, Model model) {
        String massage = null;
        if (msg != null) {
            if (msg == 1) {
                massage = "已注销登陆";
            } else if (msg == 2) {
                massage = "当前用户已在其他终端登陆。";
            }
        }
        if (err != null) {
            if (err == 1) {
                massage = "用户名或者密码不正确";
            }
        }

        model.addAttribute("user", new StarSysUserInfo());
        model.addAttribute("massage", massage);
        return "login";
    }

}
