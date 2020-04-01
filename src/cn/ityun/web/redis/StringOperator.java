package cn.ityun.web.redis;

import cn.ityun.web.util.JedisUtils;
import redis.clients.jedis.Jedis;

/**
 * 操作redis中的string
 */
public class StringOperator {
    private static Jedis jedisSource;

    /**
     * 根据key 获取string
     * @param key
     * @return
     */
    public static String get(String key) {
        jedisSource = JedisUtils.getJedisResource();
        String value = jedisSource.get(key);
        close();
        return value;
    }

    /**
     * set 设置一条数据
     * @param key
     * @param value
     * @return
     */
    public static String set(String key, String value, Long expired) {
        jedisSource = JedisUtils.getJedisResource();
        String ret = jedisSource.set(key, value, "NX", "EX", expired);
        close();
        return ret;
    }


    public static void close() {
        JedisUtils.close(jedisSource);
    }
}
