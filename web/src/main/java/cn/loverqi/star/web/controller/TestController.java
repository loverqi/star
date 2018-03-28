package cn.loverqi.star.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.loverqi.star.domain.UserInfo;
import io.swagger.annotations.Api;

/**
 * 文件上传的测试类
 * @author LoverQi
 * @date 2018年3月28日
 */
@Controller
@RequestMapping("test")
@Api(value = "文件上传", tags = "test")
public class TestController {

    @RequestMapping(value = "/testPage", method = RequestMethod.GET)
    public String testPage(Model model) {

        UserInfo userInfo = new UserInfo();

        userInfo.setUsername("123456");
        userInfo.setPassword("1234567");
        userInfo.setRole("1234568");

        model.addAttribute("user", userInfo);
        return "test";
    }

}
