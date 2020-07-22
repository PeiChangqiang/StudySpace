package mybatis;

import com.pcq.dao.UserDao;
import com.pcq.entity.User;
import com.pcq.mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestUserDao {

    SqlSession session;
    UserDao userDao;
    @Before
    public void init() {
        try {
            session = MyBatisUtil.getSqlSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
        userDao = session.getMapper(UserDao.class);
    }

    @Test
    public void testFindUserById() throws IOException {
        User user = userDao.findUserById(1);
        System.out.println(user);
    }


    @Test
    public void testAddUser() throws IOException {
        User user = new User();
        user.setUsername("公孙策");
        user.setPassword("000000");
        int result = userDao.addUser(user);
        System.out.println(result);
    }

    @Test
    public void testUpdUser() throws IOException {
        User user = userDao.findUserById(1);
        if(null != user) {
            user.setPassword("yyyyyy");
            int result = userDao.updUser(user);
            System.out.println(result);
        }
    }

    @Test
    public void testDeleteUserById() throws IOException {
        int result = userDao.deleteUserById(1);
        System.out.println(result);
    }

    @Test
    public void testAddUsers() throws IOException {
        List<User> users = new ArrayList<User>();
        users.add(new User("周瑜","4534534"));
        users.add(new User("诸葛亮","4330054"));
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

    @After
    public void destroy() {
      if(session != null) {
          session.commit();
          session.close();
      }
    }
}
