package cn.loverqi.star.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cn.loverqi.star.core.domain.StarSysUserInfo;
import cn.loverqi.star.core.exception.PassWordComplexityException;
import cn.loverqi.star.core.mapper.StarSysPrivMapper;
import cn.loverqi.star.core.mybaties.example.Example;
import cn.loverqi.star.core.service.StarSysUserInfoService;
import cn.loverqi.star.core.service.base.impl.BaseServiceImpl;
import cn.loverqi.star.core.utils.PasswordUtil;
import cn.loverqi.star.core.utils.StringUtil;
import cn.loverqi.star.core.utils.SystemConfiguration;

/**
 * 用户管理实现类
 * @author LoverQi
 * @date 2018年3月5日
 */
@Service
public class StarSysUserInfoServiceImpl extends BaseServiceImpl<StarSysUserInfo>
        implements StarSysUserInfoService, UserDetailsService {

    @Autowired
    private StarSysPrivMapper starSysPrivMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /*
     * 根据用户名加载用户的方法
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        StarSysUserInfo starSysUserInfo = null;
        Example example = new Example();

        example.createCriteria().andFieldEqualTo("username", username);
        List<StarSysUserInfo> userInfos = baseMapper.selectByExample(StarSysUserInfo.class, example);
        if (userInfos != null && userInfos.size() > 0) {
            starSysUserInfo = userInfos.get(0);

            Integer roleId = starSysUserInfo.getRoleId();

            //根据用户角色加载用户权限信息
            if (roleId != null) {
                List<String> privs = starSysPrivMapper.selectPrivByRoleId(roleId);
                starSysUserInfo.addAuthoritiesGlSysPrivs(privs);
            }
        } else {
            throw new UsernameNotFoundException("用户名不存在");
        }

        return starSysUserInfo;
    }

    @Override
    public int insert(StarSysUserInfo record) {
        record.setPassword(null);
        return super.insert(record);
    }

    @Override
    public int insertSelective(StarSysUserInfo record) {
        record.setPassword(null);
        return super.insertSelective(record);
    }

    @Override
    public int insertSelectiveWithGeneratedKeys(StarSysUserInfo record) {
        record.setPassword(null);
        return super.insertSelectiveWithGeneratedKeys(record);
    }

    @Override
    public int updateByPrimaryKey(StarSysUserInfo record) {
        record.setPassword(null);
        return super.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(StarSysUserInfo record) {
        record.setPassword(null);
        return super.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByExample(StarSysUserInfo record, Example example) {
        record.setPassword(null);
        return super.updateByExample(record, example);
    }

    @Override
    public int updateByExampleSelective(StarSysUserInfo record, Example example) {
        record.setPassword(null);
        return super.updateByExampleSelective(record, example);
    }

    @Override
    public int updatePassWord(StarSysUserInfo record) throws PassWordComplexityException {
        StarSysUserInfo starSysUserInfo = new StarSysUserInfo();
        starSysUserInfo.setId(record.getId());
        starSysUserInfo.setPassword(record.getPassword());

        return super.updateByPrimaryKeySelective(starSysUserInfo);
    }

    @Override
    public int updatePassWord(String password, Example example) throws PassWordComplexityException {
        StarSysUserInfo starSysUserInfo = new StarSysUserInfo();
        if (StringUtil.isNotNull(password)) {
            checkPassword(password);
            starSysUserInfo.setPassword(passwordEncoder.encode(password));
        }

        return super.updateByExampleSelective(starSysUserInfo, example);
    }

    @Override
    public int insertWithPassword(StarSysUserInfo record) throws PassWordComplexityException {
        String password = record.getPassword();
        if (StringUtil.isNotNull(password)) {
            checkPassword(password);
            record.setPassword(passwordEncoder.encode(password));
        }

        return super.insert(record);
    }

    @Override
    public int insertWithPasswordAndGeneratedKeys(StarSysUserInfo record) throws PassWordComplexityException {
        String password = record.getPassword();
        if (StringUtil.isNotNull(password)) {
            checkPassword(password);
            record.setPassword(passwordEncoder.encode(password));
        }

        return super.insertSelective(record);
    }

    @Override
    public int insertSelectiveWithPassword(StarSysUserInfo record) throws PassWordComplexityException {
        String password = record.getPassword();
        if (StringUtil.isNotNull(password)) {
            checkPassword(password);
            record.setPassword(passwordEncoder.encode(password));
        }

        return super.insertSelectiveWithGeneratedKeys(record);
    }

    @Override
    public int insertSelectiveWithPasswordAndGeneratedKeys(StarSysUserInfo record) throws PassWordComplexityException {
        String password = record.getPassword();
        if (StringUtil.isNotNull(password)) {
            checkPassword(password);
            record.setPassword(passwordEncoder.encode(password));
        }

        return super.insertSelectiveWithGeneratedKeys(record);
    }

    /**
     * 验证密码是否规范
     * @param password 需要验证的密码
     * @return 密码是否符合规范
     */
    private void checkPassword(String password) throws PassWordComplexityException {
        //验证密码长度
        if (!PasswordUtil.checkPasswordLength(password, SystemConfiguration.PASSWORD_LENGTH_MIN,
                SystemConfiguration.PASSWORD_LENGTH_MAX)) {
            throw new PassWordComplexityException("密码长度不符合规范");
        }

        //验证密码复杂度
        String passwordComplexity = SystemConfiguration.getPasswordComplexity();
        if (passwordComplexity != null && !PasswordUtil.checkPasswordComplexity(password, passwordComplexity)) {
            throw new PassWordComplexityException("密码复杂度不符合规范");
        }
    }

}
