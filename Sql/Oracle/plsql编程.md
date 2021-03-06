### 一、基本概念

?	是一种过程化程序语言。支持高级语言的快操作，条件判断，循环语句等。具有以下特点：
		1）支持事务控制和SQL数据操作命令。
		2）支持SQL的所有数据类型。还扩展了新类型。支持SQL函数和运算符。
		3）可以存储在Oracle服务器中，提高运行性能。
		4）服务器上的PL/SQL程序可以使用权限控制。
		5）良好的可移植性。
		6）可对程序错误进行自动处理。使得程序不会中断。
		7）减少网络交互。提高程序性能。

### 二、使用

##### 	1.结构

1)声明:DECLARE，声明变量，常量，游标，和用户的自定义异常处理部分。
2)执行：从BEGIN开始。这部分是必须的。语句最后（在异常后面）END结束。
3)异常：EXCEPTION开始。发生错误时做出的相应处理。

##### 	2.常量和变量

1）常量：c_name CONSTANT dadatype [not null]{:=|default} expression;大括号里的意思是必须显式的赋值。
2）变量：v_name datatype [not null]{:=default} expression;
		例如：

```sql
DECLARE
v_cid course.cid%TYPE := '006';
v_cname course.cname%TYPE := 'biology';
v_tid course.tid%TYPE := '001';
BEGIN
INSERT INTO course SELECT v_cid,v_cname,v_tid FROM dual;
END;
```

?		注：其中%号的含义是取和对应表中对应字段相同的数据类型。这样是为了防止硬编码，以防以后表结构发生变动时，即使相应字段发生改变，这里的代码仍然不需要改变。

##### 	3.程序逻辑结构

?	1）顺序结构
	2）条件结构

```sql
if  condition then sql_statements 
	elsif then sql_statements 
    else sql_statements 
end if;

case when boolean_expre 
then sql_statements 
when boolean_expre then sql_statements 
end case; 
 case v 
 when v1 then sql_statements 
 when v2 then sql_statements
 END CASE;	
```

两个区别在于一个case比较值，一个不比较值而分支中填的是boolean值。

?	3）循环结构

```sql
LOOP:
				DECLARE 
				v_num NUMBER(10) := 10;--控制循环次数
				BEGIN
				  LOOP 
				    DBMS_OUTPUT.put_line('当前的v_num值为：' || v_num);
				    IF v_num > 0 THEN v_num := v_num - 1; --跳出循环的条件
				    ELSE EXIT;
				    END IF;
				  END LOOP;
				END;

```

?			

##### 	4.异常

		1）异常的分类
			a：预定义异常，Oracle定义了它们的错误编号和异常名字。常见的有->NO_DATA_FOUND;TOO_MANY_ROWS;DUL_VAL_ON_INDEX（试图在有唯一性约束的列上存储重复值）
			b：非预定义异常，定义了错误编号但是没有名字。使用时先声明异常名再通过伪过程PRAGMA EXCEPTION_INIT，将异常名和错误号关联起来。
			c：自定义异常，程序员从业务角度出发，定义的一些规则和限制。
		2）异常处理的使用
			EXCEPTION
				WHEN e_name then ...;
				WHEN e_name then ...;
				WEHEN OTHERS then ...;--前面如果没有被捕获，则最终执行这个
			例子：
			DECLARE
			v_num NUMBER(10) := 0;
			BEGIN
			  v_num := 10 / 0;
			  EXCEPTION
			    WHEN zero_divide THEN
			      DBMS_OUTPUT.put_line('除数不能为零!');
			END;

##### 	5.函数

		1）定义例子
			CREATE OR REPLACE FUNCTION ADD_NUM(A IN NUMBER, B IN NUMBER) RETURN NUMBER IS    --定义函数名，参数，以及返回值
			  SUM_NUM NUMBER(10);
	
			BEGIN
			  SUM_NUM := A + B;
			  RETURN SUM_NUM;
			END;
		2）删除函数
			drop function fun_name;

注：可以在user_source中查看函数。

==综合实战==


```sql
DECLARE
   v_score sc.score%TYPE;--分数
   v_sname student.sname%TYPE;--姓名
   v_cid sc.cid%TYPE;--课程号
   v_cname course.cname%TYPE;--课程
   CURSOR stu_cur IS SELECT * FROM sc ORDER BY SID;--游标存储学生的结果集
   cur_students stu_cur%ROWTYPE;--声明结果集变量存储游标
   v_sid sc.sid%TYPE;--学号
BEGIN
  OPEN stu_cur;
       LOOP 
	      FETCH stu_cur INTO cur_students;--一行行的抓取数据放到stu_cur中
	      EXIT WHEN stu_cur%NOTFOUND;--没有数据的时候退出LOOP
	      IF cur_students.score > 90 THEN
		v_score := cur_students.score;
		v_sid := cur_students.sid;
		v_cid := cur_students.cid;
		SELECT sname INTO v_sname FROM student WHERE SID=v_sid; --将查询结果插入到变量中
		SELECT cname INTO v_cname FROM course WHERE cid = v_cid;
		DBMS_OUTPUT.put_line(v_sid || ',' || v_sname || ',' || v_cname || ','  || v_score);
	      END IF;                        
       END LOOP;
   CLOSE stu_cur;
END;
```

```sql
-----------------------------case when-----------------------------------------------

DECLARE
       v_score sc.score%TYPE;--分数
       v_sname student.sname%TYPE;--姓名
       v_cid sc.cid%TYPE;--课程号
       v_cname course.cname%TYPE;--课程
       CURSOR stu_cur IS SELECT * FROM sc ORDER BY SID;--游标存储学生的结果集
       cur_students stu_cur%ROWTYPE;--声明结果集变量存储游标
       v_sid sc.sid%TYPE;--学号
	BEGIN
	  OPEN stu_cur;
	       LOOP 
		      FETCH stu_cur INTO cur_students;
		      EXIT WHEN stu_cur%NOTFOUND;
		      v_score := cur_students.score;
		      v_sid := cur_students.sid;
		      v_cid := cur_students.cid;
		      SELECT sname INTO v_sname FROM student WHERE SID=v_sid; --将查询结果插入到变量中
		      SELECT cname INTO v_cname FROM course WHERE cid = v_cid;
		      CASE 
			WHEN cur_students.score >= 90 THEN
			     DBMS_OUTPUT.put_line(v_sid || ',' || v_sname || ',' || v_cname || ','  || v_score || ',优秀');
			WHEN cur_students.score < 90  THEN
			  DBMS_OUTPUT.put_line(v_sid || ',' || v_sname || ',' || v_cname || ','  || v_score || ',良好');
		      END CASE;                        
	       END LOOP;
	   CLOSE stu_cur;
	END;


```




