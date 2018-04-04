package cn.loverqi.star.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.loverqi.star.domain.UserInfo;
import io.swagger.annotations.Api;

/**
 * 登陆
 * @author LoverQi
 * @date 2018年3月28日
 */
@Controller
@RequestMapping("/")
@Api(value = "登陆", tags = "login")
public class LoginController {

    @RequestMapping(value = { "/", "/index.html" }, method = RequestMethod.GET)
    public String index(HttpSession session) {
        return "index";
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

        model.addAttribute("user", new UserInfo());
        model.addAttribute("massage", massage);
        return "login";
    }

}
