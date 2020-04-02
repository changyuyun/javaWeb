package cn.ityun.web.test;

import cn.ityun.web.redis.HashOperator;
import cn.ityun.web.redis.ListOperator;
import cn.ityun.web.redis.SetOperator;
import cn.ityun.web.redis.StringOperator;
import cn.ityun.web.util.JedisUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.*;

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
    @Test
    public void testSetSet() {
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("c");
        set.add("b");
        long size = SetOperator.setSet("set", set);
        System.out.println(size);
    }
    @Test
    public void testGetSet() {
        Set<String> set = SetOperator.getSet("set");
        for (String s : set) {
            System.out.println(s);
        }
        System.out.println(set);
    }
    @Test
    public void testHset() {
        long hash = HashOperator.hset("hash", "1", "1s");
        System.out.println(hash);
    }
    @Test
    public void tsetHmset() {
        Map<String, String> map = new HashMap<>();
        map.put("2", "2s");
        map.put("3", "3s");
        map.put("4", "4s");
        String hash = HashOperator.hmset("hash", map);
        System.out.println(hash);
    }
    @Test
    public void testHgetAll() {
        Map<String, String> hash = HashOperator.hgetAll("hash");
        Set<Map.Entry<String, String>> entries = hash.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey()+"-----"+entry.getValue());
        }
        System.out.println(hash);
    }
}
