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
		//¼��
		new Expectations(Calendar.class) {
			{
				cal.get(Calendar.DAY_OF_MONTH);
				result = 1;
			}
		};

		//�ط�
		Assert.assertTrue(1 == cal.get(Calendar.DAY_OF_MONTH));
		cal.getFirstDayOfWeek();
		cal.getFirstDayOfWeek();
		
		//��֤
		new Verifications() {
			{
				cal.get(anyInt);//��֤�÷�����������
				times = 1; //�޶��÷���ֻ������һ�Σ��޶����Ǳ����
				cal.getFirstDayOfWeek();//��֤�÷�����������
				times = 2;//�޶��÷������������� ����Ȼ�޶����Ǳ����
			}
		};
	}
}
