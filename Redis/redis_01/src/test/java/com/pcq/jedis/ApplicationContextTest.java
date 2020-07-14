package com.pcq.jedis;

import com.pcq.entity.Role;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;

public class ApplicationContextTest {
    ApplicationContext ac;

    @Before
    public void init() {
        ac = new ClassPathXmlApplicationContext("application-context.xml");
    }
    @Test
    public void testContext() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("application-context.xml");
        System.out.println(ac);
    }

    @Test
    public void testRedisTemplate() {
        RedisTemplate rt = ac.getBean(RedisTemplate.class);
        Role role1 = new Role();
        role1.setId(1l);
        role1.setRoleName("经理");
        role1.setNote("note");
        rt.opsForValue().set("role_1", role1);
        Role role2 = (Role)rt.opsForValue().get("role_1");
        System.out.println(role2);
    }

    @Test
    public void testSeesionCallback() {
        RedisTemplate rt = ac.getBean(RedisTemplate.class);
        Role role1 = new Role();
        role1.setId(1l);
        role1.setRoleName("经理");
        role1.setNote("note");
        rt.boundValueOps("role1").set(role1);
        Role role2 = (Role)rt.boundValueOps("role1").get();
        System.out.println(role2);
    }
}
