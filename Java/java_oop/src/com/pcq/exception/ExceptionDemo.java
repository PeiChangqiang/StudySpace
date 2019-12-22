package com.pcq.exception;

public class ExceptionDemo {

	public static void main(String[] args) {
		try {
			int temp = Mymath.div(5,0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Mymath.testException();
		} catch (MyException e) {
			e.printStackTrace();
		}
	}
	
	

}



//标准异常格式
class Mymath {
	public static int div(int x, int y) throws Exception {
		int temp = 0;
		try {
			System.out.println("程序执行开始。。。");
			temp = x / y;
		} finally {
			System.out.println("程序执行结束。。。");
		}
		return temp;
	}
	
	public static int testException() throws MyException {
			throw new MyException("自己定义的异常。。。");
	}
}


//自定义异常
class MyException extends Exception {
	public MyException(String msg) {
		super(msg);
	}
}