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


}
