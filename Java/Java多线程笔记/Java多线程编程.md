# Java多线程编程

## 一、实现多线程的方式

### 1.继承Thread类

```java
class MyThread extends Thread {
	private String name;
	
	public MyThread(String name) {
		this.name = name;
	}
	public void run() {//其实重写的还是Runnable中的run方法。因为Thread也实现了Runnable
		for(int i = 0; i < 10; i++) {
			System.out.println(this.name + "运行：" + i);
		}
	}
}

public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		new MyThread("线程A").start();
		new MyThread("线程B").start();
		new MyThread("线程C").start();
	}
```

* 线程要执行的主要程序代码在**run**方法中，但是启动却需要调用**start**方法，实际上调用的是start0本地方法(JNI技术 Java Native Interface)。
* 每个线程只能启动一次。否则抛出异常。

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191225230002858.png" />

### 2.Runnable接口实现多线程

```java
class RunThread implements Runnable { 
	private String name;
	
	public RunThread(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(this.name + "运行 ：" + i);
		}	
	}	
}
public static void main(String[] args) {
		Thread t1 = new Thread(new RunThread("线程A"));
		Thread t2 = new Thread(new RunThread("线程B"));
		Thread t3 = new Thread(new RunThread("线程C"));
		t1.start();
		t2.start();
		t3.start();
	}
```

* 多线程代码优先考虑Runnable接口实现，永远是Thread类启动。
* 通过lambda表达式实现函数式接口多线程

```java
new Thread(()->{
    for(int i = 0; i < 10; i++) {
        System.out.println("i:" + i);
    }
}).start();
```

---

### Thread与Runnable的关系

![image-20191225234058639](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191225234058639.png)

* 实际上**Thread描述的是线程对象**，而**Runnable的子类描述的是资源**。Thread代理类通过控制调用Runnable子类的run方法来描述多个线程对资源的访问。

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20191225234547126.png" />

* 多线程开发的本质是在于多个线程可以进行同一资源的抢占。



### 3.Callable借口实现多线程

* **由于传统的实现多线程的方式是没有返回值的，因此在1.5的时候java.util.concurrent包提供了新的方法call来提供返回值。**

![image-20200107220344706](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200107220344706.png)

```java
package com.pcq.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableDemo {
	
	public static void main(String[] args) throws Exception {
		FutureTask<String> task1 = new FutureTask<String>(new CallThread("A"));
		FutureTask<String> task2 = new FutureTask<String>(new CallThread("B"));
		new Thread(task1).start();
		
		//System.out.println(task1.get());
		new Thread(task2).start();
		
	}

}
class CallThread implements Callable<String> {

	private String name;
	public CallThread(String name) {
		this.name = name;
	}
	public String call() throws Exception {
		for(int i = 0; i < 10; i++) {
			System.out.println(this.name + ": " + i);
		}
		return "线程" + name + "执行完毕";
	}
	
}
```

* 启动start的时候调用的是call方法，调用get方法的时候，返回的是call方法的返回值。





## 二、多线程运行状态

![image-20200107225702661](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200107225702661.png)

