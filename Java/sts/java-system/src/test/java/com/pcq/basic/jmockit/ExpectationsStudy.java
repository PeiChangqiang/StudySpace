package com.pcq.basic.jmockit;

import java.util.Locale;

import org.testng.Assert;
import org.testng.annotations.Test;

import mockit.Expectations;

//Expectations的主要目的是录制，但录制的方式有两种
public class ExpectationsStudy {

	//1、通过引用外部Mock的对象来录制
	
	
	//2.通过构造函数注入对象或者类来录制
	@Test
	public void testLocaleWithConstructor() {
		//这里使用Locale的构造函数Locale(String language, String country);
		Locale loc = new Locale("zh", "CN");
		//a.通过注入类，影响这个类所有实例被录制的方法
		new Expectations(Locale.class) {
			{
				loc.getLanguage();
				result = "xx";
			}
		};
		//被录制过，因此返回xx
		Assert.assertTrue("xx".equals(loc.getLanguage()));
	    //没被录制过，因此返回CN。
		Assert.assertTrue("CN".equals(loc.getCountry()));
		
		Locale loc2 = new Locale("abc", "DE");//重新实例化一个对象
		Assert.assertTrue("xx".equals(loc2.getLanguage()));//被录制的方法还是返回录制的结果
		Assert.assertTrue("DE".equals(loc2.getCountry()));//未被录制的方法则无影响
	}
	
	@Test
	public void testLocaleWithConstructor2() {
		Locale loc = new Locale("zh", "CN");
		//b.通过注入对象，此时只影响这一个实例被录制的方法
		new Expectations(loc) {
			{
				loc.getLanguage();
				result = "xx";
			}
		};
		//被录制过，因此返回xx
		Assert.assertTrue("xx".equals(loc.getLanguage()));
	    //没被录制过，因此返回CN。
		Assert.assertTrue("CN".equals(loc.getCountry()));
		
		Locale loc2 = new Locale("abc", "DE");//重新实例化一个对象
		Assert.assertTrue("abc".equals(loc2.getLanguage()));//新实例不受录制的影响
		Assert.assertTrue("DE".equals(loc2.getCountry()));
	}
}




