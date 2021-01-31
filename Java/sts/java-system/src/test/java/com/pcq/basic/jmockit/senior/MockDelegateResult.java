package com.pcq.basic.jmockit.senior;

import org.testng.Assert;
import org.testng.annotations.Test;

import mockit.Delegate;
import mockit.Expectations;
import mockit.Invocation;

/**
 * �������ڲ��Ը��ݲ�����ͬ���ز�ͬ�����mock
 * @author Administrator
 *
 */
public class MockDelegateResult {

	
	@Test
	@SuppressWarnings("all")
	public void testGetStr() {
		new Expectations(T.class) {
			{
				T t = new T();
				t.getStr(anyString);
				result = new Delegate() {
					String delegate(Invocation inv, String param) {
						if("x".equals(param)) {
							return "hehe";
						}
						return inv.proceed(param);
					}
				};
			}
		};
		T t = new T();
		//������getStr()ʱ����ʵ�ǵ��õ�delegate
		Assert.assertTrue("hehe".equals(t.getStr("x")));
		Assert.assertTrue("test : y".equals(t.getStr("y")));
	}
}

class T {
	public String getStr(String x) {
		return "test : " + x;
	}
}
