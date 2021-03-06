package cn.loverqi.star.core.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.loverqi.star.core.bean.ResponseData;
import cn.loverqi.star.core.bean.SysCofigBean;
import cn.loverqi.star.core.domain.StarSysConfig;
import cn.loverqi.star.core.domain.StarSysMenu;
import cn.loverqi.star.core.domain.StarSysUserInfo;
import cn.loverqi.star.core.mapper.StarSysPrivMapper;
import cn.loverqi.star.core.mybaties.example.Example;
import cn.loverqi.star.core.redies.CacheKey;
import cn.loverqi.star.core.redies.RedisManager;
import cn.loverqi.star.core.security.manager.DynamicInvocationSecurityMetadataSource;
import cn.loverqi.star.core.security.util.SecurityUtil;
import cn.loverqi.star.core.service.StarSysConfigService;
import cn.loverqi.star.core.service.StarSysMenuService;
import cn.loverqi.star.core.utils.SystemConfiguration;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.minidev.json.JSONUtil;

/**
 * 验证码的获取
 * @author LoverQi
 * @date 2018年3月28日
 */
@Controller
@Api(tags = "刷新页面")
@RequestMapping("/refresh")
public class RefreshController {

    @Autowired
    private DynamicInvocationSecurityMetadataSource securityMetadataSource;
    @Autowired
    private StarSysConfigService starSysConfigService;
    @Autowired
    private StarSysMenuService starSysMenuService;
    @Autowired
    private StarSysPrivMapper starSysPrivMapper;
    @Autowired
    private RedisManager redisManager;
    @Autowired
    private SessionRegistry sessionRegistry;

    @RequestMapping(value = { "/", "/refresh.html" }, method = RequestMethod.GET)
    public String refreshPage(HttpSession session) {
        return "refresh";
    }

    @ApiOperation(value = "刷新系统参数", notes = "刷新系统参数，code为0是成功")
    @RequestMapping(value = "/refresh.do", method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody ResponseData<Integer> refresh(Boolean menu, Boolean config, Boolean jurisdictionSys,
            Boolean jurisdictionUser, HttpSession session, HttpServletRequest request) {

        ResponseData<Integer> responseDate = new ResponseData<Integer>();
        int count = 0;
        //更新系统目录
        if (menu != null && menu) {
            List<StarSysMenu> starSysMenus = starSysMenuService
                    .selectStarSysMenuByPriv(SecurityUtil.getUserAuthorities());
            session.setAttribute("menus", starSysMenus);
            count++;
        }

        //更新系统参数
        if (config != null && config) {
            List<StarSysConfig> starSysConfigs = null;
            Object object = redisManager.get(CacheKey.SYS_CONFIG.getKey());
            if (object != null && object instanceof SysCofigBean) {
                starSysConfigs = ((SysCofigBean) object).getList();
            }else {
                Example example = new Example();
                example.createCriteria().andFieldEqualTo("enable", true);
                starSysConfigs = starSysConfigService.selectByExample(example);
                redisManager.set(CacheKey.SYS_CONFIG.getKey(), new SysCofigBean(starSysConfigs), CacheKey.SYS_CONFIG.getTtl());
            }
            SystemConfiguration.setConfig(starSysConfigs);
            count++;
        }

        //更新系统权限
        if (jurisdictionSys != null && jurisdictionSys) {
            securityMetadataSource.loadResourceDefine();
            count++;
        }

        //更新用户权限
        if (jurisdictionUser != null && jurisdictionUser) {

            Authentication authentication = SecurityUtil.getAuthentication();

            List<Object> allPrincipals = sessionRegistry.getAllPrincipals();
            for (Object object : allPrincipals) {
                StarSysUserInfo userInfo = (StarSysUserInfo) object;
                System.err.println(userInfo.getName());

                List<String> privs = starSysPrivMapper.selectPrivByRoleId(userInfo.getRoleId());
                userInfo.addAuthoritiesGlSysPrivs(privs);

                // 重新new一个token，因为Authentication中的权限是不可变的.  
                UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(userInfo,
                        authentication.getCredentials(), userInfo.getAuthorities());
                result.setDetails(authentication.getDetails());
                SecurityContextHolder.getContext().setAuthentication(result);
            }

            count++;
        }

        responseDate.setData(count);
        return responseDate;
    }

}
