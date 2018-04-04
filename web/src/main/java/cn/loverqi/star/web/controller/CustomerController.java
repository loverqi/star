package cn.loverqi.star.web.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.loverqi.star.core.bean.ResponseData;
import cn.loverqi.star.core.bean.ResponseDataCode;
import cn.loverqi.star.core.mybaties.pojo.Example;
import cn.loverqi.star.domain.Customer;
import cn.loverqi.star.service.CustomerService;
import cn.loverqi.star.web.security.util.SecurityUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 客户管理
 * @author LoverQi
 * @date 2018年3月5日
 */
@Controller
@RequestMapping("customer")
@PreAuthorize("hasRole('USER')")
@Api(value = "客户管理", tags = "customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @ApiOperation(value = "新建或者修改客户", notes = "新建或者修改客户,有id时为修改，无id时为新建，code为0是成功")
    @RequestMapping(value = "/AddOrModifyCustomer.do", method = { RequestMethod.POST })
    public @ResponseBody ResponseData<Boolean> AddOrModifyCustomer(@ModelAttribute Customer customer) {

        ResponseData<Boolean> responseDate = new ResponseData<Boolean>();

        int insert = 0;
        if (customer.getId() != null) {
            insert = customerService.updateByPrimaryKeySelective(customer);
            responseDate.setData(insert > 0);
        } else {
            Example example1 = new Example();
            example1.createCriteria().andFieldEqualTo("qqNumber", customer.getQqNumber());
            Example example2 = new Example();
            example2.createCriteria().andFieldEqualTo("wechatNumber", customer.getWechatNumber());
            List<Customer> customers1 = customerService.selectByExample(customer, example1);
            List<Customer> customers2 = customerService.selectByExample(customer, example2);
            if (customers1 != null && customers1.size() > 0) {
                responseDate.setCode(ResponseDataCode.FIND_CUSTOMER_QQ_ERROR);
                responseDate.setMessage(ResponseDataCode.FIND_CUSTOMER_QQ_MESSAGE);
            } else if (customers2 != null && customers2.size() > 0) {
                responseDate.setCode(ResponseDataCode.FIND_CUSTOMER_WX_ERROR);
                responseDate.setMessage(ResponseDataCode.FIND_CUSTOMER_WX_MESSAGE);
            } else {
                customer.setCreateDate(new Date());
                customer.setCreateUser(SecurityUtil.getUser().getId());
                insert = customerService.insertSelective(customer);
                responseDate.setData(insert > 0);
            }
        }

        return responseDate;
    }

    @RequestMapping(value = "/view_customer.html", method = { RequestMethod.GET, RequestMethod.POST })
    public String viewCustomer(Model model) {

        System.err.println("查询客户页面");
        return "view_customer";
    }

    @RequestMapping(value = "/create_customer.html", method = { RequestMethod.GET, RequestMethod.POST })
    public String createCustomer(Model model) {

        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        model.addAttribute("type", "create");

        return "create_customer";
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/edit_customer.html", method = { RequestMethod.GET, RequestMethod.POST })
    public String editCustomer(Integer id, Model model) {

        Customer customer = new Customer();
        customer.setId(id);
        customer = customerService.selectByPrimaryKey(customer);
        if (customer == null) {
            customer = new Customer();
        }

        model.addAttribute("customer", customer);
        model.addAttribute("type", "edit");
        return "create_customer";
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/customer_details.html", method = { RequestMethod.GET, RequestMethod.POST })
    public String customerDetails(Integer id, Model model) {

        Customer customer = new Customer();
        customer.setId(id);
        customer = customerService.selectByPrimaryKey(customer);
        if (customer == null) {
            customer = new Customer();
        }

        model.addAttribute("customer", customer);
        model.addAttribute("type", "view");
        return "create_customer";
    }

}
