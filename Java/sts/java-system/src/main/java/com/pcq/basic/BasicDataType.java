package com.pcq.basic;

import com.pcq.util.Console;

public class BasicDataType {

	
	//�ַ���
	char c = '��';
	//������
	boolean flag = false;
	
	
	/**
	 * ��������-���ͣ�java�����з�������
	 */
	//1���ֽ�,8λ��ȡֵ��Χ:-2^7(-128) ~ 2^7-1(127) 
	byte b = 'b'; 
	//byte b1 = -129; byte b2 = 128; ����ȡֵ��Χ�����뱨��
	byte bMin = -128; byte bMax = 127;
	
	//2���ֽڣ�16λ��ȡֵ��Χ-2^15(-32768) ~ 2^15-1(32767)
	short s = 's';
	//short s1 = -32769; short s2 = 32768;����ȡֵ��Χ�����뱨��
	short sMin = -32768; short sMax = 32767;
	
	//4���ֽڣ�32λ
	int i = 'x';
	//8���ֽڣ�64λ
	long l = '��';
	
	/**
	 * ��������-������ 
	 * ��¼���ǽ���ֵ��������׼ȷֵ
	 * ��˽����������Ӧ����Bigdecimal�����Ǹ�����
	 */
	//������ 4���ֽ�
	float f = '��';
	//˫���� 8���ֽ�
	double d = '��';
	
	public void overFlow() {
		Console.print(Integer.MAX_VALUE + Integer.MAX_VALUE);//������������������������в������κ���ʾ�����߱���
		//short��������Զ�����ת��Ϊint
		Console.print(Short.MAX_VALUE + Short.MAX_VALUE);
		short s1 = Short.MAX_VALUE;
		short s2 = Short.MAX_VALUE;
		//short s3 = s1 + s2;//�������벻ͨ������ʾΪ�޷�ת��short�޷�ת��Ϊint
		Console.print(s1 + s2);
	}
}
