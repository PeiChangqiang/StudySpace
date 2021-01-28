package com.pcq.basic.jmockit.senior;

import org.testng.Assert;
import org.testng.annotations.Test;

import mockit.Mock;
import mockit.MockUp;

/**
 * �������ڲ��� Mock���캯���ʹ����ʱ�� ʹ�÷�ʽ
 * @author Administrator
 *
 */
public class MockConstructorAndBlock {

	
	public static class StaticMockClassWithBlock extends MockUp<MockClassWithBlock> {//�����м侲̬��
		@Mock
		public void $init(int i) {//������$init ����ľ���ģ����Ĺ��캯��
			
		}
		
		@Mock
		public void $clinit() {//������$clinit����ľ��Ǿ�̬�����
			
		}
	}
	
	@Test
	public void testMockClassWithBlock() {
		new StaticMockClassWithBlock();//ʵ�����м侲̬��
		MockClassWithBlock instance = new MockClassWithBlock(20);//ʵ���������Ե���
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
	
	static {//��̬�����
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
