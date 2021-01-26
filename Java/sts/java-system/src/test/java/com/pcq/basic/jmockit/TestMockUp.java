package com.pcq.basic.jmockit;

import org.testng.Assert;
import org.testng.annotations.Test;

import mockit.Mock;
import mockit.MockUp;

public class TestMockUp {

	@Test
	public void testMockUp() {
		new MockUp<MockUpObject>(MockUpObject.class) {//���뱻�����ൽMockUp�Ĺ��캯����
			@Mock //���@Mock��¼���ĸ���Ϊ��¼��Mock�ĸ���Ϊ��δ¼�Ƶ���Ϊ����Ӱ��
			public String getName(String name) {
				if(name == "") {
					return "���ַ���";
				}
				if(name == "1") {
					return "a";
				}
				return "testMockUp";
			}
		};
		MockUpObject mu = new MockUpObject();
		Assert.assertTrue("���ַ���".equals(mu.getName("")));
		Assert.assertTrue("a".equals(mu.getName("1")));
		Assert.assertTrue("��".equals(mu.getSex("��")));
	}
}



class MockUpObject {
	public String getName() {
		return "";
	}
	
	public String getName(String name) {
		return "���֣�" + name;
	}
	
	public String getName(String name, String sex) {
		return "���֣�" + name + ";������" + sex;
 	}
	
	public String getSex(String sex) {
		return sex;
	}
}
