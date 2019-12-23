# Lamda表达式

## 一、由来

* 由于Java是结构化的编程语言，因此编程常常非常繁琐，为了简化开发过程，在**<font color='red'>Java1.8</font>**开始提供了函数式编程的概念。这就是Lamda表达式。
* Lamda表达式使用条件是必须**只有一个方法**的接口。可以通过注解@FunctionalInterface说明。

```java
@FunctionalInterface
interface LambdaInterface {
	void print(String str);
	
	public static void main(String[] args) {
		LambdaInterface li = (str) -> {
			System.out.println(str);
		};
		li.print("函数式编程");
	}
}
```



## 二、Lamda表达式使用格式

* 没有参数：()->{};
* 有参数：(param...)->{};
* 只有一个返回语句：()->statement;

```java
(t1,t2) -> t1 + t2; 
```



## 三、方法引用

* 在jdk1.8之后，除了引用数据类型，方法也可以有引用。即方法也看做是一个对象。
* 方法引用这一概念可以给方法定义多个名字。即为函数式接口中定义的方法名。

### 方法引用的四种方式

#### (1)引用静态方法：类名称::static 方法名称

```java
//使用String类的静态方法ValueOf
@FunctionalInterface
interface IFunc<T,P> {
	public static void main(String[] args) {
		IFunc<String, Integer> fun = String :: valueOf;
		String str = fun.change(10);
		System.out.println(str.length());
	}
	T change(P p);
}
```

#### (2)引用某个实例对象的方法：实例化对象::普通方法

```java
//使用对象的方法引用
@FunctionalInterface
interface IFunc2<T> {

	T upper();
	
	public static void main(String[] args) {
		IFunc2<String> fun = "hello world" :: toUpperCase;
		fun.upper();
	}
}
```

#### (3)引用特定类型的方法：特定类::普通方法;

```java
@FunctionalInterface
interface IFunc3 {
	String lower(String s);
	
	public static void main(String[] args) {
		IFunc3 fun = String :: toLowerCase;
		String str = fun.lower("HELLO WORLD");
		System.out.println(str);
	}
}
```

#### (4)引用构造方法：类名称::new;

```java

//构造方法引用
interface IFunc4<T> {
	T create(String name, Integer age);
}

class Person {
	private String name;
	private Integer age;
	
	public static void main(String[] args) {
		IFunc4<Person> func = Person :: new;
		Person p = func.create("张三", 20);
		System.out.println(p);
	}
	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	public String toString() {
		return "姓名：" + this.name + "、年龄：" + this.age;
	}
}
```



## 四、内建函数式接口

