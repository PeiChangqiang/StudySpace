package com.pcq.basic.jmockit.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Mock;
import mockit.MockUp;

/**
 * 该类用于测试 Mock接口时的一些常见用法
 * @author Administrator
 *
 */
public class MockInterface {

	@Injectable
	OrdinaryInterface inter;//这里需要Jmockit帮忙创建接口的一个实例
	//1.通过Expectations 
	@Test
	public void testMockInterfaceByExpectations() {
		
		new Expectations() {
			{
				inter.method1();
				result = 10;
				inter.method2();
				result = 20;
			}
		};
		Assert.assertTrue(10 == inter.method1());
		Assert.assertTrue(20 == inter.method2());
	}
	
	//2.通过MockUp
	@Test
	public void testMockInterfaceByMockUp() {
		OrdinaryInterface inter = new MockUp<OrdinaryInterface>(OrdinaryInterface.class) {
			@Mock
			public int method1() {
				return 10;
			}
			
			@Mock
			public int method2() {
				return 20;
			}
		}.getMockInstance();
		
		Assert.assertTrue(10 == inter.method1());
		Assert.assertTrue(20 == inter.method2());
	}
}


interface OrdinaryInterface {
	int method1();
	int method2();
}