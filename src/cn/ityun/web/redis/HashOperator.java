package cn.ityun.web.redis;

import cn.ityun.web.util.JedisUtils;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * redis操作hash
 */
public class HashOperator {
    private static Jedis jedisSource = JedisUtils.getJedisResource();

    /**
     * 设置一条hash
     * @param key
     * @param field
     * @param value
     * @return
     */
    public static long hset(String key, String field, String value) {
        Long hset = jedisSource.hset(key, field, value);
        close();
        return hset;
    }

    /**
     * 批量设置
     * @param key
     * @param map
     * @return
     */
    public static String hmset(String key, Map<String, String> map) {
        String hmset = jedisSource.hmset(key, map);
        close();
        return hmset;
    }

    /**
     * 获取所有
     * @param key
     * @return
     */
    public static Map<String, String> hgetAll(String key) {
        Map<String, String> stringStringMap = jedisSource.hgetAll(key);
        close();
        return stringStringMap;
    }
    public static void close() {
        JedisUtils.close(jedisSource);
    }
}
