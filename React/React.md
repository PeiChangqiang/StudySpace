# React

### 一、快速入手代码示例

```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Hello React!</title>
    <script src="https://cdn.bootcss.com/react/16.4.0/umd/react.development.js"></script>
    <script src="https://cdn.bootcss.com/react-dom/16.4.0/umd/react-dom.development.js"></script>
    <script src="https://cdn.bootcss.com/babel-standalone/6.26.0/babel.min.js"></script>
</head>
<body>
    <div id="example"></div>
    <script type="text/babel">
ReactDOM.render(
    <h1>Hello, world!</h1>,
    document.getElementById('example')
);
</script>
</body>
</html>
```

* 引入的js库说明

| 库名                 | 说明                                                         |
| -------------------- | ------------------------------------------------------------ |
| **react.min.js**     | react核心库                                                  |
| **react-dom.min.js** | 提供与==dom==的相关功能                                      |
| **babel.min.js**     | Babel 可以==将 ES6 代码转为 ES5==代码，这样我们就能在目前不支持 ES6 浏览器上执行 React 代码。Babel 内嵌了对 JSX 的支持。通过将 Babel 和 babel-sublime 包（package）一同使用可以让源码的语法渲染上升到一个全新的水平。 |

* body中的代码说明

其中的script脚本是将<h1>元素插入到了id为example的div节点中。

### 二、通过npm命令搭建react开发环境

##### 1.安装node.js环境

##### 2.全局安装create-react-app包

* npm install -g create-react-app

##### 3.建立项目

* create-react-app  my-test

##### 4.进入项目并启动

* cd my-test 
* npm start
* 之后访问localhost:3000

