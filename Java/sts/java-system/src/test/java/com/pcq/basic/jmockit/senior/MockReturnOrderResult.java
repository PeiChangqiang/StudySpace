package com.pcq.basic.jmockit.senior;

import org.testng.Assert;
import org.testng.annotations.Test;

import mockit.Expectations;

/**
 * 该类用于重复Mock同一个方法，但是对返回值的控制不同
 * @author Administrator
 *
 */
public class MockReturnOrderResult {
	
	@Test
	public void testMethod() {
		Case c = new Case();
		new Expectations(Case.class) {
			{
				c.method();
				result = new int[] {10, 20, 30};//每次调用都按照数组的下标依次返回
			}
		};
		Assert.assertTrue(10 == c.method());
		Assert.assertTrue(20 == c.method());
		Assert.assertTrue(30 == c.method());
	}

}



class Case {
	public int method() {
		return 1;
	}
}
