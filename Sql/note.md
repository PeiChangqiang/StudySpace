

##### 八、使用函数处理数据

?	1.常见函数
		1）截取字符串:Oracle->substr(); Mysql->substring();
		2）数据类型转换：Oracle有多个函数，Mysql->convert();
		3）获取当前日期：Oracle->sysdate,Mysql->curdate();
	注：由于不同的DBMS系统所使用的函数不同，这会给可移植性带来不方便。如果必须使用函数，最好添加代码注释。

	2.文本处理函数
		1）trim()：祛除空格
		2）upper()：转换成大写;   lower()：转换成小写
		3）ltrim()：去掉字符串左边的空格;   rtrim()：去掉字符串右边的空格
		4）soundex()：返回字符串的soundex值。这个值是语音表示的字母数字模式的算法。
		5）length()：返回字符串的长度
	3.时间和日期处理函数（移植性最差）
		1）year();month();day();分别提取年月日。ex:select year(curdate()) from dual;
	4.数值处理函数
		1）ABS():返回绝对值  EXP():返回指数值
		2）PI()：返回圆周率  SQRT()：返回平方根
		3）SIN()：返回正弦  COS()：返回余弦   TAN()：返回正切



##### 九、汇总数据

?	1.聚集函数
		1）avg();count();max();min();sum();
		2）其中sum不仅可以计算某一列的和，还可以合计计算值。例如计算两个列相乘后所有行的和。
	注：avg只用于单个列，并且忽略列值为null的行。count(*)包含含null的值，而count(column)忽略null值。
	2.聚集不同值（distinct）
		1）select avg(distinct prod_price) from Products where vend_id='';
	注：Distinct不能用于count(*)，只能用于count()指定列名。select count(distinct prod_price) from Products;
	

##### 十、分组数据（group by）

?	1.group by子句中每一列都必须是检索列或者有效的表达式（+-*/），但不能是聚集函数。
	2.group by必须在where之后，order by 之前。
	3.除了聚集函数的列外，select中的每一列都必须在group by子句中给出。意思是group by后的列必须大于等于select中的列。因为先分组后select，只有分组后才能够select列。
	4.过滤分组(having子句)
		允许对分组后的数据进行过滤。
		注：having和where的区别，where在分组前过滤，having在分组后过滤。...from table where ...group by .. having...。意思是在where过滤后的数据组进行分组，然后通过having在过滤分组后的数据。
		如果不使用group by ，则where和having的效果相同。但是having应该结合group by，where应该用于标准的行级过滤。
	5.分组和排序
		排序不能依赖group by，而应该使用order by。
	

	6.SELECT子句的顺序： select from where group by having order by。这是语句写法顺序，并不是数据库的执行顺序。

##### 十一、使用子查询

?	
?		
?		

##### 十九、使用存储过程

?	1.
	

---

[^account]: Product Code：4t46t6vydkvsxekkvf3fjnpzy5wbuhphqz;  serial Number：601769; password：xs374ca 