package com.pcq.basic.jmockit.senior;

import org.testng.Assert;
import org.testng.annotations.Test;

import mockit.Expectations;

/**
 * ���������ظ�Mockͬһ�����������ǶԷ���ֵ�Ŀ��Ʋ�ͬ
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
				result = new int[] {10, 20, 30};//ÿ�ε��ö�����������±����η���
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
