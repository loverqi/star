package cn.loverqi.star.web.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
import cn.loverqi.star.core.mybaties.example.Example;
import cn.loverqi.star.core.poi.excel.ExcelBuilder;
import cn.loverqi.star.core.utils.StringUtil;
import cn.loverqi.star.domain.Bill;
import cn.loverqi.star.domain.NumberData;
import cn.loverqi.star.domain.UserInfo;
import cn.loverqi.star.service.BillService;
import cn.loverqi.star.service.UserInfoService;
import cn.loverqi.star.web.controller.param.BillParam;
import cn.loverqi.star.web.security.util.SecurityUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 账单管理
 * @author LoverQi
 * @date 2018年3月5日
 */
@Controller
@RequestMapping("bill")
@PreAuthorize("hasRole('USER')")
public class BillController {

    @Autowired
    private BillService billService;

    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation(value = "新建或者修改账单", notes = "新建或者修改客户,有id时为修改，无id时为新建，code为0是成功")
    @RequestMapping(value = "/AddOrModifyBill.do", method = { RequestMethod.POST })
    public @ResponseBody ResponseData<Boolean> AddOrModifyBill(@ModelAttribute Bill bill) {

        ResponseData<Boolean> responseDate = new ResponseData<Boolean>();

        int insert = 0;
        if (bill.getId() != null) {
            insert = billService.updateByPrimaryKeySelective(bill);
            responseDate.setData(insert > 0);
        } else {
            bill.setCreateDate(new Date());
            bill.setCreateUser(SecurityUtil.getUser().getId());
            insert = billService.insertSelective(bill);
            responseDate.setData(insert > 0);
        }

        return responseDate;
    }

    @ResponseBody
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/downloadFile.do", method = { RequestMethod.POST })
    public void downloadFile(@ModelAttribute BillParam param, HttpServletResponse response, Model model) {

        Example example = new Example();
        example.setDESCOrderByClause("createDate");
        if (StringUtil.isNotNull(param.getWechatNumber())) {
            example.createCriteria().andFieldEqualTo("wechatNumber", param.getWechatNumber());
        }
        if (StringUtil.isNotNull(param.getWechatName())) {
            example.createCriteria().andFieldLike("wechatName", "%" + param.getWechatName() + "%");
        }
        if (StringUtil.isNotNull(param.getCustomerSource())) {
            example.createCriteria().andFieldEqualTo("customerSource", param.getCustomerSource());
        }
        if (StringUtil.isNotNull(param.getBillingStatus())) {
            example.createCriteria().andFieldEqualTo("billingStatus", param.getBillingStatus());
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

        List<Bill> datas = billService.selectByExample(Bill.class, example);

        try {
            //设置响应头和客户端保存文件名
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/octet-stream; charset=utf-8");
            response.setHeader("Content-Disposition",
                    "attachment;fileName=" + new String("林晟传媒账单详情导出.xls".getBytes("utf-8"), "iso-8859-1"));

            ExcelBuilder.exportExcel(response.getOutputStream(), Bill.class, datas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/create_bill.html", method = { RequestMethod.GET, RequestMethod.POST })
    public String createBill(Model model) {

        Bill bill = new Bill();
        model.addAttribute("bill", bill);
        model.addAttribute("type", "create");

        return "create_bill";
    }

    @RequestMapping(value = "/edit_bill.html", method = { RequestMethod.GET, RequestMethod.POST })
    public String editBill(Integer id, Model model) {

        Bill bill = new Bill();
        bill.setId(id);
        bill = billService.selectByPrimaryKey(bill);
        if (bill != null) {
            UserInfo user = SecurityUtil.getUser();
            if (bill.getCreateUser() != user.getId() && !"ADMIN".equals(user.getRole())) {
                return "error";
            }

        }

        model.addAttribute("bill", bill);
        model.addAttribute("type", "edit");
        return "create_bill";
    }

    @RequestMapping(value = "/bill_details.html", method = { RequestMethod.GET, RequestMethod.POST })
    public String billDetails(Integer id, Model model) {

        Bill bill = new Bill();
        bill.setId(id);
        bill = billService.selectByPrimaryKey(bill);
        if (bill != null) {
            UserInfo user = SecurityUtil.getUser();
            if (bill.getCreateUser() != user.getId() && !"ADMIN".equals(user.getRole())) {
                return "error";
            }

        }

        model.addAttribute("bill", bill);
        model.addAttribute("type", "view");
        return "create_bill";
    }

    @ApiOperation(value = "根据id删除账单", notes = "根据id刪除账单，code为0是成功")
    @RequestMapping(value = "/deletebill.do", method = { RequestMethod.POST })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "账单的id", required = true, dataType = "int", paramType = "form"), })
    public @ResponseBody ResponseData<Boolean> deletebill(Integer id) {
        ResponseData<Boolean> responseDate = new ResponseData<Boolean>();
        if (id == null) {
            responseDate.setCode(ResponseDataCode.PARAMETER_ANOMALY);
            responseDate.setMessage(ResponseDataCode.PARAMETER_ANOMALY_MESSAGE);
        } else {
            Bill bill = new Bill();
            bill.setId(id);
            bill = billService.selectByPrimaryKey(bill);
            int deleteByPrimaryKey = 0;
            if (bill != null) {
                UserInfo user = SecurityUtil.getUser();
                if (bill.getCreateUser() != user.getId() && !"ADMIN".equals(user.getRole())) {
                    responseDate.setCode(ResponseDataCode.LACK_AUTHORITY);
                    responseDate.setMessage(ResponseDataCode.LACK_AUTHORITY_MESSAGE);
                } else {
                    deleteByPrimaryKey = billService.deleteByPrimaryKey(bill);
                }
            }

            responseDate.setData(deleteByPrimaryKey > 0);
        }

        return responseDate;
    }

    @RequestMapping(value = "/view_bill.html", method = { RequestMethod.GET, RequestMethod.POST })
    public String viewBill(@ModelAttribute BillParam param, Boolean ifSee, Model model) throws FileNotFoundException {

        if (param == null) {
            param = new BillParam();
        }
        Example exampleUser = null;
        if ("USER".equals(SecurityUtil.getUser().getRole())) {
            exampleUser = new Example();
            exampleUser.createCriteria().andFieldEqualTo("id", SecurityUtil.getUser().getId());
            param.setCreateUser(SecurityUtil.getUser().getId());
        }
        List<UserInfo> users = userInfoService.selectByExample(UserInfo.class, exampleUser);
        model.addAttribute("users", users);

        Example example = new Example();
        example.setDESCOrderByClause("createDate");
        if (StringUtil.isNotNull(param.getWechatNumber())) {
            example.createCriteria().andFieldEqualTo("wechatNumber", param.getWechatNumber());
        }
        if (StringUtil.isNotNull(param.getWechatName())) {
            example.createCriteria().andFieldLike("wechatName", "%" + param.getWechatName() + "%");
        }
        if (StringUtil.isNotNull(param.getCustomerSource())) {
            example.createCriteria().andFieldEqualTo("customerSource", param.getCustomerSource());
        }
        if (StringUtil.isNotNull(param.getBillingStatus())) {
            example.createCriteria().andFieldEqualTo("billingStatus", param.getBillingStatus());
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
        if (ifSee != null) {
            example.createCriteria().andFieldEqualTo("ifSee", ifSee);
        }
        if (param.getPage() == null) {
            param.setPage(1);
        }
        if (param.getPageSize() == null) {
            param.setPageSize(10);
        }

        ResponsePageData<Bill> datas = billService.selectByExampleWithRowbounds(Bill.class, example, param.getPage(),
                param.getPageSize());
        if (ifSee != null && "ADMIN".equals(SecurityUtil.getUser().getRole())) {
            for (Bill billTemp : datas.getList()) {
                billTemp.setIfSee(true);
                billService.updateByPrimaryKey(billTemp);
            }
        }

        List<Bill> datasTemp = billService.selectByExample(Bill.class, example);
        NumberData numberData = new NumberData();
        for (Bill billTemp : datasTemp) {
            numberData.addPeople(billTemp.getPeopleNumber());
            numberData.addMoney(billTemp.getMoneySum());
        }

        model.addAttribute("numberData", numberData);
        model.addAttribute("param", param);
        model.addAttribute("datas", datas);

        return "view_bill";
    }

}
