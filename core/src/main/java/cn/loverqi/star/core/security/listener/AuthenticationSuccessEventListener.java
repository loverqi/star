package cn.loverqi.star.core.security.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import cn.loverqi.star.core.domain.StarSysUserInfo;
import cn.loverqi.star.core.mapper.StarSysUserInfoMapper;

/** 
 * 登陆成功监听 
 * @author LoverQi
 * @date 2018年5月2日
*/
@Component
public class AuthenticationSuccessEventListener implements ApplicationListener<AuthenticationSuccessEvent> {

    @Autowired
    private StarSysUserInfoMapper starSysUserInfoMapper;

    /*
     * 登陆成功后将登陆成功次数归0
     * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
     */
    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent authenticationSuccessEvent) {
        StarSysUserInfo starSysUserInfo = (StarSysUserInfo) authenticationSuccessEvent.getAuthentication()
                .getPrincipal();
        if (starSysUserInfo.getErrorCount() > 0) {
            starSysUserInfo.setErrorCount(0);
            starSysUserInfoMapper.updateByPrimaryKeySelective(starSysUserInfo);
        }
    }

}
