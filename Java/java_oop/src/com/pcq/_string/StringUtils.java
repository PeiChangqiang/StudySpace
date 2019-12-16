package com.pcq._string;

/**
 * 字符串对象常见的方法：
 * 1）toCharArray()：获得字符数组
 * 2）getBytes()：获得字节数组
 * 3）indexOf(str)：查找字符串位置
 * 4）compareTo(str) 比较字符串大小
 * 5）startsWith(str),endsWith(str)：是否以某字符串开头或者结尾
 * 6）replaceAll(),replaceFirst()：替换字符串
 * 7）split()：字符串拆分
 * 8）substring()：字符串截取，常常和indexOf联用
 * 9）其它方法 : isEmpty() 判断是否为空"";length()字符串长度;trim()去除左右的空格信息;
 * @author Administrator
 *
 */
public class StringUtils {

	public static void main(String[] args) {
		
		String str = "abcdefgh";
		System.out.println(isNumber(str) ? "是一个数字" : "不是一个数字");
		System.out.println(isNumber("3453") ? "是一个数字" : "不是一个数字");
		System.out.println("##sdfas$$".startsWith("##"));
		System.out.println("##sdfas$$".endsWith("#$$"));
		
		byte[] bytes = str.getBytes();
		for(byte b : bytes) {
			System.out.println(b);
		}
		
		System.out.println(initCap("peiCHangQiang"));
	}
	
	/**
	 * 首字母大写
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
	 * 如果字符串为null或者为空则返回true
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return null == str || "".equals(str);
	}
	
	/**
	 * 判断字符串是否由正整数组成
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
