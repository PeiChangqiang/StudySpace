# XML

## 一、XML的应用

1.不同系统之间传输数据

2.表示有关系的数据

* 例如省市县之间的归属关系

3.作为配置文件

---

## 二、XML语法

### 1.xml文档说明

* <?xml version="1.0" encoding="gbk/utf-8"?>文档第一行第一列需要此声明，声明该文件是xml文档，并且声明它的版本和编码。
* standalone是可选属性，表明是否依赖其它文件，属性值为“yes/no"。一般不写该属性

### 2.实体引用

* 有些特殊字符出现在xml中为了避免xml解析错误，需要用实体引用了来代替

| \&lt;   | <    | less than      |
| ------- | ---- | -------------- |
| \&gt;   | >    | greater than   |
| \&amp;  | &    | ampersand      |
| \&apos; | '    | apostrophe     |
| \&quot; | "    | quotation mark |

### 3.定义元素

### 4.定义属性

### 5.注释

```xml
<!-- xml注释和html差不多 -->
```

### 6.CDATA区

```xml
<!-- CDATA区的文本不会被xml解析，因此可以使用特殊字符。-->
<![CDATA[
 func(a, b) {
	if(a < b) {
		dosomething....
	}
}
]]>
```



### 7.PI指令

* 可以在xml中设置样式
* 写法

```xml
<?xml-stylesheet type="text/css" href=""?>
```

---



## 三、XML约束DTD