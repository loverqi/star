package cn.loverqi.star.core.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.loverqi.star.core.bean.ResponseData;
import cn.loverqi.star.core.domain.StarSysConfig;
import cn.loverqi.star.core.domain.StarSysMenu;
import cn.loverqi.star.core.mybaties.example.Example;
import cn.loverqi.star.core.security.util.SecurityUtil;
import cn.loverqi.star.core.service.StarSysConfigService;
import cn.loverqi.star.core.service.StarSysMenuService;
import cn.loverqi.star.core.utils.SystemConfiguration;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
    private StarSysConfigService starSysConfigService;
    @Autowired
    private StarSysMenuService starSysMenuService;

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
            Example example = new Example();
            example.createCriteria().andFieldEqualTo("enable", true);
            List<StarSysConfig> starSysConfigs = starSysConfigService.selectByExample(example);
            SystemConfiguration.setConfig(starSysConfigs);
            ServletContext servletContext = request.getServletContext();
            servletContext.setAttribute("config", SystemConfiguration.getConfigs());
            count++;
        }

        //更新系统权限
        if (jurisdictionSys != null && jurisdictionSys) { //暂时未提供
            count++;
        }
        //更新用户权限
        if (jurisdictionUser != null && jurisdictionUser) { //暂时未提供
            count++;
        }

        responseDate.setData(count);
        return responseDate;
    }

}
