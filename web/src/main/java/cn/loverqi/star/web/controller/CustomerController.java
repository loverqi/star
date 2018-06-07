package cn.loverqi.star.web.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.loverqi.star.core.bean.ResponseData;
import cn.loverqi.star.core.bean.ResponseDataCode;
import cn.loverqi.star.core.bean.ResponsePageData;
import cn.loverqi.star.core.domain.StarSysUserInfo;
import cn.loverqi.star.core.mybaties.example.Example;
import cn.loverqi.star.core.poi.excel.ExcelBuilder;
import cn.loverqi.star.core.security.util.SecurityUtil;
import cn.loverqi.star.core.service.StarSysUserInfoService;
import cn.loverqi.star.core.utils.StringUtil;
import cn.loverqi.star.domain.Customer;
import cn.loverqi.star.service.CustomerService;
import cn.loverqi.star.web.controller.param.CustomerParam;
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
@Api(tags = "客户管理")
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private StarSysUserInfoService userInfoService;

    @ApiOperation(value = "新建或者修改客户", notes = "新建或者修改客户,有id时为修改，无id时为新建，code为0是成功")
    @RequestMapping(value = "/AddOrModifyCustomer.do", method = { RequestMethod.POST })
    public @ResponseBody ResponseData<Boolean> AddOrModifyCustomer(@ModelAttribute Customer customer) {

        ResponseData<Boolean> responseDate = new ResponseData<Boolean>();

        int insert = 0;
        if (customer.getId() != null) {
            if (StringUtil.isNotNull(customer.getQqName()) || StringUtil.isNotNull(customer.getWechatNumber())) {
                Example example1 = new Example();
                if (StringUtil.isNotNull(customer.getQqName())) {
                    example1.createCriteria().andFieldEqualTo("qqNumber", customer.getQqNumber())
                            .andFieldNotEqualTo("id", customer.getId());
                }
                List<Customer> customers1 = customerService.selectByExample(example1);

                Example example2 = new Example();
                if (StringUtil.isNotNull(customer.getWechatNumber())) {
                    example2.createCriteria().andFieldEqualTo("wechatNumber", customer.getWechatNumber())
                            .andFieldNotEqualTo("id", customer.getId());
                }
                List<Customer> customers2 = customerService.selectByExample(example2);

                if (customers1 != null && customers1.size() > 0) {
                    responseDate.setCode(ResponseDataCode.FIND_CUSTOMER_QQ_ERROR);
                    responseDate.setMessage(ResponseDataCode.FIND_CUSTOMER_QQ_MESSAGE);
                } else if (customers2 != null && customers2.size() > 0) {
                    responseDate.setCode(ResponseDataCode.FIND_CUSTOMER_WX_ERROR);
                    responseDate.setMessage(ResponseDataCode.FIND_CUSTOMER_WX_MESSAGE);
                } else {
                    insert = customerService.updateByPrimaryKeySelective(customer);
                }
            } else {
                insert = customerService.updateByPrimaryKeySelective(customer);
            }

            responseDate.setData(insert > 0);
        } else {
            Example example1 = new Example();
            example1.createCriteria().andFieldEqualTo("qqNumber", customer.getQqNumber());
            Example example2 = new Example();
            example2.createCriteria().andFieldEqualTo("wechatNumber", customer.getWechatNumber());
            List<Customer> customers1 = customerService.selectByExample(example1);
            List<Customer> customers2 = customerService.selectByExample(example2);
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

    @ApiOperation(value = "上传用户", notes = "上传用户，code为0是成功")
    @RequestMapping(value = "/uploadFile.do", method = RequestMethod.POST, headers = ("content-type=multipart/*"), consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "文件", required = true, dataType = "file", paramType = "form"), })
    public @ResponseBody ResponseData<String> uploadFile(MultipartFile file) {
        ResponseData<String> responseDate = new ResponseData<String>();
        String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1)
                .toLowerCase();
        if ("xls".equals(extension) || "xlsx".equals(extension)) {
            List<Customer> customers = ExcelBuilder.readExcel(file, Customer.class);
            int insert = 0;
            for (Customer customer : customers) {
                customer.setCreateUser(SecurityUtil.getUser().getId());
                if (StringUtil.isNotNull(customer.getQqName()) || StringUtil.isNotNull(customer.getWechatNumber())) {
                    Example example1 = new Example();
                    example1.createCriteria().andFieldEqualTo("qqNumber", customer.getQqNumber());
                    Example example2 = new Example();
                    example2.createCriteria().andFieldEqualTo("wechatNumber", customer.getWechatNumber());
                    List<Customer> customers1 = customerService.selectByExample(example1);
                    List<Customer> customers2 = customerService.selectByExample(example2);
                    if ((customers1 == null || customers1.size() < 1)
                            && (customers2 == null || customers2.size() < 1)) {
                        customer.setCreateDate(new Date());
                        customer.setCreateUser(SecurityUtil.getUser().getId());
                        insert += customerService.insertSelective(customer);
                    }
                }
            }

            responseDate.setData("共插入[" + insert + "]条客户数据");
        }

        return responseDate;
    }

    @ResponseBody
    @RequestMapping(value = "/downloadFile.do", method = { RequestMethod.POST })
    public void downloadFile(@ModelAttribute CustomerParam param, HttpServletResponse response, Model model) {

        Example example = new Example();
        example.setDESCOrderByClause("createDate");
        if (StringUtil.isNotNull(param.getQqNumber())) {
            example.createCriteria().andFieldEqualTo("qqNumber", param.getQqNumber());
        }
        if (StringUtil.isNotNull(param.getQqName())) {
            example.createCriteria().andFieldLike("qqName", param.getQqName());
        }
        if (StringUtil.isNotNull(param.getWechatNumber())) {
            example.createCriteria().andFieldEqualTo("wechatNumber", param.getWechatNumber());
        }
        if (StringUtil.isNotNull(param.getWechatName())) {
            example.createCriteria().andFieldLike("wechatName", param.getWechatName());
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
        if (param.getCreateUser() != null) {
            example.createCriteria().andFieldEqualTo("createUser", param.getCreateUser());
        }

        List<Customer> datas = customerService.selectByExample(example);

        try {
            //设置响应头和客户端保存文件名
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/octet-stream; charset=utf-8");
            response.setHeader("Content-Disposition",
                    "attachment;fileName=" + new String("林晟传媒客户详情导出.xls".getBytes("utf-8"), "iso-8859-1"));

            ExcelBuilder.exportExcel(response.getOutputStream(), Customer.class, datas);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

        model.addAttribute("customer", customer);
        model.addAttribute("type", "edit");
        return "create_customer";
    }

    @RequestMapping(value = "/customer_details.html", method = { RequestMethod.GET, RequestMethod.POST })
    public String customerDetails(Integer id, Model model) {

        Customer customer = new Customer();
        customer.setId(id);
        customer = customerService.selectByPrimaryKey(customer);

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
                deleteByPrimaryKey = customerService.deleteByPrimaryKey(customer);
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
        List<StarSysUserInfo> users = userInfoService.selectByExample(exampleUser);
        model.addAttribute("users", users);

        Example example = new Example();
        example.setDESCOrderByClause("createDate");
        if (StringUtil.isNotNull(param.getQqNumber())) {
            example.createCriteria().andFieldEqualTo("qqNumber", param.getQqNumber());
        }
        if (StringUtil.isNotNull(param.getQqName())) {
            example.createCriteria().andFieldLike("qqName", "%" + param.getQqName() + "%");
        }
        if (StringUtil.isNotNull(param.getWechatNumber())) {
            example.createCriteria().andFieldEqualTo("wechatNumber", param.getWechatNumber());
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

        ResponsePageData<Customer> datas = customerService.selectByExampleWithRowbounds(example, param.getPage(),
                param.getPageSize());

        model.addAttribute("param", param);
        model.addAttribute("datas", datas);

        return "view_customer";
    }

}
