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

