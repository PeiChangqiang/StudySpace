# SQL基础

## 一、Oracle命令类别

* 数据操纵语言DML：select；insert；delete；update；merge
* 数据定义语言DDL：create；alter；drop；truncate；rename；comment
* 事务控制语言TCL：commit；rollback；savepoint
* 数据控制语言DCL：grant；revoke



## 二、SQL基本函数

##### 2.1 单行函数和多行函数

单行函数是一行数据返回一个结果。而多行数据指的是多行数据输入返回一个结果，比如聚合函数，常常结合分组group by使用。

##### 2.2 单行函数的几种类型

###### （1）字符函数

| 函数          | 输入                             | 输出           |
| ------------- | -------------------------------- | -------------- |
| lower()       | lower('GOOD')                    | good           |
| upper()       | upper('good')                    | GOOD           |
| initcap()[^1] | initcap('good morning')          | Good Morning   |
| concat()[^2]  | concat('go','od')                | good           |
| substr()      | substr('morning',2,3);[^3]       | orn            |
| instr()       | INSTR('a@b@c@d@e@f@h','@',3)     | 4              |
| length()      | length('abc')                    | 3              |
| lpad()        | lpad('abc',5,'*')[^4]            | **abc          |
| rpad()        | rpad('abc',5,'*')                | abc**          |
| replace()     | replace('Jack and Jue','J','BL') | BLack and BLue |
| trim()        | TRIM('x' FROM 'xxyyxyxx')[^5]    | yyxy           |

###### （2）数值函数

| 函数    | 输入             | 输出   |
| ------- | ---------------- | ------ |
| round() | round(28.3456,3) | 28.346 |
| trunc() | trunc(28.3456,3) | 28.345 |
| mod()   | mod(50,4)        | 2      |



 ###### （3）日期函数

日期在Oracle中是以数字存储的，所以可以对它加减运算，计算是**以天**[^6]为单位。  

* to_date() : ==将一个字符串格式日期按照指定格式转换成日期格式。==select to_date('2018-12-31','yyyy-MM-dd') from dual; 
* months_between()：计算两个日期之间的月份差。
* add_months()：给日期增加月份数。



###### （4）几个有用的函数

* decode()：SELECT s.*,DECODE(sname,'Jack',sage+1,sage) age FROM student s;[^7]
* distinct()：去重
* chr() 和 ASCLL()：将ascll码转换成字符或者将字符转换成ascll码。
* sys_context()：获取环境上下文，该函数常常用在触发器中，统计用户登录登出信息等。select sys_context('userenv','ip_address') from dual;



## 三、数据类型

##### 1.字符型

| 类型名   | 说明                 |
| -------- | -------------------- |
| char     | 固定字符，最长2000个 |
| varchar2 | ==可变长==，最长4000 |

##### 2.数值型

| 类型名      | 说明                              |
| ----------- | --------------------------------- |
| number(p,s) | 实数，可变长。p最大38，即最多38位 |
| int         | 整数，范围同上                    |

##### 3.日期型

| 类型名    | 说明                                  |
| --------- | ------------------------------------- |
| date      | 普通格式，精度到秒级。                |
| timestamp | 日期的扩展形式，精度到秒后小数点9位。 |

##### 4.LOB大对象型

| 类型名 | 说明                                   |
| ------ | -------------------------------------- |
| CLOB   | 存储大型文本。最大4G。适合存储小说     |
| BLOB   | 存储二进制数据。最大4G。适合图片电影。 |

##### 5.数据类型之间的转换

（1）隐性转换

​	Oracle自主判断进行转换

（2）显性转换

* to_char：数字和日期都可以转成字符。select to_char(hiredate,'fm[^8]yyyy-mm-dd') from table。数字转成字符，9表示数字，L本地化货币字符。select to_char(salary,'L99,999.99') sal from table。
* to_date：往往将日期格式的字符转换成日期。select ('2019-05-19','yyyy-mm-dd) from dual;
* to_number：select to_number('$123.56','$999.99') from dual;



## 四、WHERE子句

##### 4.1 常用运算符

​	算数：+,-,*,/； 

​	逻辑：not,and,or;  

​	比较：

​		a.单行 : =,>,<,>=,<=,<>,!=；

​		b.多行：>any,>all,<any,<all,in,not in;

​		c.模糊：like (配合"%"和"_");

​		d.特殊：is null,is not null;

##### 4.2 BETWEEN AND查找范围

​	select * from emp where salary between 5000 and 8000;

##### 4.3 模糊查询

​	转义：select * from temp_tab where name like 'A\%%' escape[^9] '\'；

​	连续两个单引号表示转义：SELECT 'son' || ' is father''s son ' FROM dual;

##### 4.4 IN 和 NOT IN

* NOT : 常见使用方式有， not(a=b); a not like '%s%'; not in();not between a and b; is not null;not exists(select 子查询)
* NOT IN： **后接不能出现空值，否则主查询无法查出结果**。select * from a where a not in(1,2,null);则返回空。

##### 4.5  交互输入变量值& 和&&

​	SELECT * FROM student WHERE sage = &age; 当前等待输入age的值，之后用输入值替代 &age。

​       该变量存储功能可以通过 set define on|off 来打开或者关闭。

## 五、分组函数

##### 5.1 最重要的5个分组函数

| 函数    | 说明   | 备注              |
| ------- | ------ | ----------------- |
| sum()   | 求和   |                   |
| avg()   | 平均   |                   |
| count() | 计数   | 该函数 不包括空值 |
| max()   | 最大值 |                   |
| min()   | 最小值 |                   |

数值型可用以上5个函数。count()、max()、min()可用于日期和字符类型。

##### 5.2 在分组函数中使用nvl()

​	select avg(nvl(sage,20)) from student;如果该sage列为空值则当20处理。

##### 5.3 Group by创建组

* group by后面的列也叫做分组特性，如果使用了group by，select 后面只能有两种类型的列，一个是**组函数列**，一个是**分组特性列**（可选）。

* 对分组结果进行过滤 则使用 **Having**。

  **select** ssex,avg(sage) **from** student **where** sage > 20 **group by** ssex **having** avg(sage) > 21 **order by** ssex;

  **执行语序**：from -> where -> group by -> having ->select -> order by；

## 六、数据限定和排序

##### 6.1 where 和 having

* where 后只能是单行函数或者表达式，不能是分组函数。而having之后必须是**group by后的分组列或者分组函数**。

##### 6.2 order by

* 排序order by：总是写在一个句子的最后，可以接**列名，表达式，列函数**等。升序asc，降序desc。可接多列排序。select *  from student order by sage desc nulls last,sname;

##### 6.3 空值(null)

* 空值（null）：表示不确定。

* 参与运算时：1）算数表达式返回空。select 100 + null from dual;   2）|| 连接空时，空转换为空字符串。

* **外键值可以为null。**

* 处理空值的几种函数：

  | 函数                       | 说明                                                         |
  | -------------------------- | ------------------------------------------------------------ |
  | nvl(expr1,expr2)           | 第一个参数为空时取第二个参数为值返回。                       |
  | nvl2(expr1,expr2,expr3)    | 第一个参数不为空，取第二个参数。如果为空，取第三个参数。     |
  | nullif(expr1,expr2)        | 比较两个值是否一样，一样返回空，不一样返回第一个参数。第一个参数不允许为空。 |
  | coalesce(expr1,expr2.....) | 返回从左开始第一个不为空的值，如果全部为空，则返回空值。     |


## 七、复杂查询：多表连接技术和子查询

##### 7.1 简单查询的解析

全表扫描，指针从第一条记录开始，依次逐行处理，直到最后一条记录。 **横向选择+纵向投影=结果集**。

##### 7.2 多表连接

* 分类：交叉连接（笛卡尔积）、非等值连接、等值连接、内连接、外连接（左外、右外、全连接）、自连接、自然连接（隐含连接条件，自动匹配连接字段）、集合运算。
* 范例

SQL：

​	CREATE TABLE a(ID INT,NAME CHAR(10));
​	CREATE TABLE b(ID INT,loc CHAR(10));

​	CREATE TABLE id_area(grade char(10),below INT,above INT)

​	INSERT INTO a VALUES(1,'a');
​	INSERT INTO a VALUES(2,'b');
​	INSERT INTO a VALUES(3,'c');
​	INSERT INTO a VALUES(4,'d');

​	NSERT INTO b VALUES(1,'A');
​	INSERT INTO b VALUES(2,'B');
​	INSERT INTO b VALUES(3,'C');

​	INSERT INTO id_area VALUES('first',1,2);
​	INSERT INTO id_area VALUES('second',3,4);	

###### 1）交叉连接

​	select * from a **cross join** b; 	select * from a,b;

###### 2）非等值连接（即关联表没有公共字段）

​	select * from a,id_area where id between below and above;

###### 3）内连接（属于等值连接）

​	select * from a **inner join** b on a.id = b.id; select * from a,b where a.id = b.id;

###### 4）外连接

​	a.左外连接

​		select * from a **left outer[^10] join** b on a.id = b.id;  select * from a,b where a.id = b.id**(+)**;

​	b.右外连接

​		select * from a **right join** b on a.id = b.id; select * from a,b where a.id**(+)** = b.id;

​	c.全连接

​		select * from a **full join** b on a.id = b.id;

​	d.自连接

​		select * from a a1,a a2;

​	e.自然连接

​		自动寻找名字以及类型一样的列，然后进行匹配。select * from a **natural join** b;  

​		如果指定列匹配则使用using。select id,a.name,b.loc from a join b **using**(id);[^11]

​		==注：using可以指定多个列名，但是和natural互斥，不能同时出现。==

##### 7.3 集合运算

| 关键字    | 说明                                         |
| --------- | -------------------------------------------- |
| Union     | 结果集并集，不包括重复行，按照默认规则排序。 |
| Union All | 结果集并集，包括重复行，不排序。             |
| Intersect | 结果集交集，不包括重复行，默认排序。         |
| Minus     | 结果集差集，不包括重复行，默认排序。         |

**集合运算的注意事项**

* 集合运算中列名不必相同。但是类型需要匹配并且顺序对应。大类型对上即可，比如char对应varchar2，date对timestamp。字段数需要相等，不等需要补全。
* 使用order by时，参照的是第一个select结果集的列。而且只能在最后一行出现一次。



##### 7.4 子查询

子查询返回的值可以被外部查询使用，这样的复合查询等效于两个连续的查询。

###### 1）单行单列子查询

​	这个子查询只返回一个结果值。经常联用的比较运算符：>,<,=,>=,<=。

​	select * from a where id > (select below from id_area where grade = 'first');

###### 2）多行单列子查询

​	经常联用的比较运算符：all,any,in,not in。

​	select * from a where id > all(1,2,3);

###### 3）多行多列子查询

​	以select主查询的Where子句中的多个列合并作为比较条件，分成对比较和不成对比较。

* 成对：select * from tab where (column_a, column_b) in (select column_a,column_b from tab where ...) 
* 不成对：select * from tab where column_a in (select column_a from tab where...) and column_b in(select column_b from tab where...);

---

[^1]: 返回每个单词的首字母大写，其它均为小写。 
[^2]: 与mysql不同，oracle该函数只能连接两个字符。如果要连接多个，需要嵌套:concat(concat('go','od'),' morning')。
[^3]: 从第2个字符开始截取，截取3个字符。substr('morning',-3,2)： 从倒数3个开始截取，截取2个，即in。
[^4]: 一共5位，左填充 * 号字符。如果位数本身就没有字符串长度长，则它相当于截取函数。lpad('abcd',2) -> ab。
[^5]: 只截取字符串两头的字符。
[^6]: select sysdate+2 from dual;在当前系统日期基础上加上2天。加2小时：sysdate+2/24。
[^7]: 查找学生表匹配学生姓名，如果名字是'Jack'则年龄加1，否则还是原来的年龄。
[^8]: fm可以压0。例如2019-05-14就会转换成2019-5-14
[^9]: escape表示后面跟着的是转义字符标识。上面的sql也可以写成select * from temp_tab where name like 'A/%%' escape '/' 
[^10]: outer 可省略不写，即left join。
[^11]: 指定的列是公共列，因此不能加限定名，不能是a.id或者b.id，必须就是id。