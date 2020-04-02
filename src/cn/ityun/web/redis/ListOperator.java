package cn.ityun.web.redis;

import cn.ityun.web.util.JedisUtils;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

/**
 * 操作redis中的list
 */
public class ListOperator {
    private static Jedis jedisSource;

    /**
     * 设置列表
     * @param key
     * @param list
     * @return
     */
    public static long setList(String key, List<String> list) {
        jedisSource = JedisUtils.getJedisResource();
        long size = 0L;
        for (String item : list) {
            size = jedisSource.lpush(key, item);
        }
        close();
        return size;
    }

    /**
     * 获取列表
     * @param key
     * @return
     */
    public static List<String> getList(String key) {
        jedisSource = JedisUtils.getJedisResource();
        List<String> list = new ArrayList<>();
        list = jedisSource.lrange(key, 0, -1);
        close();
        return list;
    }

    public static void close() {
        JedisUtils.close(jedisSource);
    }
}
