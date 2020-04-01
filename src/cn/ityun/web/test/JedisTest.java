package cn.ityun.web.test;

import cn.ityun.web.util.JedisUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class JedisTest {
    @Test
    public void test() {
        Jedis jedisResource = JedisUtils.getJedisResource();
        jedisResource.select(1);
        String ret = jedisResource.set("jedis-java", "java");
        System.out.println(ret);
        JedisUtils.close(jedisResource);
    }
}
