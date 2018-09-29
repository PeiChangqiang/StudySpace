# JavaThinking 第4版经典例题记录

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

