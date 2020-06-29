package com.pcq._string;

/**
 * �ַ������󳣼��ķ�����
 * 1��toCharArray()������ַ�����
 * 2��getBytes()������ֽ�����
 * 3��indexOf(str)�������ַ���λ��
 * 4��compareTo(str) �Ƚ��ַ�����С
 * 5��startsWith(str),endsWith(str)���Ƿ���ĳ�ַ�����ͷ���߽�β
 * 6��replaceAll(),replaceFirst()���滻�ַ���
 * 7��split()���ַ������
 * 8��substring()���ַ�����ȡ��������indexOf����
 * 9���������� : isEmpty() �ж��Ƿ�Ϊ��"";length()�ַ�������;trim()ȥ�����ҵĿո���Ϣ;
 * @author Administrator
 *
 */
public class StringUtils {

	public static void main(String[] args) {
		
		String str = "abcdefgh";
		System.out.println(isNumber(str) ? "��һ������" : "����һ������");
		System.out.println(isNumber("3453") ? "��һ������" : "����һ������");
		System.out.println("##sdfas$$".startsWith("##"));
		System.out.println("##sdfas$$".endsWith("#$$"));
		
		byte[] bytes = str.getBytes();
		for(byte b : bytes) {
			System.out.println(b);
		}
		
		System.out.println(initCap("peiCHangQiang"));
		
		String s = "want you to know one thing";
		char n = 'n';
		char o = 'o';
		int i = getCharCount(s, n);
		int j = getCharCount(s, o);
		System.out.println("n���ֵĴ�����" + i + ",o���ֵĴ�����" + j);
	}
	
	/**
	 * ����ĸ��д
	 * @param str
	 * @return
	 */
	public static String initCap(String str) {
		if(isEmpty(str))
			return str;
		if(str.length() == 1) {
			return str.toUpperCase();
		}
		return str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase();
	}
	
	/**
	 * ����ַ���Ϊnull����Ϊ���򷵻�true
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return null == str || "".equals(str);
	}
	
	/**
	 * �ж��ַ����Ƿ������������
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str) {
			if(isEmpty(str)) {
				return false;
			}
		char[] chars = str.toCharArray();
		for(char c : chars) {
			if(c < '0' || c > '9') {
				return false;
			}
		}
		return true;
	}


	/**
	 *ͳ��char ��str�г��ֵĴ���
	 * @param str
	 * @param ch
	 * @return
	 */
	public static int getCharCount(String str, char ch) {
		if(isEmpty(str)) 
			return -1;
		char[] chars = str.toCharArray();
		int count = 0;
		for(char cha : chars) {
			if(cha == ch) {
				count++;
			}
		}
		return count;
	}
}
