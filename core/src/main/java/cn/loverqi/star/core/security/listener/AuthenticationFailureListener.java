package cn.loverqi.star.core.security.listener;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

import cn.loverqi.star.core.domain.StarSysUserInfo;
import cn.loverqi.star.core.mapper.StarSysUserInfoMapper;
import cn.loverqi.star.core.mybaties.example.Example;
import cn.loverqi.star.core.utils.SystemConfiguration;

/** 
 * 登陆失败监听 
 * @author LoverQi
 * @date 2018年5月2日
*/

@Component
public class AuthenticationFailureListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    @Autowired
    private StarSysUserInfoMapper starSysUserInfoMapper;

    /*
     * 登陆失败后更新登陆失败的次数，并锁定账户
     * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
     */
    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent authenticationFailureBadCredentialsEvent) {
        String userName = authenticationFailureBadCredentialsEvent.getAuthentication().getPrincipal().toString();
        Example example = new Example();
        example.createCriteria().andFieldEqualTo("username", userName);
        List<StarSysUserInfo> userInfos = starSysUserInfoMapper.selectByExample(StarSysUserInfo.class, example);
        if (userInfos != null && userInfos.size() > 0) {
            StarSysUserInfo starSysUserInfo = userInfos.get(0);
            // 用户失败次数  
            int fails = starSysUserInfo.getErrorCount();
            fails++;

            // 系统配置失败次数  
            int pwdFailsCount = SystemConfiguration.getPwdFailsCount();

            //开启了登陆出错验证
            if (pwdFailsCount != 0) {

                // 超出失败次数，停用账户  
                starSysUserInfo.setErrorCount(fails);
                if (fails >= pwdFailsCount) {
                    starSysUserInfo.setIsUnlock(false);
                }

                starSysUserInfoMapper.updateByPrimaryKeySelective(starSysUserInfo);
            }
        }
    }
}
