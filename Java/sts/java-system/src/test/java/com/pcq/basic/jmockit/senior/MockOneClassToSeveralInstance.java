package com.pcq.basic.jmockit.senior;

import org.testng.Assert;
import org.testng.annotations.Test;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;

/**
 * 该类用于测试 一个类 多个实例但希望多个实例有不同的mock逻辑
 * @author Administrator
 *
 */
public class MockOneClassToSeveralInstance {

	//1.使用Expectations
	@Test
	public void testWithExpectations() {
		TestClass t1 = new TestClass();
		TestClass t2 = new TestClass();
		new Expectations(t1, t2) {
			{
				t1.getInt();
				result = 10;
				t2.getInt();
				result = 20;
			}
		};
		Assert.assertTrue(10 == t1.getInt());
		Assert.assertTrue(20 == t2.getInt());
	}
	
	//2.使用@Mocked
	@Mocked TestClass t1;
	@Mocked TestClass t2;
	@Test
	public void testWithMocked() {
		new Expectations() {
			{
				t1.getInt();
				result = 10;
				t2.getInt();
				result = 20;
			}
		};
		Assert.assertTrue(10 == t1.getInt());
		Assert.assertTrue(20 == t2.getInt());
		//如果未录制该实例的某个方法，那么@Mocked的类，它的所有实例方法都会被接管，因此返回默认值
		TestClass t3 = new TestClass();
		Assert.assertTrue(0 == t3.getInt());
	}
	
	//3.使用@Injectable
	@Injectable TestClass t4;
	@Injectable TestClass t5;
	@Test
	public void testWithInjectable() {
		new Expectations() {
			{
				t4.getInt();
				result = 10;
				t5.getInt();
				result = 20;
			}
		};
		Assert.assertTrue(10 == t4.getInt());
		Assert.assertTrue(20 == t5.getInt());
		//@Injectable只影响实例，因此t3不受影响
		TestClass t3 = new TestClass();
		Assert.assertTrue(1 == t3.getInt());
	}
}


//测试类
class TestClass {
	public int getInt() {
		return 1;
	}
}
