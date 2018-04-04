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
import cn.loverqi.star.domain.Bill;
import cn.loverqi.star.service.BillService;
import cn.loverqi.star.web.security.util.SecurityUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 账单管理
 * @author LoverQi
 * @date 2018年3月5日
 */
@Controller
@RequestMapping("bill")
@PreAuthorize("hasRole('USER')")
@Api(value = "账单管理", tags = "bill")
public class BillController {

    @Autowired
    private BillService billService;
    
    @ApiOperation(value = "新建或者修改账单", notes = "新建或者修改客户,有id时为修改，无id时为新建，code为0是成功")
    @RequestMapping(value = "/AddOrModifyBill.do", method = { RequestMethod.POST })
    public @ResponseBody ResponseData<Boolean> AddOrModifyBill(@ModelAttribute Bill bill) {

        ResponseData<Boolean> responseDate = new ResponseData<Boolean>();

        int insert = 0;
        if (bill.getId() != null) {
            insert = billService.updateByPrimaryKeySelective(bill);
            responseDate.setData(insert > 0);
        } else {
            Example example = new Example();
            example.createCriteria().andFieldEqualTo("wechatNumber", bill.getWechatNumber());
            List<Bill> customers = billService.selectByExample(bill, example);
            if (customers != null && customers.size() > 0) {
                responseDate.setCode(ResponseDataCode.FIND_CUSTOMER_WX_ERROR);
                responseDate.setMessage(ResponseDataCode.FIND_CUSTOMER_WX_MESSAGE);
            } else {
                bill.setCreateDate(new Date());
                bill.setCreateUser(SecurityUtil.getUser().getId());
                insert = billService.insertSelective(bill);
                responseDate.setData(insert > 0);
            }
        }

        return responseDate;
    }

    @RequestMapping(value = "/view_bill.html", method = { RequestMethod.GET, RequestMethod.POST })
    public String viewBill(Model model) {

        System.err.println("查询账单页面");
        return "view_bill";
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
        if (bill == null) {
            bill = new Bill();
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
        if (bill == null) {
            bill = new Bill();
        }

        model.addAttribute("bill", bill);
        model.addAttribute("type", "view");
        return "create_bill";
    }

}
