/**
 * 
 * @author LoverQi
 * @date 2018年11月17日
 */
package cn.loverqi.star.core.redies;

import java.io.Serializable;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Service;

/**
 * 缓存处理类
 * @author LoverQi
 * @date 2018年11月17日
 */
@Service
public class RedisManager {

    private static final Logger logger = LoggerFactory.getLogger(RedisManager.class);
    private static final Long SUCCESS = 1L;

    @Autowired
    private RedisTemplate<Serializable, Serializable> redisTemplate;


    public void set(final String key, final Serializable value, final long expire) {
        redisTemplate.opsForValue().set(key, value, expire, TimeUnit.MINUTES);
    }

    public boolean lock(String key, String value, int expireTime) {
        boolean ret = false;
        try {
            String script = "if redis.call('setNx',KEYS[1],ARGV[1]) then if redis.call('get',KEYS[1])==ARGV[1] then return redis.call('expire',KEYS[1],ARGV[2]) else return 0 end end";

            RedisScript<String> redisScript = new DefaultRedisScript<>(script, String.class);

            Object result = redisTemplate.execute(redisScript, Collections.singletonList(key), value, expireTime);

            if (SUCCESS.equals(result)) {
                return true;
            }

        } catch (Exception e) {
            logger.error("lock error!", e);
        }
        return ret;
    }

    public boolean unLock(String key, String value) {

        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";

        RedisScript<String> redisScript = new DefaultRedisScript<>(script, String.class);

        Object result = redisTemplate.execute(redisScript, Collections.singletonList(key), value);
        if (SUCCESS.equals(result)) {
            return true;
        }

        return false;
    }


    public Object get(final String key) {
        return redisTemplate.opsForValue().get(key);
    }


    public boolean flushDB() {
        return redisTemplate.execute((RedisCallback<Boolean>) connection -> {
            connection.flushDb();
            return true;
        });
    }

    public int del(final String... keys) {
        int count = 0;
        for (String key : keys) {
            Boolean delete = redisTemplate.opsForValue().getOperations().delete(key);
            if (delete) {
                count++;
            }
        }
        return count;
    }
}