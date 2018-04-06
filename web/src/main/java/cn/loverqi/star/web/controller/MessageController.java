package cn.loverqi.star.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.loverqi.star.core.bean.ResponseData;
import cn.loverqi.star.core.mybaties.pojo.Example;
import cn.loverqi.star.domain.Bill;
import cn.loverqi.star.domain.Customer;
import cn.loverqi.star.domain.Message;
import cn.loverqi.star.service.BillService;
import cn.loverqi.star.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 客户管理
 * @author LoverQi
 * @date 2018年3月5日
 */
@RestController
@RequestMapping("msg")
@PreAuthorize("hasRole('ADMIN')")
@Api(value = "消息管理", tags = "msg")
public class MessageController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private BillService billService;

    @ApiOperation(value = "新建或者修改客户", notes = "新建或者修改客户,有id时为修改，无id时为新建，code为0是成功")
    public ResponseData<Message> getMessages() {

        ResponseData<Message> responseDate = new ResponseData<Message>();
        Message message = new Message();

        Example example = new Example();
        example.createCriteria().andFieldEqualTo("ifSee", false);

        Customer customer = new Customer();
        List<Customer> customers = customerService.selectByExample(customer, example);
        if (customers != null && customers.size() > 0) {
            message.setCuntomerMsgCount(customers.size());
            message.setCuntomerMsgDate(customers.get(customers.size() - 1).getCreateDate());
        }

        Bill bill = new Bill();
        List<Bill> bills = billService.selectByExample(bill, example);
        if (bills != null && bills.size() > 0) {
            message.setBillMsgCount(bills.size());
            message.setBillMsgDate(bills.get(bills.size() - 1).getCreateDate());
        }

        return responseDate;
    }

}
