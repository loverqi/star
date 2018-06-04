package cn.loverqi.star.core.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.loverqi.star.core.domain.StarSysReport;
import cn.loverqi.star.core.mybaties.example.Example;
import cn.loverqi.star.core.service.StarSysReportService;
import cn.loverqi.star.core.service.base.BaseMapService;
import cn.loverqi.star.core.utils.CollectionUtil;
import io.swagger.annotations.Api;

/**
 * 验证码的获取
 * @author LoverQi
 * @date 2018年3月28日
 */
@Controller
@Api(tags = "报表管理")
@RequestMapping("report")
public class ReportController {

    @Autowired
    private StarSysReportService starSysReportService;
    @Autowired
    private BaseMapService baseMapService;

    @RequestMapping(value = "/{reportName}_report.html", method = RequestMethod.GET)
    public String addUser4(@PathVariable String reportName, Model model) {

        Example example = new Example();
        example.createCriteria().andFieldEqualTo("name", reportName);
        List<StarSysReport> reports = starSysReportService.selectByExample(example);

        StarSysReport report = null;
        if (CollectionUtil.isNotNull(reports)) {
            report = reports.get(0);
        }

        List<Map<String, String>> selectByExample = baseMapService.selectByExample(report.getBeanClass(), null);
        for (Map<String, String> map : selectByExample) {
            System.err.println(map);
        }

        return "error";
    }

}
