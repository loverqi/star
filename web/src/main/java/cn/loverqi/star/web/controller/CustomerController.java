package cn.loverqi.star.web.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.loverqi.star.domain.Customer;
import io.swagger.annotations.Api;

/**
 * 客户管理
 * @author LoverQi
 * @date 2018年3月5日
 */
@Controller
@RequestMapping("customer")
@PreAuthorize("hasRole('USER')")
@Api(value = "账单管理", tags = "customer")
public class CustomerController {

    @RequestMapping(value = "/create_customer.html", method = { RequestMethod.GET, RequestMethod.POST })
    public String createCustomer(@ModelAttribute Customer customer, Model model) {

        System.err.println("创建客户页面");
        return "create_customer";
    }

    @RequestMapping(value = "/view_customer.html", method = { RequestMethod.GET, RequestMethod.POST })
    public String viewCustomer(Model model) {

        System.err.println("查询客户页面");
        return "view_customer";
    }

}
