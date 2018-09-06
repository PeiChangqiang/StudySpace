# JS基础3_DOM文档

### 一、文档树

##### 1.结构规范

document

	HTML
	
		HEAD
	
			META
	
			TITLE
	
		BODY

### 二、文档操作

##### 1.获取文档元素

```html
<html>
    <head>
        <meta charset="utf-8"/>
        <title>this is a page</title>
    </head>
    <body>
        <h1 id='test'>人物简介</h1>
        <ul id="introduce" class="cli_test">
            <li>这是一个万众瞩目的人物</li>
            <li>他曾经建立卓越的功勋</li>
            <li>他令这个欧洲都为之颤抖</li>
        </ul>
    </body>
</html>
```

* document.getElementById()

```javascript
var ele_obj = document.getElementById('introduce');//返回的是个对象
console.log(ele_obj);
/**返回结果：
		<ul id="introduce">
            <li>这是一个万众瞩目的人物</li>
            <li>他曾经建立卓越的功勋</li>
            <li>他令整个欧洲都为之颤抖</li>
        </ul>
*/
```

* document.getElementsByTagName()

```javascript
var list = document.getElementsByTagName('li')
console.log(list[0]);
/**返回结果：
	<li>这是一个万众瞩目的人物</li>
*/
```

* querySelector & querySelectorAll

```javascript
var obj = document.querySelector(".cli_test li");
console.log(obj);
/**返回结果
	<li>这是一个万众瞩目的人物</li>
*/

var obj = document.querySelectorAll(".cli_test li");
console.log(obj);
/**返回结果
	<li>这是一个万众瞩目的人物</li>
    <li>他曾经建立卓越的功勋</li>
    <li>他令整个欧洲都为之颤抖</li>
*/
```

##### 2.访问元素的属性

* 常见属性说明

| 属性                   | 说明               |
| ---------------------- | ------------------ |
| childNodes             | 所有子节点         |
| nodeName               | 节点名称           |
| innerText              | 元素中的内容       |
| parentNode             | 父节点元素         |
| previousElementSibling | 上一个兄弟节点元素 |
| nextElementSibling     | 下一个兄弟节点元素 |
| firstElementChild      | 第一个子元素       |
| lastElementChild       | 最后一个子元素     |

##### 3.文档节点操作

* createElement()：创建元素
* createTextNode()：创建文档内容节点
* appendChild()：追加子元素。

```javascript
var newNode = document.createElement('li');//创建一个li元素
var newNodeText = document.createTextNode('厉害人物');//创建一个Text节点
newNode.appendChild(newNodeText);//将Text节点追加到li元素中
document.querySelector(".cli_test").appendChild(newNode);//将li元素追加到ul元素中
/**返回结果
	<li>这是一个万众瞩目的人物</li>
    <li>他曾经建立卓越的功勋</li>
    <li>他令整个欧洲都为之颤抖</li>
     <li>这个人很厉害</li>
*/
```

* removeChild()：删除子节点
* insertBefore()：添加元素至指定元素的前面

```javascript
document.querySelector(".cli_test").removeChild(newNode);//删除刚刚创建的li元素
var li_ele = document.createElement("li");
li_ele.innerText = "这将成为第一个节点";//给这个li元素设置内容
//获取ul的第一个孩子
var firstChild = document.querySelector(".cli_test").firstElementChild;
//把li_ele插入到第一个孩子之前
document.querySelector(".cli_test").insertBefore(li_ele, firstChild);
/**返回结果
	<li>这将成为第一个节点</li>
	<li>这是一个万众瞩目的人物</li>
    <li>他曾经建立卓越的功勋</li>
    <li>他令整个欧洲都为之颤抖</li>
     <li>这个人很厉害</li>
*/
```

