package com.pcq.basic.jmockit.senior;

import org.testng.Assert;
import org.testng.annotations.Test;

import mockit.Mock;
import mockit.MockUp;

/**
 * 该类用于测试Mock泛型
 * @author Administrator
 *
 */
public class MockGenerics {

	
	@Test
	public <T extends Inter> void testMockGenerics() {//通过传入泛型来模拟接口，就是mock这个类型的上限。
		new MockUp<T>() {
			@Mock
			public int m1() {
				return 10;
			}
			@Mock
			public int m2() {
				return 20;
			}
		};
		Inter i1 = new Inter() {
			@Override
			public int m1() {
				return 1;
			}
			@Override
			public int m2() {
				return 2;
			}
		};
		
		Inter i2 = new Inter() {
			@Override
			public int m1() {
				return 1;
			}
			@Override
			public int m2() {
				return 2;
			}
		};
		Assert.assertTrue(10 == i1.m1());
		Assert.assertTrue(20 == i1.m2());
		Assert.assertTrue(10 == i2.m1());
		Assert.assertTrue(20 == i2.m2());
	}
}



interface Inter {
	int m1();
	int m2();
}