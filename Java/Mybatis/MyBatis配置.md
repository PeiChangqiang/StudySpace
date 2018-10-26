# MyBatis配置

### 一、概述

##### 1.mybatis配置项的所有元素

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<configuration>
	<properties/><!--属性-->
    <settings/><!--设置-->
    <typeAliases/><!--类型命名-->
    <typeHandlers/><!--类型处理器-->
    <objectFactory/><!--对象工厂-->
    <plugins/><!--插件-->
    <environments><!--环境配置-->
    	<environment><!--环境变量-->
        	<transactionManager/><!--事务管理器-->
            <dataSource/><!--数据源-->
        </environment>
    </environments>
    <databaseIdProvider/><!--数据库厂商标识-->
    <mappers/><!--映射器-->
</configuration>
```

* <font color="red">这些配置项的顺序不能够颠倒，否则启动即报错。其中对象工厂和数据库厂商标识不常用。</font>

### 二、Properties属性

* 该属性用来给系统配置一些运行参数，可以放在xml或者properties文件中。Mybatis中有三种方式使用Properties属性：<font color="red">property子元素，properties文件，程序代码传递。</font>

##### 1.property子元素

```xml
<properties>
    <property name="database.driver" value=""/>
    <property name="database.url" value=""/>
    <property name="database.username" value=""/>
    <property name="database.password" value=""/>
</properties>
```

之后可以通过${database.driver}来引用这些值。这就相当于给配置文件上下文定义了全局变量。所以它的配置位置在最前面。

这种方式的缺点是当配置的参数很多时，配置文件就会显得臃肿。因此抽离这些配置参数单独用一个文件去维护会更好。所以请看第二种方式。

##### 2.properties文件

* 新建jdbc.properties文件

~~~properties
database.driver=com.mysql.jdbc.Driver
database.url=jdbc:mysql://106.12.6.95:3306/pcq_test?useSSL=false
database.username=root
database.password=Pcq@1234
~~~

* 在配置文件中引用properties文件

~~~xml
<properties resource="jdbc.properties"/>
~~~

使用配置的参数方式和property子元素配置一样。通过${database.driver}这种方式即可。

##### 3.程序代码传递

* 该方式通过Resource对象来读取properties配置文件，获得流后加载进Properties对象中。通过该对象获得这些配置信息。

#### 总结：

​	这里学习了三种配置方式。这些配置方式是有优先级的，最高的是代码传递方式，其次是properties文件，最后才是property子元素。Mybatis会根据优先级来覆盖之前配置的信息。

### 三、settings设置

* 该设置是Mybatis中最复杂的配置。能深刻影响Mybatis的底层运行。一般情况下使用它的默认值或者修改一些常用的规则。

* 配置项说明

| 配置项                            | 作用                                                         | 选项值                                  | 默认值                            |
| --------------------------------- | ------------------------------------------------------------ | --------------------------------------- | --------------------------------- |
| cacheEnabled                      | 该配置影响所有映射器中配置缓存的全局开关                     | true\|false                             | true                              |
| lazyLoadingEnabled                | 延迟加载的全局开关。特定关联关系中可以通过fatchType属性覆盖该开关状态 | true\|false                             | false                             |
| aggressiveLazyLoading             | 启用时对任意对象的属性调用会==完整==加载该对象，反之==按需加载==属性。 | true\|false                             | 3.4.1之前是true,之后false         |
| multipleResultSetsEnabled         | 是否允许单一语句返回多结果集==（需要兼容驱动）==             | true\|false                             | true                              |
| useColumnLabel                    | 使用列标签代替列名                                           | true\|false                             | true                              |
| useGeneratedKeys                  | 允许JDBC自动生成主键                                         | true\|false                             | false                             |
| autoMappingBehavior               | 指定mybatis如何自动映射到字段或者属性[^1]                    | NONE\|PARTIAL\|FULL                     | PARTIAL                           |
| autoMappingUnknown ColumnBehavior | 指定映射当中有未知列时的处理行为。[^2]                       | NONE\|WARNING\|FAILING                  | NONE                              |
| defaultExecutorType               | 配置默认的执行器[^3]                                         | SIMPLE\|REUSE\|BATCH                    | SIMPLE                            |
| defaultStatementTimeout           | 设置超时时间，决定驱动等待数据库响应的秒数                   | 任意正整数                              | null                              |
| defaultFetchSize                  | 设置返回的条数限制，此参数可以重新设置                       | 任意正整数                              | null                              |
| safeRowBoundsEnabled              | 允许嵌套语句中使用分页(rowbounds)                            | true\|false                             | false                             |
| safeResultHandlerEnabled          | 允许嵌套语句中使用分页(ResultHandler)                        | true\|false                             | false                             |
| mapUnderscoreToCamelCase          | 是否开启自动驼峰命名规则映射[^4]                             | true\|false                             | false                             |
| localCacheScope                   | 利用本地缓存机制防止循环引用和加速嵌套查询[^5]               | SESSION\|STATEMENT                      | SESSION                           |
| jdbcTypeForNull                   | 没有为参数提供特定的类型时，为空值指定JDBC类型。             | NULL\|VARCHAR\|OTHER                    | OTHER                             |
| lazyLoadTriggerMethods            | 指定对象的哪一个方法触发一次延迟加载                         | —                                       | equals、clone、hashCode、toString |
| defaultScriptingLanguage          | 指定动态SQL生成的默认语言                                    | —                                       | ...                               |
| callSettersOnNulls                | 指定结果集为null时是否调用对象的setter方法                   | true\|false                             | false                             |
| logPrefix                         | 指定增加到日志名称的前缀                                     | true\|false                             | Not set                           |
| logImpl                           | 指定所用日志的具体实现                                       | ...[^6]                                 | Not set                           |
| proxyFactory                      | 指定MyBatis创建具有延迟加载能力对象所用到的代理工具          | CGLIB\|JAVASSIST                        | JAVASSIST                         |
| vfsImpl                           | 指定VFS的实现类                                              | 提供VFS的类全限定名，存在多个则逗号分隔 | Not set                           |
| useActualParamName                | 允许用方法参数中声明的实际名称引用参数[^7]                   | true\|false                             | true                              |

* 虽然settings的配置项比较多，但是常用的和比较重要的只有：cachedEnabled，lazyLoadingEnabled，aggressiveLazyLoading，autoMappingBehavior，mapUnderscoreToCamelCase,defaultExecutorType。
* 全量配置样例

```xml
<settings>
    <setting name="cacheEnabled" value="true"/>
    <setting name="lazyLoadingEnabled" value="true"/>
    <setting name="multipleResultSetsEnabled" value="true"/>
    <setting name="useColumnLabel" value="true"/>
    <setting name="useGeneratedKeys" value="false"/>
    <setting name="autoMappingBehavior" value="false"/>
    <setting name="autoMappingBehavior" value="PARTIAL"/>
    <setting name="autoMappingUnknownColumnBehavior" value="WARNING"/>
    <setting name="defaultExecutorType" value="SIMPLE"/>
    <setting name="defaultStatementTimeout" value="25"/>
    <setting name="defaultFetchSize" value="100"/>
    <setting name="safeRowBoundsEnabled" value="false"/>
    <setting name="mapUnderscoreToCamelCase" value="false"/>
    <setting name="localCacheScope" value="SESSION"/>
    <setting name="jdbcTypeForNull" value="OTHER"/>
    <setting name="lazyLoadTriggerMethods" value="equals,clone,hashCode,toString"/></settings>
```





---

[^1]: NONE表示取消自动映射。PARTIAL表示只会自动映射。没有定义嵌套结果集和映射结果集。FULL会自动映射任意复杂的结果集。
[^2]: 默认是不处理，只有当日志级别达到warn或者以上才会显示相关日志。如果处理失败抛出SqlSessionException异常。
[^3]: SIMPLE是普通的执行器，REUSE会重用预处理语句，BATCH重用预处理语句并且批量更新。 
[^4]: 即A_CLOUMN映射成aCloumn
[^5]: 默认值为session，这种情况会缓存一个会话中执行的所有查询。若是statement则本地会话仅用在执行语句上，相同SqlSession的调用不会共享数据
[^6]: SLF4J|LOG4J|JDK_LOGGING  等等。不指定这个值，则自动查找
[^7]: 使用此功能，项目必须编译为JAVA8参数的选择 



