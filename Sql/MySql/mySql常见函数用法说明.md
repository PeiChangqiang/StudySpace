# Mysql常见函数用法实例说明

### 一、字符串相关函数

#####     1.字符串截取

	substring() 
	
	    ==substring('abcdef', 2)->bcdef;  substring('abcdef',2,4)->bcde==  这里的4是往后截取4位，没有第3个参数则默认截取到末尾;

#####     2.返回字符位置

	instr(): 返回字符所在的位置，如果没有返回0
	    ==instr('abcdef', 'b')->2;==

### 二、日期时间相关函数

##### 1.获取当前时间

* sysdate()

* current_timestamp()

* now()

  ```sql
  select sysdate()/current_timestamp()/now() from dual; ##返回:yyyy-MM-dd hh:mm:ss
  ```

##### 2.时间时期计算

* unix_timestamp()

```sql
select unix_timestamp() from dual; ##返回当前时间到1970年0时0分0秒的秒数
--接受字符串的时间格式 返回字符串时间到1970年0时0分0秒的秒数
select unix_timestamp('2018-08-30 18:23:35') from dual;
--因此计算两个时间相隔的秒数，可以：
select unix_timestamp('yyyy-MM-dd hh:mm:ss') - unix_timestamp('yyyy-MM-dd hh:mm:ss') from dual;
```

