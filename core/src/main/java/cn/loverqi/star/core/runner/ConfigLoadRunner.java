package cn.loverqi.star.core.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import cn.loverqi.star.core.bean.SysCofigBean;
import cn.loverqi.star.core.domain.StarSysConfig;
import cn.loverqi.star.core.mybaties.example.Example;
import cn.loverqi.star.core.redies.CacheKey;
import cn.loverqi.star.core.redies.RedisManager;
import cn.loverqi.star.core.service.StarSysConfigService;
import cn.loverqi.star.core.utils.SystemConfiguration;

/**
 * 系统启动时从数据库加载配置文件
 * @author LoverQi
 * @date 2018年5月4日
 */
@Order(1)
@Component
public class ConfigLoadRunner implements CommandLineRunner {

    @Autowired
    private StarSysConfigService starSysConfigService;
    
    @Autowired
    private RedisManager redisManager;

    /*
     * 启动时执行，从数据库加载文件
     * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
     */
    @Override
    public void run(String... args) throws Exception {
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
    }

}
