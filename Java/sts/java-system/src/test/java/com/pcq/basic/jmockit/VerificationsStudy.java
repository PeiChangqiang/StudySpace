package com.pcq.basic.jmockit;

import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Test;

import mockit.Expectations;
import mockit.Verifications;

public class VerificationsStudy {

	@Test
	public void testVerifications() {
		Calendar cal = Calendar.getInstance();
		//录制
		new Expectations(Calendar.class) {
			{
				cal.get(Calendar.DAY_OF_MONTH);
				result = 1;
			}
		};

		//回放
		Assert.assertTrue(1 == cal.get(Calendar.DAY_OF_MONTH));
		cal.getFirstDayOfWeek();
		cal.getFirstDayOfWeek();
		
		//验证
		new Verifications() {
			{
				cal.get(anyInt);//验证该方法被调用了
				times = 1; //限定该方法只调用了一次，限定不是必须的
				cal.getFirstDayOfWeek();//验证该方法被调用了
				times = 2;//限定该方法调用了两次 ，当然限定不是必须的
			}
		};
	}
}
