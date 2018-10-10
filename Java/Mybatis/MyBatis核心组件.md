# MyBatis核心组件

### 一、四大组件简介

| 名称                             | 说明                                                        |
| -------------------------------- | ----------------------------------------------------------- |
| SqlSessionFactoryBuilder(构造器) | 根据配置或者代码生成SqlSessionFactory。采用的是分布构建模式 |
| SqlSessionFactory(工厂接口)      | 它用来生成SqlSession。工厂模式                              |
| SqlSession(会话)                 | 可以发送sql执行，并且返回结果。也可以生成Mapper接口         |
| SQL Mapper(映射器)               | 由Java接口和XML(或者注解)组成，定义映射规则。发送Sql执行    |

### 二、工厂接口SqlSessionFactory

* 它是由SqlSessionFactoryBuilder生成的。而该builder使用==org.apache.ibatis.session.Configuration==作为引导。使用builder模式。该Configuration包含整个Mybatis的上下文配置信息。
* SqlSessionFactory作为一个接口它有两个实现类：==SqlSessionManager==，==DefaultSqlSessionFactory==。前者使用在多线程的环境中，但它的具体实现依靠后者。

![1539048811517](C:\Users\pcq\AppData\Roaming\Typora\typora-user-images\1539048811517.png)

##### 1.使用XML构建SqlSessionFactory

* 基本配置形式

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <typeAliases><!--别名-->
        <typeAlias alias="" type=""/>
    </typeAliases>
    <!--数据库环境-->
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"></transactionManager>
            <dataSource type="POOLED">
                <property name="driver" value=""/>
                <property name="url" value=""/>
                <property name="username" value=""/>
                <property name="password" value=""/>
            </dataSource>
        </environment>
    </environments>
    <!--映射文件-->
    <mappers>
        <mapper resource=""/>
    </mappers>
</configuration>
```

除了第1行xml文件基本声明和第2行第3行的文档类型说明和校验说明之外，最外层根元素为configuration。其中包含了三个子元素，==typeAliases==，==environments==，==mappers==。

* typeAliases

  给类型定义别名。type属性值填入类的全路径名，例如：“com.pcq.entity.User"。alias属性值为取的别名，例如：”User“。这样Mybatis上下文中就可以使用别名来代替全名。

* environments

  描述的是数据库环境信息。其中==transactionManager==元素描述事务管理的方式。这里采用的是MyBatis的JDBC管理器方式。==dataSource==元素描述数据库的链接信息。==type=“POOLED”==是使用MyBatis内部提供的连接池方式。

* mappers

  描述的是映射信息。这里resource填入的是定义映射规则的xml文件。也就是定义执行sql语句和返回结果集的文件引入。

在配置信息填写完整之后。我们可以通过代码来获得SqlSessionFactory。关于MyBatis项目使用的包我是在github上下载的：<https://github.com/mybatis/mybatis-3/releases> 我下载的是3.4.1版本，下载后解压，项目中只需要依赖==mybatis-3.4.1.jar==即可。

```java
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
```

##### 2.使用代码构建SqlSessionFactiory

代码里所做的事情和配置文件几乎一模一样。相比较而言，当然是使用配置文件会更好维护。真正的项目中，也都会使用配置文件而不是代码。

```java
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
```

