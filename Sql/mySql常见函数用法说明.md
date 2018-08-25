# Mysql常见函数用法实例说明

### 一、字符串相关函数

#####     1.字符串截取

​	substring() 

​        ==substring('abcdef', 2)->bcdef;  substring('abcdef',2,4)->bcde==  这里的4是往后截取4位，没有第3个参数则默认截取到末尾;

#####     2.返回字符位置

​	instr(): 返回字符所在的位置，如果没有返回0
        ==instr('abcdef', 'b')->2;==