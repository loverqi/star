package cn.loverqi.star.core.service.impl;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cn.loverqi.star.core.domain.StarSysUserInfo;
import cn.loverqi.star.core.mybaties.example.Example;
import cn.loverqi.star.core.service.StarSysUserInfoService;
import cn.loverqi.star.core.service.base.impl.BaseServiceImpl;

/**
 * 用户
 * @author LoverQi
 * @date 2018年3月5日
 */
@Service
public class StarSysUserInfoServiceImpl extends BaseServiceImpl<StarSysUserInfo> implements StarSysUserInfoService, UserDetailsService {

    /*
     * 根据用户名加载用户的方法
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Example example = new Example();

        example.createCriteria().andFieldEqualTo("username", username);
        List<StarSysUserInfo> userInfos = baseMapper.selectByExample(StarSysUserInfo.class, example);
        if (userInfos == null || userInfos.size() == 0) {
            throw new UsernameNotFoundException("用户不存在");
        }

        return userInfos.get(0);
    }

}
