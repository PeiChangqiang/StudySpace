package com.pcq.basic.jmockit;



import org.testng.Assert;
import org.testng.annotations.Test;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import mockit.Verifications;

public class JmockitStudyTest {

	@Mocked
	MockObject mo;
	
	@Mocked
	InterfaceMockObject im;
	
	@Mocked 
	AbsMockObject am;
	

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
	
	@Test
	public void testMockedClass() {
		Assert.assertTrue(null == MockObject.sayGoodbye());//静态方法返回String类型的返回null
		Assert.assertTrue(null == mo.sayHaha());//普通方法返回String类型的还是null
		MockObject m = new MockObject();
		Assert.assertTrue(null == m.sayHaha());//自己new出来的对象 方法还是返回null
	}
	
	@Test
	public void testSayHello() {
		Assert.assertTrue(null == am.getName());//抽象类被Mock，返回String类型的返回null
		am.sayHello();//抽象方法也可以被调用
		Assert.assertTrue(null != am.getComponentObject());//返回非String类型的对象时，也会被JMockit mock出来
		Assert.assertTrue(null == am.getComponentObject().getComponent());//被mock出来的对象返回String类型的方法还是返回null
	}
	
	@Injectable 
	Component component;
	@Test
	public void testInjectable() {
		Assert.assertTrue(null != Component.fetchComponent());//静态方法并没有mock
		Assert.assertTrue(null == component.getComponent());//非静态方法返回String的依然返回null
		Component c = new Component();//自己new的也没有被mock
		Assert.assertTrue(null != c.getComponent());
	}
}
