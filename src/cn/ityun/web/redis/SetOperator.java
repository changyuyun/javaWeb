package cn.ityun.web.redis;

import cn.ityun.web.util.JedisUtils;
import redis.clients.jedis.Jedis;

import java.util.HashSet;
import java.util.Set;

/**
 * redis 操作 set
 */
public class SetOperator {
    private static Jedis jedisSource = JedisUtils.getJedisResource();

    /**
     * set类型的数据
     * @param key
     * @param set
     * @return
     */
    public static long setSet(String key, Set<String> set) {
        for (String item: set) {
            jedisSource.sadd(key, item);
        }
        Set<String> smembers = jedisSource.smembers(key);
        close();
        return smembers.size();
    }

    /**
     * 取出set类型的数据
     * @param key
     * @return
     */
    public static Set<String> getSet(String key) {
        Set<String> smembers = jedisSource.smembers(key);
        close();
        return smembers;
    }
    public static void close() {
        JedisUtils.close(jedisSource);
    }
}
