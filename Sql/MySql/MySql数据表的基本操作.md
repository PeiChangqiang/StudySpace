





# MySql数据表的基本操作

### 一、基本说明

##### 1.关系说明

* MySql中能创建多个数据库，每个数据库可以创建多个表。当然也可以创建其它数据库对象，例如存储过程，函数等。

##### 2.概括说明

* 表的操作是指创建表，删除表，修改表，查询表。注意的是，这里是对表的操作而不是对表的记录[^1]的操作。

### 二、具体操作

##### 1.创建表

* 语法说明

```sql
CREATE TABLE table_name(
column1 数据类型 [列约束条件],
column2 数据类型 [列约束条件],
column3 数据类型 [列约束条件]
);
```

* 数据类型

  点击链接[数据类型](....)查看MySql数据类型详解

* 约束

| 约束类型 | 约束定义字段                           |
| -------- | -------------------------------------- |
| 主键约束 | PRIMARY KEY[^解释](唯一并且不能为空)   |
| 外键约束 | CONSTRAINT  FOREIGN KEY REFERENCES[^4] |
| 非空约束 | NOT NULL[^解释](该列字段不能为空)      |
| 唯一约束 | UNIQUE[^解释](该字段是唯一的)          |
| 默认约束 | DEFAULT[^2]                            |
| 自动增加 | AUTO_INCREMENT[^3]                     |

这里只示例主键约束和外键约束。其它约束都较为简单且有注释。

```sql
--主键约束--
--1.单字段约束-----------------------------------------------
CREATE TABLE emp (
	id INT (10) PRIMARY KEY,
	emp_name VARCHAR (20) NOT NULL,
	dept_id INT (10) NOT NULL
);
--或者--
CREATE TABLE emp (
	id INT (10),
	emp_name VARCHAR (20) NOT NULL,
	dept_id INT (10) NOT NULL,
    PRIMARY KEY(id)
);
--2.多字段约束（被约束的多个字段不能同时一样）---------------------
--这里id 和emp_name不能同时一样,id为1 emp_name为张三和id为1 emp_name为李四的人可以同时存在
CREATE TABLE emp (
	id INT (10) PRIMARY KEY,
	emp_name VARCHAR (20) PRIMARY KEY,
	dept_id INT (10) NOT NULL
);
--或者--
CREATE TABLE emp (
	id INT (10),
	emp_name VARCHAR (20),
	dept_id INT (10) NOT NULL,
    PRIMARY KEY(id,emp_name)
);
```

```sql
--外键约束--
--部门表
CREATE TABLE dept (
	id INT (10) PRIMARY KEY,
	dept_name VARCHAR (10) NOT NULL
);
--员工表
CREATE TABLE emp (
	id INT (10) PRIMARY KEY,
	emp_name VARCHAR (20) NOT NULL,
	dept_id INT (10) NOT NULL,
    CONSTRAINT fk_emp_dept FOREIGH KEY(dept_id) REFERENCES dept(id)
);
--ps:外键命名规则一般是fk_外键表名_主键表名。这样部门表的id就和员工表的dept_id关联上了。

```

##### 2.删除表

* 删除没有被关联的表

```sql
DROP TABLE table_name;
DROP TABLE emp;--删除emp表
```

* 删除被关联的表

```sql
--如果删除的是dept这种被emp依赖的表则无法直接删除。有两种方式
--1.先删除子表，再删除主表--
DROP TABLE emp; DROP TABLE dept;
--为了删除主表而把子表也删除了,这种方式并不好

--2.解除依赖关系（删除外键），再删除主表--
ALTER TABLE emp DROP FOREIGN KEY fk_emp_dept;
DROP TABLE dept;
--这样就保留了子表emp--
```

##### 3.修改表

###### 1)修改表名

* ALTER TABLE table_name RENAME TO new_name  

###### 2)修改字段名

* ALTER TABLE table_name CHANGE[^5] old_name  new_name [数据类型]

###### 3)修改字段的数据类型

* ALTER TABLE table_name MODIFY cloumn_name (数据类型)

###### 4)添加字段

* ALTER TABLE table_name ADD[^6] cloumn_name (数据类型) [约束条件]  <first| after字段名>

###### 5)删除字段  

* ALTER TABLE table_name DROP cloumn_name;

###### 6)删除外键约束

* ALTER TABLE table_name DROP FOREIGN KEY  key_name;

###### 7)更改表的存储引擎

* ALTER TABLE table_name ENGINE=engine_name;



##### 4.查询表

* 查询表结构

  DESC table_name;

* 查询建表语句

  SHOW CREATE TABLE table_name;



---

[^1]: 表里存储的一行行数据。
[^2]: 使用方式：create table emp(id int(11) primary key, sex varchar(10) default '男') 当插入一条数据未给该sex字段取值时，该字段默认值为男。
[^3]: 使用这个约束的字段必须是整数类型 。默认是从1开始递增。
[^4]: 外键可以是任何一个字段。但是必须得关联主表的主键，所以必须和主表主键的字段类型保持一致。外键可以多个，并且==外键可以为空== 
[^5]: 这个关键字不仅可以修改字段名称还可以同时修改数据类型。modify只能修改数据类型 
[^6]: 默认新增字段的位置在最后追加。如果指定位置可以用first 或者after 关键字