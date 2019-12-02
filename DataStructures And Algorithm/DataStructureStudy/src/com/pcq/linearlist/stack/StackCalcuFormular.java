package com.pcq.linearlist.stack;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StackCalcuFormular {

	public StackCalcuFormular() {
		// TODO 自动生成的构造函数存根
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
			if(i == sb.length()) {//说明计算到最后一个操作数了
				String num1 = dataStack.pop();
				String num2 = dataStack.pop();
				int result = calcu(num1, num2, opr);
				System.out.println(result);
				break;
			} 
			String sbOpr = sb.substring(i,i+1);
			if(opr != null) {
				boolean flag = compareOpr(sbOpr,opr);
				if(flag) {//操作符1大于操作符2，压栈操作
					calcuStack.push(opr);
					calcuStack.push(sbOpr);
				} else {//等于小于它，则取出操作数运算
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

	//运算
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
			throw new RuntimeException("找不到操作符");
		return r;
	}
	
	//返回true操作符一大于操作符二
	static boolean compareOpr(String opr1, String opr2) {
		if(getOprLevel(opr1) > getOprLevel(opr2)) {
			return true;
		} else {
			return false;
		}
	}
	
	//获取运算符等级，这里加减是一级，乘除是二级
	static int getOprLevel(String opr) {
		if("+".equals(opr) || "-".equals(opr)) {
			return 1;
		}
		if("*".equals(opr) || "/".equals(opr)) {
			return 2;
		}
		return -1;
	}
	
	//获取操作数
	static String[] getDatas(String formula) {
		Pattern p = Pattern.compile("[=√%*/+-]");
		String[] strs = p.split(formula);
		return strs;
	}
	
	//获取操作符
	static StringBuffer getOpr(String formula) {
		Pattern p = Pattern.compile("[=√%*/+-]");
		Matcher m = p.matcher(formula);
		StringBuffer sb = new StringBuffer();
		while(m.find()) {
			sb.append(m.group());
		}
		return sb;
	}
}
