package com.pcq.basic.jmockit;

import org.testng.Assert;
import org.testng.annotations.Test;

import mockit.Mock;
import mockit.MockUp;

public class TestMockUp {

	@Test
	public void testMockUp() {
		new MockUp<MockUpObject>(MockUpObject.class) {//传入被测试类到MockUp的构造函数中
			@Mock //配合@Mock想录制哪个行为就录制Mock哪个行为，未录制的行为不受影响
			public String getName(String name) {
				if(name == "") {
					return "空字符串";
				}
				if(name == "1") {
					return "a";
				}
				return "testMockUp";
			}
		};
		MockUpObject mu = new MockUpObject();
		Assert.assertTrue("空字符串".equals(mu.getName("")));
		Assert.assertTrue("a".equals(mu.getName("1")));
		Assert.assertTrue("男".equals(mu.getSex("男")));
	}
}



class MockUpObject {
	public String getName() {
		return "";
	}
	
	public String getName(String name) {
		return "名字：" + name;
	}
	
	public String getName(String name, String sex) {
		return "名字：" + name + ";姓名：" + sex;
 	}
	
	public String getSex(String sex) {
		return sex;
	}
}
