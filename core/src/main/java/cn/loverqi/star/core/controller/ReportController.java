package cn.loverqi.star.core.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.loverqi.star.core.bean.ResponsePageData;
import cn.loverqi.star.core.controller.param.QueryVo;
import cn.loverqi.star.core.domain.StarSysReport;
import cn.loverqi.star.core.domain.StarSysReportData;
import cn.loverqi.star.core.domain.StarSysReportQuery;
import cn.loverqi.star.core.mybaties.example.Example;
import cn.loverqi.star.core.service.StarSysReportDataService;
import cn.loverqi.star.core.service.StarSysReportQueryService;
import cn.loverqi.star.core.service.StarSysReportService;
import cn.loverqi.star.core.service.base.BaseMapService;
import cn.loverqi.star.core.utils.CollectionUtil;
import cn.loverqi.star.core.utils.PackageUtil;
import cn.loverqi.star.core.utils.ReportUtil;
import cn.loverqi.star.core.utils.StringUtil;
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
    private BaseMapService baseMapService;
    @Autowired
    private StarSysReportService starSysReportService;
    @Autowired
    private StarSysReportDataService starSysReportDataService;
    @Autowired
    private StarSysReportQueryService starSysReportQueryService;

    @RequestMapping(value = "/{reportName}_report.html", method = { RequestMethod.GET, RequestMethod.POST })
    public String createReport(@PathVariable String reportName, @ModelAttribute QueryVo query, Model model) {

        if (query == null) {
            query = new QueryVo();
        }

        Example example = new Example();
        example.createCriteria().andFieldEqualTo("name", reportName).andFieldEqualTo("enable", true);
        List<StarSysReport> reports = starSysReportService.selectByExample(example);

        StarSysReport report = null;
        if (CollectionUtil.isNotNull(reports)) {
            report = reports.get(0);
        }

        if (report != null) {
            //查询report的Datas
            Example reportExample = new Example();
            reportExample.createCriteria().andFieldEqualTo("enable", true).andFieldEqualTo("reportId", report.getId());
            List<StarSysReportData> reportDatas = starSysReportDataService.selectByExample(reportExample);
            List<StarSysReportQuery> reportQuerys = starSysReportQueryService.selectByExample(reportExample);

            String operationViewFunc = report.getOperationViewFunc();
            String operationEditFunc = report.getOperationEditFunc();
            String getOperationDeleteFunc = report.getOperationDeleteFunc();

            //封装需要展示的数据
            String className = PackageUtil.getClassName(report.getBeanClass());
            ResponsePageData<Map<String, Object>> values = null;
            if (StringUtil.isNotNull(className)) {
                Example valuesExample = new Example();
                Map<String, Object> params = query.getParams(); //前端传来的数据
                Map<String, String> queryMap = ReportUtil.getQueryMap(reportQuerys); //需要对比的条目
                for (String key : params.keySet()) {
                    Object value = params.get(key); //需要验证的值
                    if (value != null && StringUtil.isNotNull(value.toString())) {
                        String condition = queryMap.get(key);

                        if (condition != null) {
                            switch (condition) {
                            case "like":
                                valuesExample.createCriteria().andFieldLike(key, value);
                                break;
                            case "rlike":
                                valuesExample.createCriteria().andFieldRightLike(key, value);
                                break;
                            case "llike":
                                valuesExample.createCriteria().andFieldLeftLike(key, value);
                                break;
                            case "in":
                                valuesExample.createCriteria().andFieldIn(key, Arrays.asList((String[]) value));
                                break;
                            default:
                                valuesExample.createCriteria().andFieldCustom(key, condition, value);
                                break;
                            }
                        }
                    }
                }

                //获取查询页码并归1
                Integer page = query.getPage();
                query.setPage(1);

                values = baseMapService.selectByExampleWithRowbounds(className, valuesExample, page == null ? 1 : page,
                        report.getPageSize());
                for (Map<String, Object> map : values.getList()) {
                    map.put("operationViewFunc_star_", ReportUtil.fillFuncField(operationViewFunc, map));
                    map.put("operationEditFunc_star_", ReportUtil.fillFuncField(operationEditFunc, map));
                    map.put("operationDeleteFunc_star_", ReportUtil.fillFuncField(getOperationDeleteFunc, map));
                }
            }

            model.addAttribute("reportQuerys", ReportUtil.splitReportDatas(reportQuerys, 5));
            model.addAttribute("reportDatas", reportDatas);
            model.addAttribute("report", report);
            model.addAttribute("values", values);
            model.addAttribute("query", query);
        }

        return "report_model";
    }

}
