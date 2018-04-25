package cn.loverqi.star.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.loverqi.star.core.bean.ResponsePageData;
import cn.loverqi.star.core.mybaties.example.Example;
import cn.loverqi.star.core.service.impl.BaseServiceImpl;
import cn.loverqi.star.domain.Customer;
import cn.loverqi.star.domain.UserInfo;
import cn.loverqi.star.mapper.UserInfoMapper;
import cn.loverqi.star.service.CustomerService;

/**
 * 客户
 * @author LoverQi
 * @date 2018年3月5日
 */
@Service
public class CustomerServiceImpl extends BaseServiceImpl<Customer> implements CustomerService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public Customer selectByPrimaryKey(Customer record) {
        Customer customer = super.selectByPrimaryKey(record);
        setCreateBean(customer);

        return customer;
    }

    @Override
    public List<Customer> selectByExample(Example example) {
        List<Customer> customers = super.selectByExample(example);
        for (Customer customer : customers) {
            setCreateBean(customer);
        }

        return customers;
    }

    @Override
    public ResponsePageData<Customer> selectByExampleWithRowbounds(Example example, int page, int pageSize) {
        ResponsePageData<Customer> pageDatas = super.selectByExampleWithRowbounds(example, page, pageSize);
        List<Customer> list = pageDatas.getList();
        for (Customer customer : list) {
            setCreateBean(customer);
        }

        return pageDatas;
    }

    private void setCreateBean(Customer customer) {
        if (customer != null && customer.getCreateUser() != null) {
            UserInfo userInfo = new UserInfo();
            userInfo.setId(customer.getCreateUser());
            userInfo = userInfoMapper.selectByPrimaryKey(userInfo);
            customer.setCreateUserBean(userInfo);
        }
    }

}
