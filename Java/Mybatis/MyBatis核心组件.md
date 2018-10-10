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
        <mapper resource="StudentMapper.xml"/>
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
    //configuration.addMapper(StudentMapper.class);

    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    System.out.println(sqlSessionFactory);
}
```

### 三、SqlSession

##### 1.简介

* SqlSession是MyBatis的核心接口。它有两个实现类：==DefaultSqlSession==，==SqlSessionManager==。其中SqlSessionManager在多线程环境下使用。它相当于JDBC中的Connection。代表连接资源的启用。

##### 2.三个作用

* 获取Mapper接口
* 发送SQL给数据库
* 控制数据库事务

~~~java
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
            sqlSession = sqlSessionFactory.openSession();//创建sqlSession
            Student student = sqlSession.selectOne("com.pcq.mapper.StudentMapper.findStudentById", "20081101");
            sqlSession.commit();//之后提交
        } catch (IOException e) {
            sqlSession.rollback();//发生异常回滚
            e.printStackTrace();
        } finally {
            if(sqlSession != null) {
                sqlSession.close();//最后关闭会话连接
            }
        }
~~~

### 四、映射器Mapper

##### 1.简介

最重要最复杂的组件。由==接口==和对应的==xml文件（或者注解）==组成。它主要配置以下内容：

* 描述映射规则
* 提供SQL语句，并且可以配置SQL参数类型、返回类型、缓存刷新等。
* 配置缓存
* 提供动态SQL

简单的说，映射器的主要作用是将SQL查询到的结果封装到一个POJO中，或者将POJO的数据插入或者更新到数据库中，并定义和缓存相关的内容。

##### 2.使用XML实现映射器

* 实体类pojo

```java
package com.pcq.entity;

public class Student {
    private String sId;
    private String sName;
    private Integer sAge;
    private String sSes;

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Integer getsAge() {
        return sAge;
    }

    public void setsAge(Integer sAge) {
        this.sAge = sAge;
    }

    public String getsSes() {
        return sSes;
    }

    public void setsSes(String sSes) {
        this.sSes = sSes;
    }
}

```

* 接口

```java
public interface StudentMapper {
    Student findStudentById(String sId);
}
```

* xml配置文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.pcq.mapper.StudentMapper">
    <select id="findStudentById" parameterType="string" resultType="student">
        SELECT sId,sName,sAge,sSex FROM student WHERE sId = #{id}
    </select>
</mapper>
```

接口和xml配置文件完成了映射器的定义。在xml中，namespace对应的就是接口的路径名。select元素表明这是个查询语句，id标识这条sql，和接口中的方法名保持一直。parameterType表明传进的参数类型，resultType表明返回的类型是student。这里的student用的是别名，而别名是在构建SqlSessionFactory的配置文件中定义的。sql语句中的==#{id}==是代表执行时传进去的参数。

* 使用映射器执行sql语句

```java
@Test
public void testFindStudentById() {
    String id = "20081101";
    StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);//通过接口类型获得studentMapper映射器
    Student student = studentMapper.findStudentById(id);//实际上执行了xml文件中配置的sql语句。
    System.out.println("sId:" + student.getsId() + ",sName:" + student.getsName() + ",sAge:" + student.getsAge());
}
```

##### 3.注解实现映射器

```java
public interface StudentMapper2 {
    @Select("SELECT sId,sName,sAge,sSex FROM student WHERE sId = #{id}")//该注解可以为该接口注入sql语句，这样调用该接口时即执行该语句
    Student findStudentById(String sId);
}

//使用注解方式的映射器执行语句
@Test
public void testAnotation() {
    String id = "20081101";
    StudentMapper2 studentMapper2 = sqlSession.getMapper(StudentMapper2.class);
    Student student = studentMapper2.findStudentById(id);
    System.out.println("sId:" + student.getsId() + ",sName:" + student.getsName() + ",sAge:" + student.getsAge());
}

```

<font color="red">使用该注解时需要在mybatis_config.xml配置文件中的mappers元素下进行注册</font>

```xml
<mappers>
        <mapper resource="StudentMapper.xml"/>
    <!--此处将注解形式的映射器注册到了mybatis的上下文中-->
        <mapper class="com.pcq.mapper.StudentMapper2"/>
    </mappers>
```

##### 4.映射器两种实现方式对比

* 如果同时使用两种方式，xml则会覆盖注解方式。
* 实际企业项目中sql语句中会非常复杂，如果通过注解方式写sql语句，则降低了可读性，不利于维护。
* 当使用动态sql时，则xml文件方式会更方便
* xml文件可以互相引入，而注解不可以

<font color='red'>综上所述，使用xml方式会更加灵活方便，mybatis官方也推荐xml方式。</font>

##### 5.SqlSession发送sql和Mapper发送sql对比

```java
//如果使用sqlSession发送sql语句，则是这样
Student student = sqlSession.selectOne("com.pcq.mapper.StudentMapper.findStudentById", "20081101");
//如果是mapper，则
Student student = studentMapper2.findStudentById("20081101");
```

* 显然mapper更简便，而sqlsession需要提供一个id。
* 而且第二种会在编译器会在编译时期校验，而sqlsession只有在运行时才知道是否有问题

<font color='red'>综上所述，使用mapper更好。</font>

