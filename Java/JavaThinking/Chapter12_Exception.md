# Chapter12_Exception

### 一、自定义异常

##### 1.创建方式

* 继承已有的异常，产生默认的构造器

```java
//自定义异常
public class MyException extends Exception{
}
//测试异常
public class TestException {
    public void f() throws MyException {
        System.out.println("抛出异常开始....");
            throw new MyException();//该方法仅仅抛出一个异常
    }
    public static void main(String[] args){
        try {
            new TestException().f();
        } catch (MyException e) {
            e.printStackTrace();
        } finally {
            System.out.println("捕获异常结束..");
        }
    }
}
```

* 构造函数带参数的异常

```java
class ExceptionWithMsg extends Exception {
    public ExceptionWithMsg(String message) {
        super(message);
    }
}
```

### 二、捕获异常

* 语句结构

```java
try{
    //发生异常代码块
   throw new NullPointerException("this is a nullpointer Exception");
}catch(NullPointerException e){
    //捕获后所作出的处理
    e.printStackTrace();//打印异常信息，异常发生的所在代码行
}

/**如果捕获多个异常，则try后面可以增加多个catch语句块。注意的是，异常要从小往大catch。假设第一个catch的异常为Exception那么大，那么后面的小异常语句块将会被忽略，不作处理。*/

/**有时候需要在捕获异常的时候抛出异常，就像这样*/
try{
	throw new Exception();
}catch(Exception e) {
    e.printStackTrace();
    throw new NullPointerException();//捕获了大异常，这里却抛出了一个小的空指针异常
}


```

* 异常链

