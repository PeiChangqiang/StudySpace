package com.pcq.dao;

import com.pcq.entity.User;
import com.pcq.mybatis.MyBatisUtil;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

import java.util.List;


public class UserDao {


    /**
     * 根据id返回用户
     * @param id
     * @return
     * @throws IOException
     */
    public User findUserById(Integer id) throws IOException {
        SqlSession session = MyBatisUtil.getSqlSession();
        User user = session.selectOne("com.pcq.entity.UserMapper.selectUser", id);
        session.close();
        return user;
    }

    public List<User> findAll(int currentPage, int pageSize) throws IOException {
        SqlSession session = MyBatisUtil.getSqlSession();
        RowBounds rowBounds = new RowBounds((currentPage - 1) * pageSize, pageSize);
        List<User> users = session.selectList("com.pcq.entity.UserMapper.findAll", null, rowBounds);
        session.close();
        return users;
    }

    public int addUser(User user) throws IOException {
        SqlSession session = MyBatisUtil.getSqlSession();
        int result = session.insert("com.pcq.entity.UserMapper.addUser", user);
        session.commit();//执行后需要提交事务
        session.close();
        return result;
    }

    public int addUsers(List<User> users) throws IOException {
        SqlSession session = MyBatisUtil.getSqlSession();
        int result = session.insert("com.pcq.entity.UserMapper.addUsers", users);
        session.commit();
        session.close();
        return result;
    }

    public int updUser(User user) throws IOException {
        SqlSession session = MyBatisUtil.getSqlSession();
        int result = session.update("com.pcq.entity.UserMapper.updUser", user);
        session.commit();
        session.close();
        return result;
    }

    public int deleteUserById(Integer id) throws IOException {
        SqlSession session = MyBatisUtil.getSqlSession();
        int result = session.delete("com.pcq.entity.UserMapper.deleteUserById", id);
        session.commit();
        session.close();
        return result;
    }
}
