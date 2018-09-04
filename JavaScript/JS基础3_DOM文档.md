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
        <ul id="introduce">
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
            <li>他令整个个欧洲都为之颤抖</li>
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



