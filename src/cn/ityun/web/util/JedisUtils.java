package cn.ityun.web.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JedisUtils {
    private static JedisPool jedisPool;
    private static int maxTotal;
    private static int maxWaitMillis;
    private static String host;
    private static int port;
    private static int timeout;
    private static String auth;

    static {
        Properties properties = new Properties();
        InputStream is = JedisUtils.class.getClassLoader().getResourceAsStream("cn/ityun/web/jedis.properties");
        try {
            properties.load(is);
            host = properties.getProperty("host");
            port = Integer.parseInt(properties.getProperty("port"));
            timeout = Integer.parseInt(properties.getProperty("timeout"));
            auth = properties.getProperty("auth");
            if (auth != null || "".equals(auth)){
                auth = null;
            }
            maxWaitMillis = Integer.parseInt(properties.getProperty("maxWaitMillis"));
            maxTotal = Integer.parseInt(properties.getProperty("maxTotal"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, auth);
    }

    /**
     * 获取jedis
     * @return
     */
    public static Jedis getJedisResource() {
        return jedisPool.getResource();
    }

    public static void close(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
}
