package com.pcq.linearlist.stack;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StackCalcuFormular {

	public StackCalcuFormular() {
		// TODO �Զ����ɵĹ��캯�����
	}

	public static void main(String[] args) {
		ArrayStack dataStack = new ArrayStack(10);
		ArrayStack calcuStack = new ArrayStack(10);
		String formula = "23*5+3-9/3";
		String[] datas = getDatas(formula);
		StringBuffer sb = getOpr(formula);
		for(int i = 0; i < datas.length; i++) {
			dataStack.push(datas[i]);
			String opr = calcuStack.pop();
			if(i == sb.length()) {//˵�����㵽���һ����������
				String num1 = dataStack.pop();
				String num2 = dataStack.pop();
				int result = calcu(num1, num2, opr);
				System.out.println(result);
				break;
			} 
			String sbOpr = sb.substring(i,i+1);
			if(opr != null) {
				boolean flag = compareOpr(sbOpr,opr);
				if(flag) {//������1���ڲ�����2��ѹջ����
					calcuStack.push(opr);
					calcuStack.push(sbOpr);
				} else {//����С��������ȡ������������
					String num1 = dataStack.pop();
					String num2 = dataStack.pop();
					int r = calcu(num1, num2, opr);
					
					dataStack.push("" + r);
				}
			} else {
				calcuStack.push(sbOpr);
			}
		}
	}

	//����
	static int calcu(String num1, String num2, String opr) {
		int x = Integer.valueOf(num1);
		int y = Integer.valueOf(num2);
		int r;
		if("+".equals(opr)) 
			r = x + y;
		else if("-".equals(opr)) 
			r = x - y;
		else if("*".equals(opr)) 
			r = x * y;
		else if("/".equals(opr)) 
			r = x / y;
		else 
			throw new RuntimeException("�Ҳ���������");
		return r;
	}
	
	//����true������һ���ڲ�������
	static boolean compareOpr(String opr1, String opr2) {
		if(getOprLevel(opr1) > getOprLevel(opr2)) {
			return true;
		} else {
			return false;
		}
	}
	
	//��ȡ������ȼ�������Ӽ���һ�����˳��Ƕ���
	static int getOprLevel(String opr) {
		if("+".equals(opr) || "-".equals(opr)) {
			return 1;
		}
		if("*".equals(opr) || "/".equals(opr)) {
			return 2;
		}
		return -1;
	}
	
	//��ȡ������
	static String[] getDatas(String formula) {
		Pattern p = Pattern.compile("[=��%*/+-]");
		String[] strs = p.split(formula);
		return strs;
	}
	
	//��ȡ������
	static StringBuffer getOpr(String formula) {
		Pattern p = Pattern.compile("[=��%*/+-]");
		Matcher m = p.matcher(formula);
		StringBuffer sb = new StringBuffer();
		while(m.find()) {
			sb.append(m.group());
		}
		return sb;
	}
}
