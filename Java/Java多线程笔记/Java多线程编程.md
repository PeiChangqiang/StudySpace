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

<img src="https://thumbnail0.baidupcs.com/thumbnail/c2ccf6bbaj2d89838a78fa3ef646d784?fid=875502231-250528-848342476957138&time=1577289600&rt=sh&sign=FDTAER-DCb740ccc5511e5e8fedcff06b081203-EkYectj4yMHtGBLFlEMgOxQ1rLU%3D&expires=8h&chkv=0&chkbd=0&chkpc=&dp-logid=8327009563146155982&dp-callid=0&size=c710_u400&quality=100&vuk=-&ft=video" />

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

![image-20191225234058639](https://thumbnail0.baidupcs.com/thumbnail/b8d994f93u283f02f4cf8cce3f3ca64e?fid=875502231-250528-517377106126846&time=1577289600&rt=sh&sign=FDTAER-DCb740ccc5511e5e8fedcff06b081203-fTcqlH5eUK6PDfYA4RS%2F%2FDgiWXs%3D&expires=8h&chkv=0&chkbd=0&chkpc=&dp-logid=8326987727575480588&dp-callid=0&size=c710_u400&quality=100&vuk=-&ft=video)

* 实际上**Thread描述的是线程对象**，而**Runnable的子类描述的是资源**。Thread代理类通过控制调用Runnable子类的run方法来描述多个线程对资源的访问。

<img src="https://thumbnail0.baidupcs.com/thumbnail/337b9556dvbd25e34334221e290e2588?fid=875502231-250528-267022183985916&amp;time=1577289600&amp;rt=sh&amp;sign=FDTAER-DCb740ccc5511e5e8fedcff06b081203-OW4EBegDo3PVnozO9mIbjNIdWLs%3D&amp;expires=8h&amp;chkv=0&amp;chkbd=0&amp;chkpc=&amp;dp-logid=8326902632352643231&amp;dp-callid=0&amp;size=c710_u400&amp;quality=100&amp;vuk=-&amp;ft=video" alt="image-20191225234547126" style="zoom:200%;" />

* 多线程开发的本质是在于多个线程可以进行同一资源的抢占。

