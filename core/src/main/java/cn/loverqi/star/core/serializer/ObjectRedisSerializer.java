/**
 * 
 * @author LoverQi
 * @date 2018年11月17日
 */
package cn.loverqi.star.core.serializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

public class ObjectRedisSerializer implements RedisSerializer<Object> {
    private static final Logger logger = LoggerFactory.getLogger(ObjectRedisSerializer.class);

    /**
     * 定义序列化和反序列化转化类
     */
    private Converter<Object, byte[]> serializer = new SerializingConverter();
    private Converter<byte[], Object> deserializer = new DeserializingConverter();

    /**
     * 定义转换空字节数组
     */
    private static final byte[] EMPTY_ARRAY = new byte[0];

    @Override
    public byte[] serialize(Object obj) throws SerializationException {
        byte[] byteArray = null;
        if (null == obj) {
            logger.warn("Redis待序列化的对象为空.");
            byteArray = EMPTY_ARRAY;
        } else {
            try {
                byteArray = serializer.convert(obj);
            } catch (Exception e) {
                logger.error("Redis序列化对象失败.", e);
                byteArray = EMPTY_ARRAY;
            }
        }
        return byteArray;
    }

    @Override
    public Object deserialize(byte[] datas) throws SerializationException {
        Object obj = null;
        if ((null == datas) || (datas.length == 0)) {
            logger.warn("Redis待反序列化的对象为空.");
        } else {
            try {
                obj = deserializer.convert(datas);
            } catch (Exception e) {
                logger.error("Redis反序列化对象失败.", e);
            }
        }
        return obj;
    }
}