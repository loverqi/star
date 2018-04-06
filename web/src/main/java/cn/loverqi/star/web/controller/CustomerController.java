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
import cn.loverqi.star.core.bean.ResponsePageData;
import cn.loverqi.star.core.mybaties.pojo.Example;
import cn.loverqi.star.core.utils.StringUtil;
import cn.loverqi.star.domain.Customer;
import cn.loverqi.star.domain.UserInfo;
import cn.loverqi.star.service.CustomerService;
import cn.loverqi.star.service.UserInfoService;
import cn.loverqi.star.web.controller.param.CustomerParam;
import cn.loverqi.star.web.security.util.SecurityUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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

    @Autowired
    private UserInfoService userInfoService;

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

    @RequestMapping(value = "/create_customer.html", method = { RequestMethod.GET, RequestMethod.POST })
    public String createCustomer(Model model) {

        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        model.addAttribute("type", "create");

        return "create_customer";
    }

    @RequestMapping(value = "/edit_customer.html", method = { RequestMethod.GET, RequestMethod.POST })
    public String editCustomer(Integer id, Model model) {

        Customer customer = new Customer();
        customer.setId(id);
        customer = customerService.selectByPrimaryKey(customer);
        if (customer != null) {
            UserInfo user = SecurityUtil.getUser();
            if (customer.getCreateUser() != user.getId() && !"ADMIN".equals(user.getRole())) {
                return "error";
            }

        }

        model.addAttribute("customer", customer);
        model.addAttribute("type", "edit");
        return "create_customer";
    }

    @RequestMapping(value = "/customer_details.html", method = { RequestMethod.GET, RequestMethod.POST })
    public String customerDetails(Integer id, Model model) {

        Customer customer = new Customer();
        customer.setId(id);
        customer = customerService.selectByPrimaryKey(customer);
        if (customer != null) {
            UserInfo user = SecurityUtil.getUser();
            if (customer.getCreateUser() != user.getId() && !"ADMIN".equals(user.getRole())) {
                return "error";
            }

        }

        model.addAttribute("customer", customer);
        model.addAttribute("type", "view");
        return "create_customer";
    }

    @ApiOperation(value = "根据id删除客户", notes = "根据id刪除客户，code为0是成功")
    @RequestMapping(value = "/deleteCustomer.do", method = { RequestMethod.POST })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "客户的id", required = true, dataType = "int", paramType = "form"), })
    public @ResponseBody ResponseData<Boolean> deleteCustomer(Integer id) {
        ResponseData<Boolean> responseDate = new ResponseData<Boolean>();
        if (id == null) {
            responseDate.setCode(ResponseDataCode.PARAMETER_ANOMALY);
            responseDate.setMessage(ResponseDataCode.PARAMETER_ANOMALY_MESSAGE);
        } else {
            Customer customer = new Customer();
            customer.setId(id);
            customer = customerService.selectByPrimaryKey(customer);
            int deleteByPrimaryKey = 0;
            if (customer != null) {
                UserInfo user = SecurityUtil.getUser();
                if (customer.getCreateUser() != user.getId() && !"ADMIN".equals(user.getRole())) {
                    responseDate.setCode(ResponseDataCode.LACK_AUTHORITY);
                    responseDate.setMessage(ResponseDataCode.LACK_AUTHORITY_MESSAGE);
                } else {
                    deleteByPrimaryKey = customerService.deleteByPrimaryKey(customer);
                }
            }

            responseDate.setData(deleteByPrimaryKey > 0);
        }

        return responseDate;
    }

    @RequestMapping(value = "/view_customer.html", method = { RequestMethod.GET, RequestMethod.POST })
    public String viewCustomer(@ModelAttribute CustomerParam param, Boolean ifSee, Model model) {

        if (param == null) {
            param = new CustomerParam();
        }
        Example exampleUser = null;
        if ("USER".equals(SecurityUtil.getUser().getRole())) {
            exampleUser = new Example();
            exampleUser.createCriteria().andFieldEqualTo("id", SecurityUtil.getUser().getId());
            param.setCreateUser(SecurityUtil.getUser().getId());
        }
        List<UserInfo> users = userInfoService.selectByExample(new UserInfo(), exampleUser);
        model.addAttribute("users", users);

        Example example = new Example();
        example.setDESCOrderByClause("createDate");
        if (StringUtil.isNotNull(param.getQqNumber())) {
            example.createCriteria().andFieldLike("qqNumber", "%" + param.getQqNumber() + "%");
        }
        if (StringUtil.isNotNull(param.getQqName())) {
            example.createCriteria().andFieldLike("qqName", "%" + param.getQqName() + "%");
        }
        if (StringUtil.isNotNull(param.getWechatNumber())) {
            example.createCriteria().andFieldLike("wechatNumber", "%" + param.getWechatNumber() + "%");
        }
        if (StringUtil.isNotNull(param.getWechatName())) {
            example.createCriteria().andFieldLike("wechatName", "%" + param.getWechatName() + "%");
        }
        if (StringUtil.isNotNull(param.getCustomerSource())) {
            example.createCriteria().andFieldEqualTo("customerSource", param.getCustomerSource());
        }
        if (StringUtil.isNotNull(param.getCustomerType())) {
            example.createCriteria().andFieldEqualTo("customerType", param.getCustomerType());
        }
        if (StringUtil.isNotNull(param.getStartTime())) {
            example.createCriteria().andFieldGreaterThanOrEqualTo("createDate", param.getStartTime());
        }
        if (StringUtil.isNotNull(param.getEndTime())) {
            example.createCriteria().andFieldLessThan("createDate", param.getEndTime());
        }
        if (ifSee != null) {
            example.createCriteria().andFieldEqualTo("ifSee", ifSee);
        }
        if (param.getCreateUser() != null) {
            example.createCriteria().andFieldEqualTo("createUser", param.getCreateUser());
        }
        if (param.getPage() == null) {
            param.setPage(1);
        }
        if (param.getPageSize() == null) {
            param.setPageSize(10);
        }

        Customer customer = new Customer();
        ResponsePageData<Customer> datas = customerService.selectByExampleWithRowbounds(customer, example,
                param.getPage(), param.getPageSize());

        if (ifSee != null && "ADMIN".equals(SecurityUtil.getUser().getRole())) {
            for (Customer customerTemp : datas.getList()) {
                customerTemp.setIfSee(true);
                customerService.updateByPrimaryKey(customerTemp);
            }
        }

        model.addAttribute("param", param);
        model.addAttribute("datas", datas);

        return "view_customer";
    }

}
