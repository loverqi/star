package cn.loverqi.star.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.loverqi.star.domain.UserInfo;
import io.swagger.annotations.Api;

/**
 * 账单管理
 * @author LoverQi
 * @date 2018年3月5日
 */
@Controller
@RequestMapping("bill")
@Api(value = "账单管理", tags = "bill")
public class BillController {

    @RequestMapping(value = "/create_bill.html", method = { RequestMethod.GET, RequestMethod.POST })
    public String createBill(@ModelAttribute("user") UserInfo userInfo, Model model) {

        System.err.println("创建账单页面");
        return "create_bill";
    }

    @RequestMapping(value = "/view_bill.html", method = { RequestMethod.GET, RequestMethod.POST })
    public String viewBill(Model model) {

        System.err.println("查询账单页面");
        return "view_bill";
    }

}
