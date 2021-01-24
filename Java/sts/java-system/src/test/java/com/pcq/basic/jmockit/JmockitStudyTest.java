package com.pcq.basic.jmockit;



import org.testng.Assert;
import org.testng.annotations.Test;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import mockit.Verifications;

public class JmockitStudyTest {

	@Mocked
	MockObject mo;
	
	@Mocked
	InterfaceMockObject im;
	
	@Mocked 
	AbsMockObject am;
	

	@Test
	public void testSayHaha() {
		//¼��
		new Expectations() {
			{
				mo.sayHaha();
				result = "haha";//�ڴ��ķ���ֵ
			}
		};
		//�ط�
		String haha = mo.sayHaha();
		Assert.assertTrue(haha.equals("haha"));
		
		//��֤
		new Verifications() {
			{
				mo.sayHaha();
				//��֤mo.sayHaha()���������������һ��
				times = 1;
			}
		};
	}
	
	@Test
	public void testMockedClass() {
		Assert.assertTrue(null == MockObject.sayGoodbye());//��̬��������String���͵ķ���null
		Assert.assertTrue(null == mo.sayHaha());//��ͨ��������String���͵Ļ���null
		MockObject m = new MockObject();
		Assert.assertTrue(null == m.sayHaha());//�Լ�new�����Ķ��� �������Ƿ���null
	}
	
	@Test
	public void testSayHello() {
		Assert.assertTrue(null == am.getName());//�����౻Mock������String���͵ķ���null
		am.sayHello();//���󷽷�Ҳ���Ա�����
		Assert.assertTrue(null != am.getComponentObject());//���ط�String���͵Ķ���ʱ��Ҳ�ᱻJMockit mock����
		Assert.assertTrue(null == am.getComponentObject().getComponent());//��mock�����Ķ��󷵻�String���͵ķ������Ƿ���null
	}
	
	@Injectable 
	Component component;
	@Test
	public void testInjectable() {
		Assert.assertTrue(null != Component.fetchComponent());//��̬������û��mock
		Assert.assertTrue(null == component.getComponent());//�Ǿ�̬��������String����Ȼ����null
		Component c = new Component();//�Լ�new��Ҳû�б�mock
		Assert.assertTrue(null != c.getComponent());
	}
}
