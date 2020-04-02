package cn.ityun.web.redis;

import cn.ityun.web.util.JedisUtils;
import redis.clients.jedis.Jedis;

import java.util.List;

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
    public static String set(String key, String value) {
        jedisSource = JedisUtils.getJedisResource();
        String ret = jedisSource.set(key, value);
        close();
        return ret;
    }

    /**
     * setnx 设置一条数据。仅仅不存在时设置
     * @param key
     * @param value
     * @return
     */
    public static long setnx(String key, String value) {
        jedisSource = JedisUtils.getJedisResource();
        Long ret = jedisSource.setnx(key, value);
        close();
        return ret;
    }

    /**
     * 批量设置
     * @param keysValues 格式："key1","value1" .......
     * @return
     */
    public static String mset(String... keysValues) {
        jedisSource = JedisUtils.getJedisResource();
        String ret = jedisSource.mset(keysValues);
        close();
        return ret;
    }

    /**
     * 批量获取
     * @param keys
     * @return
     */
    public static List<String> mget(String... keys) {
        jedisSource = JedisUtils.getJedisResource();
        List<String> list = jedisSource.mget(keys);
        close();
        return list;
    }

    /**
     * set 设置存活时间
     * @param key
     * @param time
     * @param value
     * @return
     */
    public static String setex(String key, int time, String value) {
        jedisSource = JedisUtils.getJedisResource();
        String setex = jedisSource.setex(key, time, value);
        return setex;
    }


    public static void close() {
        JedisUtils.close(jedisSource);
    }
}
