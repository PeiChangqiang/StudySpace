# JS基础2_函数和对象

### 一、函数

##### 1.函数的定义

```javascript
function fun_name(param) {
 alert("Hello World");   
}
//匿名函数
var alertHello = function() {
    alert("Hello World");   
}
```

### 二、对象

##### 1.对象的创建

```javascript
var obj = {};//创建对象
//给对象的属性赋值两种方式
obj.name='小王子';
obj['age']=10;
console.log(obj);//输出{name:"小王子",age:10}
//可以直接创建对象的时候给对象属性赋值
var obj = {name:"小王子", age:10};
```

##### 2.对象里的数组

```javascript
var reader = {name:'pcq', age:25, books:['故事','linux','Java']};
console.log(reader.books[2]);//返回Java
```

##### 3.对象属性的操作

* 对象属性的更新和删除

```javascript
var reader = {name:'pcq', age:25, books:['故事','linux','Java']};
//对象属性的更新
reader.name='peichangqiang';
//对象属性的删除
delete reader.age;
```

##### 4.对象方法

* 为对象创建方法

```javascript
var reader = {name:'pcq', age:25, books:['故事','linux','Java']};
//添加方法
reader.read = function() {
    for(var i = 0; i < this.books.length; i++) {
        document.writeln(this.name + "正在阅读" + this.books[i]);
    }
}
```

* 循环打印对象的属性

```javascript
var proper;
for(proper in reader) {
    if(typeof reader[proper] !== 'function') {//方法不打印
        console.log(reader[proper]);
    }
}
```

