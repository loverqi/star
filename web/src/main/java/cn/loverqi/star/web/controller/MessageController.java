package cn.loverqi.star.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.loverqi.star.core.bean.ResponseData;
import cn.loverqi.star.core.mybaties.example.Example;
import cn.loverqi.star.domain.Bill;
import cn.loverqi.star.domain.Customer;
import cn.loverqi.star.domain.Message;
import cn.loverqi.star.service.BillService;
import cn.loverqi.star.service.CustomerService;
import io.swagger.annotations.ApiOperation;

/**
 * 客户管理
 * @author LoverQi
 * @date 2018年3月5日
 */
@RestController
@RequestMapping("msg")
@PreAuthorize("hasRole('ADMIN')")
public class MessageController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private BillService billService;

    @ApiOperation(value = "查询未读消息", notes = "查询未读消息，code为0是成功")
    @RequestMapping(value = "/getMessages.do", method = { RequestMethod.GET })
    public ResponseData<Message> getMessages() {

        ResponseData<Message> responseDate = new ResponseData<Message>();
        Message message = new Message();

        Example example = new Example();
        example.createCriteria().andFieldEqualTo("ifSee", false);

        List<Customer> customers = customerService.selectByExample(example);
        if (customers != null && customers.size() > 0) {
            message.setCuntomerMsgCount(customers.size());
            message.setCuntomerMsgDate(customers.get(customers.size() - 1).getCreateDate());
        }

        List<Bill> bills = billService.selectByExample(example);
        if (bills != null && bills.size() > 0) {
            message.setBillMsgCount(bills.size());
            message.setBillMsgDate(bills.get(bills.size() - 1).getCreateDate());
        }

        responseDate.setData(message);

        return responseDate;
    }

}
