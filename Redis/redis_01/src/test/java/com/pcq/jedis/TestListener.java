package com.pcq.jedis;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class TestListener {
    ApplicationContext ac;
    @Before
    public void init() {
        ac = new ClassPathXmlApplicationContext("application-context.xml");
    }

    @Test
    public void testListener() {
        RedisTemplate redisTemplate = ac.getBean(RedisTemplate.class);
        String channel = "chat";
        redisTemplate.convertAndSend(channel, "Let it go!");
    }
}
