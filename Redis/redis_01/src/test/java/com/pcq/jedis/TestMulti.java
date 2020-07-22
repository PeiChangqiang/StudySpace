package com.pcq.jedis;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;

import java.util.List;

public class TestMulti {
    ApplicationContext ac;
    RedisTemplate redisTemplate;
    @Before
    public void init() {
        ac = new ClassPathXmlApplicationContext("application-context.xml");
        redisTemplate = ac.getBean(RedisTemplate.class);
    }

    @Test
    public void testMulti() {
        SessionCallback callback = new SessionCallback() {
            @Override
            public Object execute(RedisOperations ops) throws DataAccessException {
                ops.multi();//开启事务
                ops.boundValueOps("key1").set("value1");
                System.out.println(ops.boundValueOps("key1").get());//处于消息队列中未执行，所以输出为空
                List list = ops.exec();//list保存所有命令的执行结果
                String value = (String)redisTemplate.opsForValue().get("key1");
                return value;
            }
        } ;
        String value = (String)redisTemplate.execute(callback);
        System.out.println(value);
    }


    @Test
    public void testPipelined() {
        SessionCallback callback = new SessionCallback() {
            @Override
            public Object execute(RedisOperations ops) throws DataAccessException {
                for(int i = 0; i < 100000; i++) {
                    ops.boundValueOps("i").set(i);
                    ops.boundValueOps("i").get();
                }
                return null;
            }
        };
        long start = System.currentTimeMillis();
        List list = redisTemplate.executePipelined(callback);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }


}
