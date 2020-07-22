package com.pcq.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;

import java.util.List;

public class JedisTest {

    @Test
    public void basicTest() {
        Jedis jedis = new Jedis("localhost", 6379);//地址端口
        int i = 0;
        try {
            long start = System.currentTimeMillis();
            while (true) {
                long end = System.currentTimeMillis();
                if(end - start >= 10) {
                    break;
                }
                i++;
                jedis.set("test" + i, i + "");
            }
        } finally {
            jedis.close();
        }
        System.out.println("redis每秒操作：" + i + "次");
    }

    @Test
    public void testJedisPool() {
        JedisPoolConfig poolCfg = new JedisPoolConfig();//配置对象
        poolCfg.setMaxIdle(50);//最大空闲数
        poolCfg.setMaxTotal(100);//最大连接数
        poolCfg.setMaxWaitMillis(50000);//最大等待毫秒数
        JedisPool jp = new JedisPool(poolCfg, "localhost");//通过配置对象创建连接池
        Jedis jedis = jp.getResource();//从连接池获取链接
        int i = 0;
        try {
            long start = System.currentTimeMillis();
            while (true) {
                long end = System.currentTimeMillis();
                if(end - start >= 1000) {
                    break;
                }
                i++;
                jedis.set("test" + i, i + "");
            }
        } finally {
            jedis.close();
        }
        System.out.println("redis每秒操作：" + i + "次");
    }

    @Test
    public void testPipelined() {
        JedisPoolConfig poolCfg = new JedisPoolConfig();//配置对象
        poolCfg.setMaxIdle(50);//最大空闲数
        poolCfg.setMaxTotal(100);//最大连接数
        poolCfg.setMaxWaitMillis(50000);//最大等待毫秒数
        JedisPool jp = new JedisPool(poolCfg, "localhost");//通过配置对象创建连接池
        Jedis jedis = jp.getResource();//从连接池获取链接
        Pipeline pipeline = jedis.pipelined();//开启流水线
        long start = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++) {
            int j = i + 1;
            pipeline.set("key" + j, "value" + j);
            pipeline.get("key" + j);
        }
        List list = pipeline.syncAndReturnAll();
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "毫秒");
    }
}
