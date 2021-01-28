package com.pcq.basic.jmockit.senior;

import org.testng.Assert;
import org.testng.annotations.Test;

import mockit.Mock;
import mockit.MockUp;

/**
 * 该类用于测试 Mock构造函数和代码块时的 使用方式
 * @author Administrator
 *
 */
public class MockConstructorAndBlock {

	
	public static class StaticMockClassWithBlock extends MockUp<MockClassWithBlock> {//构造中间静态类
		@Mock
		public void $init(int i) {//函数名$init 代表的就是模拟类的构造函数
			
		}
		
		@Mock
		public void $clinit() {//函数名$clinit代表的就是静态代码块
			
		}
	}
	
	@Test
	public void testMockClassWithBlock() {
		new StaticMockClassWithBlock();//实例化中间静态类
		MockClassWithBlock instance = new MockClassWithBlock(20);//实例化被测试的类
		Assert.assertTrue(0 == instance.getI());
		Assert.assertTrue(0 == MockClassWithBlock.j);
	}
}



class MockClassWithBlock {
	private int i;
	static int j;
	
	{
		i = 10;
	}
	
	static {//静态代码块
		j = 20;
	}
	
	public MockClassWithBlock(int i) {
		this .i = i;
	}
	
	public int getI() {
		return i;
	}
	
	public void setI(int i) {
		this.i = i;
	}
}
