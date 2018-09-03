# JavaScript基础1

[TOC]



### 一、基本数据类型

##### 1.Number

##### 2.String

##### 3.Null

##### 4.Undefined

##### 5.true or false

### 二、字符串常用方法

##### 1.解析字符串数字

* parseInt：解析成整数
* parseFloat：解析成小数

```javascript
var num_str = '4.5千克';
parseInt(num_str);//返回4
parseFloat(num_str);//返回4.5
```

##### 2.文本常见操作API

* 方法说明

| 方法          | 说明                                                         |
| ------------- | ------------------------------------------------------------ |
| charAt(index) | 根据下标返回字符串中的指定字符                               |
| indexOf('')   | 根据指定字符返回在字符串中的下标                             |
| substring()   | 根据下标截取字符串。传入开始下标和结束下标作为参数。但是返回的字符串不包含结束下标的那个字符。即“含头不含尾”。 |
| replace()     | 替换指定的字符或字符串。                                     |
| split()       | 根据指定分割符分割字符串，返回数组。                         |

* 示例

```javascript
var str = '假如生活欺骗了你';
str.charAt(0);//返回'假'。如果下标超出字符串范围则返回''。
str.indexOf('生');//返回2。如果字符不在字符串中则返回-1。
str.lastIndexOf()//是从后往前找到第一个字符的下标
str.substring(2,6);//返回'生活欺骗'。它和str.substring(6,2)返回的结果一样。
str.replace('生活','世界');//返回"假如世界欺骗了你"。

var new_str = '呵呵,嘻嘻,哈哈,嘿嘿';
new_str.split(',');//返回["呵呵","哈哈","嘻嘻","嘿嘿"]。
new_str.split('/');//如果指定的分割符不在字符串中。则返回["呵呵,嘻嘻,哈哈,嘿嘿"]
```

### 三、数组

##### 1.数组定义

* var array = [];

```javascript
var array = ['a','b','c','d'];
array.length;//返回4
array[1];//返回'b'
```



##### 2.数组操作

* 插入或者覆盖数组元素

```javascript
var array = ['a','b','c','d'];
array[4] = '8';//array此时为['a','b','c','d',8];
array[3] = 2;//此时覆盖了下标为3的"d"。array为['a','b','c',2,8]
array[8] = 'test';//array为['a','b','c',2,8,empty x 3,'test'];
```

* 追加数组元素

```javascript
var array = ['a','b','c','d'];
//从数组末尾追加。
array.push('d','e','f');//array为 ["a", "b", "c", "d", "d", "e", "f"]
//从数组开始追加。
array.unshift(0,1,2);//array为[0, 1, 2, "a", "b", "c", "d"]
```

* 删除数组元素

```javascript
var array = ['a','b','c','d'];
//从数组末尾删除
array.pop();//array为['a','b','c'];
//从数组开始删除
array.shift();//array为['b','c'];
//删除数组指定下标的元素值
delete array[1];//array为['b',empty];
//根据下标彻底删除数组的元素
array.splice(1);//array为['b'];
```

* 合并数组

```javascript
var arr1 = ['a','b'];
var arr2 = ['c','d'];
var arr3 = arr1.concat(arr2);//arr3为['a','b','c','d'];
```

### 四、基本流程控制

##### 1.分支

* if

```javascript
/**
*单个条件判断
*/
if() {
   //括号里为真执行
   } else {
   //括号里为假执行
   }
/**
*多个条件判断
*/
if() {}
else if() { } 
else {}
       
```

* switch

```javascript
switch() {
       case condition1 : statements1; break;
       case condition2 : statements2;break;
       default : statements3;break;
       }
```

##### 2.循环

* while

```javascript
while() {
      //括号为真时则执行
      statements...
      }
//循环打印数字1-10
var i = 0;
while(i < 10) {
	i++;
    console.log(i);
} 
```

* for

```javascript
for(var i = 0; i < 10; i++) {
    console.log(i);
}
//执行顺序说明
//1.定义i=0。2.判断是否小于10，之后执行方法块打印i。此时i为0。3.执行i++，i为1。
//之后再判断是否小于10，再打印，再++...直到i<10为false停止。
```





