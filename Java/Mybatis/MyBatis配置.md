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

* 该属性用来给系统配置一些运行参数，可以放在xml或者properties文件中。Mybatis中有三种方式使用Properties属性：property子元素，properties文件，程序代码传递。



##### 1.property子元素

