# JMockit

## 一、JMockit程序结构

* 代码

```java
package com.pcq.basic;
import org.testng.Assert;
import org.testng.annotations.Test;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;

public class JmockitStudyTest {
	@Mocked
	MockObject mo;
	@Test
	public void testSayHaha() {
		//录制
		new Expectations() {
			{
				mo.sayHaha();
				result = "haha";//期待的返回值
			}
		};
		//重放
		String haha = mo.sayHaha();
		Assert.assertTrue(haha.equals("haha"));
		//验证
		new Verifications() {
			{
				mo.sayHaha();
				//验证mo.sayHaha()这个方法被调用了一次
				times = 1;
			}
		};
	}
	
}


class MockObject {
	
	public String sayHaha() {
		return "haha";
	}
}
```

**JMockit的程序结构主要由 录制、重放、验证三部分组成。**



## 二、JMocikt API的使用

### 1.@Mocked

* 当Mocked Mock一个类时，该类的行为就已经交给了JMockit接管。

```java
//@Mocked修饰普通类
@Mocked
MockObject mo;
@Test
public void testMockedClass() {
    Assert.assertTrue(null == MockObject.sayGoodbye());//静态方法返回String类型的返回null
    Assert.assertTrue(null == mo.sayHaha());//普通方法返回String类型的还是null
    MockObject m = new MockObject();
    Assert.assertTrue(null == m.sayHaha());//自己new出来的对象 方法还是返回null
}

```

* @Mocked也可以Mock抽象类或者是接口，但是Mock抽象类时，该抽象类必须是public。

```java
/**
 * 抽象Mock类
 * @author Administrator
 *
 */
public abstract class AbsMockObject {
	public void sayHello() {
		System.out.println("hello, " + getName());
	}
	
	public static String getUpperName(String name) {
		return name.toUpperCase();
	}
	public abstract String getName();
	
	public Component getComponentObject() {
		return new Component();
	}
}

//Mock抽象类
@Mocked 
AbsMockObject am;
@Test
public void testSayHello() {
    Assert.assertTrue(null == am.getName());//抽象类被Mock，返回String类型的返回null
    am.sayHello();//抽象方法也可以被调用
    Assert.assertTrue(null != am.getComponentObject());//返回非String类型的对象时，也会被JMockit mock出来
    Assert.assertTrue(null == am.getComponentObject().getComponent());//被mock出来的对象返回String类型的方法还是返回null
}
```

*  通过上述例子，可以看出：@Mocked修饰的类/接口，是告诉JMockit，帮我生成一个Mocked对象，这个对象方法（包含静态方法)返回默认值。
  即如果返回类型为原始类型(short,int,float,double,long)就返回0，如果返回类型为String就返回null，如果返回类型是其它引用类型，则返回这个引用类型的Mocked对象（这一点，是个递归的定义，需要好好理解一下）。



### 2.@Tested & @Injectable

#### （1）@Injectable

```java
@Injectable 
Component component;
@Test
public void testInjectable() {
    Assert.assertTrue(null != Component.fetchComponent());//静态方法并没有mock
    Assert.assertTrue(null == component.getComponent());//非静态方法返回String的依然返回null
    Component c = new Component();//自己new的也没有被mock
    Assert.assertTrue(null != c.getComponent());
}
```

* 这说明**Injectable只针对被它修饰类的某个实例**，而Mocked针对的是类，即这个类的所有实例（包括静态方法）都被mock。而且Injectable对静态方法和构造函数都没有影响，因为静态方法和构造函数是类级别的。	

#### （2）@Tested

```java

public class TestedStudyTest {

	@Tested
	BusinessServiceImpl service;//需要测试的对象，我们要测试它的doBusiness方法。JMockit会实例化它
	
	//测试对象依赖的两个接口,JMockit依然会帮我们实例化它们，并且注入到我们要测试对象的属性中。
	@Injectable
	IVerifyService verifyService; 
	
	@Injectable
	ISendMsgService sendMsgService;
	@Test
	public void testDoBusiness() {
		new Expectations() {//这里并不需要真的去验证，真的去发送消息。因此录制，假设验证成功，消息也发送没问题。
			{
				verifyService.verify();
				result = true;
				sendMsgService.sendMsg();
			}
		};
		Assert.assertTrue(service.doBusiness());//测试真正想要测试的代码
	}
	
}


class BusinessServiceImpl implements IBusinessService {

	private IVerifyService verifyService;
	
	private ISendMsgService sendMsgService;
	
	public boolean doBusiness() {
		// TODO Auto-generated method stub
		if(!verifyService.verify()) {
			return false;
		}
		//doBusiness业务逻辑
		System.out.println("处理业务逻辑。。。。");
		
		//业务逻辑处理完后发送消息
		sendMsgService.sendMsg();
		return true;
	}
	
}

//业务逻辑接口
interface IBusinessService {
	boolean doBusiness();
}

//验证接口
interface IVerifyService {
	boolean verify();
}

//发送消息接口
interface ISendMsgService {
	void sendMsg();
}
```

* Tested修饰的是我们要测试的对象，当它依赖其它对象时，使用Injectable修饰，则可以将修饰的对象通过依赖注入到Tested对象的属性中。

### 3.Expectations

* 引用外部类的Mock对象来录制

这种方式被Mock的对象的所有行为都会被JMockit接管（@Mocked接管类的所有实例的所有行为；@Injectable只接管某个实例的行为，不包括类级别的行为）

* 通过构造函数注入类或者对象来录制

这种录制方式只影响被录制的方法的行为，未被录制的方法的行为则不受影响（注入类则接管类所有实例被录制的方法，注入对象则只接管该实例被录制的方法）

```java
//Expectations的主要目的是录制，但录制的方式有两种
public class ExpectationsStudy {

	//1、通过引用外部Mock的对象来录制(@Mocked, @Injectable, @Capturing)
	//之前的代码有说明，。这里省略
	
	//2.通过构造函数注入对象或者类来录制
    //
	@Test
	public void testLocaleWithConstructor() {
		//这里使用Locale的构造函数Locale(String language, String country);
		Locale loc = new Locale("zh", "CN");
		//a.通过注入类，影响这个类所有实例被录制的方法
		new Expectations(Locale.class) {
			{
				loc.getLanguage();
				result = "xx";
			}
		};
		//被录制过，因此返回xx
		Assert.assertTrue("xx".equals(loc.getLanguage()));
	    //没被录制过，因此返回CN。
		Assert.assertTrue("CN".equals(loc.getCountry()));
		
		Locale loc2 = new Locale("abc", "DE");//重新实例化一个对象
		Assert.assertTrue("xx".equals(loc2.getLanguage()));//被录制的方法还是返回录制的结果
		Assert.assertTrue("DE".equals(loc2.getCountry()));//未被录制的方法则无影响
	}
	
	@Test
	public void testLocaleWithConstructor2() {
		Locale loc = new Locale("zh", "CN");
		//b.通过注入对象，此时只影响这一个实例被录制的方法
		new Expectations(loc) {
			{
				loc.getLanguage();
				result = "xx";
			}
		};
		//被录制过，因此返回xx
		Assert.assertTrue("xx".equals(loc.getLanguage()));
	    //没被录制过，因此返回CN。
		Assert.assertTrue("CN".equals(loc.getCountry()));
		
		Locale loc2 = new Locale("abc", "DE");//重新实例化一个对象
		Assert.assertTrue("abc".equals(loc2.getLanguage()));//新实例不受录制的影响
		Assert.assertTrue("DE".equals(loc2.getCountry()));
	}
}
```

### 4.MockUp & @Mock

```java
public class TestMockUp {

	@Test
	public void testMockUp() {
		new MockUp<MockUpObject>(MockUpObject.class) {//传入被测试类到MockUp的构造函数中
			@Mock //配合@Mock想录制哪个行为就录制Mock哪个行为，未录制的行为不受影响
			public String getName(String name) {
				if(name == "") {
					return "空字符串";
				}
				if(name == "1") {
					return "a";
				}
				return "testMockUp";
			}
		};
		MockUpObject mu = new MockUpObject();
		Assert.assertTrue("空字符串".equals(mu.getName("")));
		Assert.assertTrue("a".equals(mu.getName("1")));
		Assert.assertTrue("男".equals(mu.getSex("男")));
	}
}

class MockUpObject {
	public String getName() {
		return "";
	}
	
	public String getName(String name) {
		return "名字：" + name;
	}
	
	public String getName(String name, String sex) {
		return "名字：" + name + ";姓名：" + sex;
 	}
	
	public String getSex(String sex) {
		return sex;
	}
}

```

* MockUp相比于Expectations对行为的Mock更加灵活，但有时候必须得用Expectations。一般来说，对简单重复方法的录制可以考虑MockUp。

### 5.Verifications

* 该内部类用于验证方法有没有被调用，以及调用了多少次。但实际情况中，很少关心方法有没有被调用或者被调用多少次，而是关心方法被调用后是不是我们想要的结果，因此该内部类运用的不是很多。

```java
public class VerificationsStudy {

	@Test
	public void testVerifications() {
		Calendar cal = Calendar.getInstance();
		//录制
		new Expectations(Calendar.class) {
			{
				cal.get(Calendar.DAY_OF_MONTH);
				result = 1;
			}
		};

		//回放
		Assert.assertTrue(1 == cal.get(Calendar.DAY_OF_MONTH));
		cal.getFirstDayOfWeek();
		cal.getFirstDayOfWeek();
		
		//验证
		new Verifications() {
			{
				cal.get(anyInt);//验证该方法被调用了
				times = 1; //限定该方法只调用了一次，限定不是必须的
				cal.getFirstDayOfWeek();//验证该方法被调用了
				times = 2;//限定该方法调用了两次 ，当然限定不是必须的
			}
		};
	}
}
```



