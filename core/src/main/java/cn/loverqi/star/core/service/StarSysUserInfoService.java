package cn.loverqi.star.core.service;

import cn.loverqi.star.core.domain.StarSysUserInfo;
import cn.loverqi.star.core.exception.PassWordComplexityException;
import cn.loverqi.star.core.mybaties.example.Example;
import cn.loverqi.star.core.service.base.BaseService;

/**
 * 用户
 * @author LoverQi
 * @date 2018年3月5日
 */
public interface StarSysUserInfoService extends BaseService<StarSysUserInfo> {

    /**
     * 修改密码的方法
     * @param record 需要修改密码的用户
     * @return 成功的个数
     */
    int updatePassWord(StarSysUserInfo record) throws PassWordComplexityException;

    /**
     * 批量修改密码的方法
     * @param record 需要修改密码的用户
     * @return 成功的个数
     */
    int updatePassWord(String password, Example example) throws PassWordComplexityException;

}
