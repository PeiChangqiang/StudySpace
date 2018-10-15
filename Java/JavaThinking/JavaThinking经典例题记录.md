# JavaThinking 第4版一些记录

### 第2章 一切都是对象

* 2.7章节中有段代码，能提供和系统相关的信息

```java
public static void main(String[] args) {
   	//从运行程序的系统中获取所有的属性信息，并且发送个System.out对象打印。该语句能提供环境信息
        System.getProperties().list(System.out);
        System.out.println("---------------------------------------------");
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("java.library.path"));
    }
```

* 看到JavaDoc文档一节，自己百度了下如何使用idea生成注释文档，这里简要记录下

  1.代码

  ```java
  package com.pcq.main;
  
  /**
   * 这是一个测试如何规范代码注释文档，以便
   * 让javadoc能够生成规范html格式的代码注
   * 释文档的测试类
   */
  public class JavaDocTest {
      public String id;
      /**这是用户名*/
      public String userName;
      /**这是年龄*/
      protected Integer age;
  
      /**private修饰的字段默认不会被javadoc生成注释，除非加上-private标记*/
      private String passWord;
  
      /**这是一个默认的
       * 构造函数。
       */
      public JavaDocTest() {
  
      }
  
      /**
       * 这是一个测试方法
       * @param x 字符串x
       */
      public void docTest(String x) {
  
      }
  }
  ```

  2.选择idea菜单Tools->Generate JavaDoc scope 打开对话框

  ![1539586688091](C:\Users\pcq\AppData\Roaming\Typora\typora-user-images\1539586688091.png)

  第一个框：选择给整个项目还是给一个模块还是给单个文件构建注释文档。我这里选择的是单个文件

  第二个框：选择注释文档的在那个路径下生成

  第三个框：选择生成的注释文档的语言。这里是中文简体

  第四个框：-encoding UTF-8 -charset UTF-8 -windowtitle "JavaDocTest.java" -link https://docs.Oracle.com/javase/8/docs/api

  * -encoding参数：表示源代码基于什么编码字符集的。这里是UTF-8
  * -charset参数：表示处理生成的javadoc文档的字符编码。这里是UTF-8
  * -windowtitle参数：打开生成的注释文档后，浏览器窗口标题
  * -link参数：代码中使用的外部类库中的类，可以根据该链接寻找外部类的非全限定名。

  点击OK即可生成doc该java文件的注释文档。

### 第14章 类型信息

* 练习 8 如何打印一个对象所在的继承体系中的所有类？

~~~java
//接收一个对象
public static void printClassStructure(Object object) {
    if(null != object) {
        printClassStructure(object.getClass());
    }
    return;
}
//接收一个类型参数，并且递归打印它的所有继承体系类和接口
public static void printClassStructure(Class<?> c) {
    if(null == c) {
        return;
    }
    for(Class i : c.getInterfaces()) {//遍历该类的接口
        System.out.println("interfaceName: " + i.getName());
        printClassStructure(i.getSuperclass());//递归
    }
    System.out.println(c.getName());
    printClassStructure(c.getSuperclass());//递归
}
~~~

