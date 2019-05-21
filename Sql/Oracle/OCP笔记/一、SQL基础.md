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

## 五、分组函数



## 六、数据限定和排序



## 七、复杂查询：多表连接技术和子查询

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