package com.pcq.basic.jmockit.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;

/**
 * 该类用于测试Mock类时的常见用法
 * @author Administrator
 *
 */
public class MockClass {

	//1.通过Expectations来mock类
	@Test
	public void testMockClassByExpectations() {
		OrdinaryClass instance = new OrdinaryClass();//用于录制的普通类
		new Expectations(OrdinaryClass.class) {
			{
				OrdinaryClass.staticMethod();
				result = 10;
				instance.finalMethod();
				result = 20;
				instance.ordinaryMethod();
				result = 30;
				//instance.privateMethod();private方法无法访问，自然也就无法在Expectations中mock
				//instance.nativeMethod();  native方法无法mock
				//result = 40;
				instance.callPrivate();
				result = 50;
			}
		};
		OrdinaryClass ins = new OrdinaryClass();
		Assert.assertTrue(10 == OrdinaryClass.staticMethod());
		Assert.assertTrue(20 == ins.finalMethod());
		Assert.assertTrue(30 == ins.ordinaryMethod());
		Assert.assertTrue(50 == ins.callPrivate());
	}
	
	
	//2.通过MockUp来mock类
	public static class OrdinaryClassMockUp extends MockUp<OrdinaryClass> {
		@Mock
		public static int staticMethod() {//静态方法
			return 10;
		}
		
		@Mock
		public final int finalMethod() {//final方法
			return 20;
		}
		
		@Mock
		public int nativeMethod() {//native方法
			return 30;
		};

		@Mock
		private int privateMethod() {//private方法
			return 40;
		}
		
		@Mock
		public int ordinaryMethod() {//普通方法
			return 50;
		}
	}
	
	@Test
	public void testMockClassByMockUp() {
		new OrdinaryClassMockUp();//先实例化构造出来的中间类
		OrdinaryClass instance = new OrdinaryClass();//再实例化需要回放的测试类
		Assert.assertTrue(10 == OrdinaryClass.staticMethod());
		Assert.assertTrue(20 == instance.finalMethod());
		Assert.assertTrue(30 == instance.nativeMethod());
		Assert.assertTrue(40 == instance.callPrivate());
		Assert.assertTrue(50 == instance.ordinaryMethod());
	}
}


//假设有一个普通类，它有各种不同的方法
class OrdinaryClass {
	public static int staticMethod() {//静态方法
		return 0;
	}
	
	public final int finalMethod() {//final方法
		return 1;
	}
	
	public native int nativeMethod();//native方法

	private int privateMethod() {//private方法
		return 2;
	}
	
	public int ordinaryMethod() {//普通方法
		return 3;
	}
	
	public int callPrivate() {//调用私有方法的普通方法
		return privateMethod();
	}
}