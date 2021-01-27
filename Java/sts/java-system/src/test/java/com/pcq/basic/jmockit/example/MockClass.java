package com.pcq.basic.jmockit.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;

/**
 * �������ڲ���Mock��ʱ�ĳ����÷�
 * @author Administrator
 *
 */
public class MockClass {

	//1.ͨ��Expectations��mock��
	@Test
	public void testMockClassByExpectations() {
		OrdinaryClass instance = new OrdinaryClass();//����¼�Ƶ���ͨ��
		new Expectations(OrdinaryClass.class) {
			{
				OrdinaryClass.staticMethod();
				result = 10;
				instance.finalMethod();
				result = 20;
				instance.ordinaryMethod();
				result = 30;
				//instance.privateMethod();private�����޷����ʣ���ȻҲ���޷���Expectations��mock
				//instance.nativeMethod();  native�����޷�mock
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
	
	
	//2.ͨ��MockUp��mock��
	public static class OrdinaryClassMockUp extends MockUp<OrdinaryClass> {
		@Mock
		public static int staticMethod() {//��̬����
			return 10;
		}
		
		@Mock
		public final int finalMethod() {//final����
			return 20;
		}
		
		@Mock
		public int nativeMethod() {//native����
			return 30;
		};

		@Mock
		private int privateMethod() {//private����
			return 40;
		}
		
		@Mock
		public int ordinaryMethod() {//��ͨ����
			return 50;
		}
	}
	
	@Test
	public void testMockClassByMockUp() {
		new OrdinaryClassMockUp();//��ʵ��������������м���
		OrdinaryClass instance = new OrdinaryClass();//��ʵ������Ҫ�طŵĲ�����
		Assert.assertTrue(10 == OrdinaryClass.staticMethod());
		Assert.assertTrue(20 == instance.finalMethod());
		Assert.assertTrue(30 == instance.nativeMethod());
		Assert.assertTrue(40 == instance.callPrivate());
		Assert.assertTrue(50 == instance.ordinaryMethod());
	}
}


//������һ����ͨ�࣬���и��ֲ�ͬ�ķ���
class OrdinaryClass {
	public static int staticMethod() {//��̬����
		return 0;
	}
	
	public final int finalMethod() {//final����
		return 1;
	}
	
	public native int nativeMethod();//native����

	private int privateMethod() {//private����
		return 2;
	}
	
	public int ordinaryMethod() {//��ͨ����
		return 3;
	}
	
	public int callPrivate() {//����˽�з�������ͨ����
		return privateMethod();
	}
}