package com.pcq.main;

import com.pcq.entity.Student;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    @Test
    public void testMybatis() {
        SqlSessionFactory sqlSessionFactory = null;
        InputStream inputStream = null;
        String resource = "mybatis_config.xml";
        try {
            inputStream = Resources.getResourceAsStream(resource);
            System.out.println(inputStream);
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            sqlSessionFactory = builder.build(inputStream);
            System.out.println(sqlSessionFactory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void getSqlSessionFactory() {
        //数据库连接池信息
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver("com.mysql.jdbc.Driver");
        dataSource.setUrl("106.12.6.95:3306/pcq_test");
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
        //configuration.addMapper(StudentMapper.class);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        System.out.println(sqlSessionFactory);
    }
}
