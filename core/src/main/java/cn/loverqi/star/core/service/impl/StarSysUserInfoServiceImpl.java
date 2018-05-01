package cn.loverqi.star.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cn.loverqi.star.core.domain.StarSysUserInfo;
import cn.loverqi.star.core.mapper.StarSysPrivMapper;
import cn.loverqi.star.core.mybaties.example.Example;
import cn.loverqi.star.core.service.StarSysUserInfoService;
import cn.loverqi.star.core.service.base.impl.BaseServiceImpl;

/**
 * 用户
 * @author LoverQi
 * @date 2018年3月5日
 */
@Service
public class StarSysUserInfoServiceImpl extends BaseServiceImpl<StarSysUserInfo>
        implements StarSysUserInfoService, UserDetailsService {
    
    @Autowired
    private StarSysPrivMapper starSysPrivMapper;
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

            //查询用户的角色信息，并返回存入user中
            if (roleId != null) {
                List<String> privs = starSysPrivMapper.selectPrivByRoleId(roleId);
                starSysUserInfo.addAuthoritiesGlSysPrivs(privs);
            }
        } else {
            throw new UsernameNotFoundException("用户不存在");
        }

        return starSysUserInfo;
    }

}
