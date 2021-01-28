package com.pcq.basic.jmockit.senior;

import org.testng.Assert;
import org.testng.annotations.Test;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;

/**
 * �������ڲ��� һ���� ���ʵ����ϣ�����ʵ���в�ͬ��mock�߼�
 * @author Administrator
 *
 */
public class MockOneClassToSeveralInstance {

	//1.ʹ��Expectations
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
	
	//2.ʹ��@Mocked
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
		//���δ¼�Ƹ�ʵ����ĳ����������ô@Mocked���࣬��������ʵ���������ᱻ�ӹܣ���˷���Ĭ��ֵ
		TestClass t3 = new TestClass();
		Assert.assertTrue(0 == t3.getInt());
	}
	
	//3.ʹ��@Injectable
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
		//@InjectableֻӰ��ʵ�������t3����Ӱ��
		TestClass t3 = new TestClass();
		Assert.assertTrue(1 == t3.getInt());
	}
}


//������
class TestClass {
	public int getInt() {
		return 1;
	}
}
