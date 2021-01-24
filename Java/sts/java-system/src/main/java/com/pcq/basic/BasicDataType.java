package com.pcq.basic;

import com.pcq.util.Console;

public class BasicDataType {

	
	//字符型
	char c = '汗';
	//布尔型
	boolean flag = false;
	
	
	/**
	 * 数据类型-整型（java中是有符号数）
	 */
	//1个字节,8位，取值范围:-2^7(-128) ~ 2^7-1(127) 
	byte b = 'b'; 
	//byte b1 = -129; byte b2 = 128; 超出取值范围，编译报错
	byte bMin = -128; byte bMax = 127;
	
	//2个字节，16位；取值范围-2^15(-32768) ~ 2^15-1(32767)
	short s = 's';
	//short s1 = -32769; short s2 = 32768;超出取值范围，编译报错
	short sMin = -32768; short sMax = 32767;
	
	//4个字节，32位
	int i = 'x';
	//8个字节，64位
	long l = '哈';
	
	/**
	 * 数据类型-浮点型 
	 * 记录的是近似值，而不是准确值
	 * 因此金额这种数据应该用Bigdecimal而不是浮点数
	 */
	//单精度 4个字节
	float f = '呵';
	//双精度 8个字节
	double d = '嘿';
	
	public void overFlow() {
		Console.print(Integer.MAX_VALUE + Integer.MAX_VALUE);//溢出，如果发生溢出，代码运行不会有任何提示，或者报错。
		//short计算溢出自动向上转型为int
		Console.print(Short.MAX_VALUE + Short.MAX_VALUE);
		short s1 = Short.MAX_VALUE;
		short s2 = Short.MAX_VALUE;
		//short s3 = s1 + s2;//报错，编译不通过，提示为无法转型short无法转型为int
		Console.print(s1 + s2);
	}
}
