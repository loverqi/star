package cn.loverqi.star.core.redies;

/**
 * 
 * @author LoverQi
 * @date 2018年11月17日
 */
public enum CacheKey {
    /**
     * 系统配置缓存
     */
    SYS_CONFIG("SYSTEM_CONFIGURATION_", 60 * 5);

    private String key;
    private Integer ttl;

    private CacheKey() {
    }

    private CacheKey(String key, Integer ttl) {
        this.key = key;
        this.ttl = ttl;
    }

    public String getKey() {
        return key;
    }

    public Integer getTtl() {
        return ttl;
    }
}
