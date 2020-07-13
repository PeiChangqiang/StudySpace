package com.pcq.mybatis;

import com.pcq.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.io.IOException;

public class TestMyBatisUtil {

    @Test
    public void testGetSqlSessionFactory() {
        try {
            SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
            System.out.println(sqlSessionFactory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetSqlSession() {
        try {
            SqlSession sqlSesion = MyBatisUtil.getSqlSession();
            System.out.println(sqlSesion);
            sqlSesion.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectUser() {
        try {
            SqlSession sqlSession = MyBatisUtil.getSqlSession();
            User user = sqlSession.selectOne("com.pcq.entity.UserMapper.selectUser", 1);
            System.out.println(user);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
