package cn.loverqi.star.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.loverqi.star.core.bean.ResponsePageData;
import cn.loverqi.star.core.mybaties.example.Example;
import cn.loverqi.star.domain.Bill;
import cn.loverqi.star.domain.UserInfo;
import cn.loverqi.star.mapper.UserInfoMapper;
import cn.loverqi.star.service.BillService;
import cn.loverqi.star.service.base.BaseServiceImpl;

/**
 * 账单
 * @author LoverQi
 * @date 2018年3月5日
 */
@Service
public class BillServiceImpl extends BaseServiceImpl<Bill> implements BillService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public Bill selectByPrimaryKey(Bill record) {
        Bill bill = super.selectByPrimaryKey(record);
        setCreateBean(bill);

        return bill;
    }

    @Override
    public ResponsePageData<Bill> selectByExampleWithRowbounds(Class<Bill> t, Example example, int page, int pageSize) {
        ResponsePageData<Bill> pageDatas = super.selectByExampleWithRowbounds(t, example, page, pageSize);
        List<Bill> list = pageDatas.getList();
        for (Bill bill : list) {
            setCreateBean(bill);
        }

        return pageDatas;
    }

    @Override
    public List<Bill> selectByExample(Class<Bill> t, Example example) {
        List<Bill> bills = super.selectByExample(t, example);
        for (Bill bill : bills) {
            setCreateBean(bill);
        }

        return bills;
    }

    private void setCreateBean(Bill bill) {
        if (bill != null && bill.getCreateUser() != null) {
            UserInfo userInfo = new UserInfo();
            userInfo.setId(bill.getCreateUser());
            userInfo = userInfoMapper.selectByPrimaryKey(userInfo);
            bill.setCreateUserBean(userInfo);
        }
    }
}
