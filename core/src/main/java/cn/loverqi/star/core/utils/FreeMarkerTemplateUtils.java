package cn.loverqi.star.core.utils;

import java.io.IOException;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.NullCacheStorage;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

/**
 * 获取FreeMarker摸板文件的工具类
 * @author LoverQi
 * @date 2018年5月30日
 */
public class FreeMarkerTemplateUtils {

    private static final Configuration CONFIGURATION = new Configuration(Configuration.VERSION_2_3_22);

    static {
        CONFIGURATION.setTemplateLoader(new ClassTemplateLoader(FreeMarkerTemplateUtils.class, "/templates/model"));
        CONFIGURATION.setDefaultEncoding("UTF-8");
        CONFIGURATION.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        CONFIGURATION.setCacheStorage(NullCacheStorage.INSTANCE);
    }

    /**
     * 获取模板
     * @param 模板名
     * @return 获取到的模板对象
     * @throws IOException 模板不存在抛出IO异常
     */
    public static Template getTemplate(String templateName) throws IOException {
        try {
            return CONFIGURATION.getTemplate(templateName);
        } catch (IOException e) {
            throw e;
        }
    }

    /**
     * 释放摸板
     */
    public static void clearCache() {
        CONFIGURATION.clearTemplateCache();
    }

    private FreeMarkerTemplateUtils() throws ClassNotFoundException {
        throw new ClassNotFoundException();
    }
}