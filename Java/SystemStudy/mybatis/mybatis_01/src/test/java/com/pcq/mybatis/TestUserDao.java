package com.pcq.mybatis;

import com.pcq.dao.UserDao;
import com.pcq.entity.User;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestUserDao {

    UserDao userDao;
    @Before
    public void init() {
        userDao = new UserDao();
    }

    @Test
    public void testFindUserById() throws IOException {
        User user = userDao.findUserById(1);
        System.out.println(user);
    }


    @Test
    public void testAddUser() throws IOException {
        User user = new User();
        user.setUsername("wangwu");
        user.setPassword("776672");
        int result = userDao.addUser(user);
        System.out.println(result);
    }

    @Test
    public void testUpdUser() throws IOException {
        User user = userDao.findUserById(1);
        if(null != user) {
            user.setPassword("xxxxxx");
            int result = userDao.updUser(user);
            System.out.println(result);
        }
    }

    @Test
    public void testDeleteUserById() throws IOException {
        int result = userDao.deleteUserById(3);
        System.out.println(result);
    }

    @Test
    public void testAddUsers() throws IOException {
        List<User> users = new ArrayList<User>();
        users.add(new User("zhouliu","4534534"));
        users.add(new User("wangwu","4330054"));
        int result = userDao.addUsers(users);
        System.out.println(result);
    }

    @Test
    public void testFindAll() throws IOException {
        List<User> users = userDao.findAll(2, 2);
        for(User user : users) {
            System.out.println(user);
        }
    }
}
