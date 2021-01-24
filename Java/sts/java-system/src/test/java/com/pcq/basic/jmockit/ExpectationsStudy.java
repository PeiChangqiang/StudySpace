package com.pcq.basic.jmockit;

import java.util.Locale;

import org.testng.Assert;
import org.testng.annotations.Test;

import mockit.Expectations;

//Expectations����ҪĿ����¼�ƣ���¼�Ƶķ�ʽ������
public class ExpectationsStudy {

	//1��ͨ�������ⲿMock�Ķ�����¼��
	
	
	//2.ͨ�����캯��ע������������¼��
	@Test
	public void testLocaleWithConstructor() {
		//����ʹ��Locale�Ĺ��캯��Locale(String language, String country);
		Locale loc = new Locale("zh", "CN");
		//a.ͨ��ע���࣬Ӱ�����������ʵ����¼�Ƶķ���
		new Expectations(Locale.class) {
			{
				loc.getLanguage();
				result = "xx";
			}
		};
		//��¼�ƹ�����˷���xx
		Assert.assertTrue("xx".equals(loc.getLanguage()));
	    //û��¼�ƹ�����˷���CN��
		Assert.assertTrue("CN".equals(loc.getCountry()));
		
		Locale loc2 = new Locale("abc", "DE");//����ʵ����һ������
		Assert.assertTrue("xx".equals(loc2.getLanguage()));//��¼�Ƶķ������Ƿ���¼�ƵĽ��
		Assert.assertTrue("DE".equals(loc2.getCountry()));//δ��¼�Ƶķ�������Ӱ��
	}
	
	@Test
	public void testLocaleWithConstructor2() {
		Locale loc = new Locale("zh", "CN");
		//b.ͨ��ע����󣬴�ʱֻӰ����һ��ʵ����¼�Ƶķ���
		new Expectations(loc) {
			{
				loc.getLanguage();
				result = "xx";
			}
		};
		//��¼�ƹ�����˷���xx
		Assert.assertTrue("xx".equals(loc.getLanguage()));
	    //û��¼�ƹ�����˷���CN��
		Assert.assertTrue("CN".equals(loc.getCountry()));
		
		Locale loc2 = new Locale("abc", "DE");//����ʵ����һ������
		Assert.assertTrue("abc".equals(loc2.getLanguage()));//��ʵ������¼�Ƶ�Ӱ��
		Assert.assertTrue("DE".equals(loc2.getCountry()));
	}
}




