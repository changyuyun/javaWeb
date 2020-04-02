package cn.ityun.web.test;

import cn.ityun.web.redis.ListOperator;
import cn.ityun.web.redis.StringOperator;
import cn.ityun.web.util.JedisUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

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
        String value = StringOperator.set("test", "java");
        System.out.println(value);
    }
    @Test
    public void testSetnx() {
        Long ret = StringOperator.setnx("test_nx", "setnx");
        System.out.println(ret);
    }
    @Test
    public void testMset() {
        String mset = StringOperator.mset("mset_1", "1", "mset_2", "2");
        System.out.println(mset);
    }

    @Test
    public void testMget() {
        List<String> mget = StringOperator.mget("mset_1", "mset_2");
        for (String s : mget) {
            System.out.println(s);
        }
        System.out.println(mget);
    }
    @Test
    public void testSetex() {
        String setex = StringOperator.setex("key_setex", 10, "ex");
        System.out.println(setex);
    }
    @Test
    public void testList() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        long size = ListOperator.setList("list", list);
        System.out.println(size);
    }
    @Test
    public void testGetList() {
        List<String> list = ListOperator.getList("list");
        System.out.println(list);
    }
}
