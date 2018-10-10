package com.pcq.main;

import com.pcq.entity.Student;
import com.pcq.mapper.StudentMapper;
import com.pcq.mapper.StudentMapper2;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class Main {


    private SqlSession sqlSession = null;
    @Before
    public void init() {
        SqlSessionFactory sqlSessionFactory = null;
        InputStream inputStream = null;
        String resource = "mybatis_config.xml";
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void testMybatis() {
        SqlSessionFactory sqlSessionFactory = null;
        InputStream inputStream = null;
        String resource = "mybatis_config.xml";
        SqlSession sqlSession = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            System.out.println(inputStream);
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            sqlSessionFactory = builder.build(inputStream);
            System.out.println(sqlSessionFactory);
            sqlSession = sqlSessionFactory.openSession();
            Student student = sqlSession.selectOne("com.pcq.mapper.StudentMapper.findStudentById", "20081101");
            System.out.println(student.getsName());
            sqlSession.commit();
        } catch (IOException e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            if(sqlSession != null) {
                sqlSession.close();
            }
        }
    }



    @Test
    /**
     * 使用代码获得SqlSessionFactory
     */
    public void getSqlSessionFactory() {
        //数据库连接池信息
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://106.12.6.95:3306/pcq_test");
        dataSource.setUsername("root");
        dataSource.setPassword("Pcq@1234");
        dataSource.setDefaultAutoCommit(false);

        //采用JDBC管理事务
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);

        //创建配置对象
        Configuration configuration = new Configuration(environment);

        //注册一个上下文别名
        configuration.getTypeAliasRegistry().registerAlias("student", Student.class);

        //加入映射器
        configuration.addMapper(StudentMapper.class);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        System.out.println(sqlSessionFactory);
    }
    @Test
    public void testFindStudentById() {
        String id = "20081101";
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = studentMapper.findStudentById(id);
        System.out.println("sId:" + student.getsId() + ",sName:" + student.getsName() + ",sAge:" + student.getsAge());
    }

    @Test
    public void testAnotation() {
        String id = "20081101";
        StudentMapper2 studentMapper2 = sqlSession.getMapper(StudentMapper2.class);
        Student student = studentMapper2.findStudentById(id);
        System.out.println("sId:" + student.getsId() + ",sName:" + student.getsName() + ",sAge:" + student.getsAge());
    }
    @After
    public void closeSession() {
        if(sqlSession != null) {
            sqlSession.close();
        }
    }
}
