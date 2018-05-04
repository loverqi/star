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
     * 插入用户并处理密码
     * @param record 插入的用户
     * @return 成功的个数
     * @throws PassWordComplexityException 密码复杂度异常
     */
    int insertWithPassword(StarSysUserInfo record) throws PassWordComplexityException;

    /**
     * 插入用户并处理密码
     * @param record 插入的用户
     * @return 成功的个数
     * @throws PassWordComplexityException 密码复杂度异常
     */
    int insertWithPasswordAndGeneratedKeys(StarSysUserInfo record) throws PassWordComplexityException;

    /**
     * 插入用户并处理密码
     * @param record 插入的用户
     * @return 成功的个数
     * @throws PassWordComplexityException 密码复杂度异常
     */
    int insertSelectiveWithPassword(StarSysUserInfo record) throws PassWordComplexityException;

    /**
     * 插入用户并处理密码
     * @param record 插入的用户
     * @return 成功的个数
     * @throws PassWordComplexityException 密码复杂度异常
     */
    int insertSelectiveWithPasswordAndGeneratedKeys(StarSysUserInfo record) throws PassWordComplexityException;

    /**
     * 修改密码的方法
     * @param record 需要修改密码的用户
     * @return 成功的个数
     * @throws PassWordComplexityException 密码复杂度异常
     */
    int updatePassWord(StarSysUserInfo record) throws PassWordComplexityException;

    /**
     * 批量修改密码的方法
     * @param record 需要修改密码的用户
     * @return 成功的个数
     * @throws PassWordComplexityException 密码复杂度异常
     */
    int updatePassWord(String password, Example example) throws PassWordComplexityException;

}
