package cn.ityun.web.test;

import cn.ityun.web.redis.StringOperator;
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
    @Test
    public void testGet() {
        String value = StringOperator.get("jedis");
        System.out.println(value);
    }
    @Test
    public void testSet() {
        String value = StringOperator.set("test", "java", 100L);
        System.out.println(value);
    }
}
