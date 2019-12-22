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



//��׼�쳣��ʽ
class Mymath {
	public static int div(int x, int y) throws Exception {
		int temp = 0;
		try {
			System.out.println("����ִ�п�ʼ������");
			temp = x / y;
		} finally {
			System.out.println("����ִ�н���������");
		}
		return temp;
	}
	
	public static int testException() throws MyException {
			throw new MyException("�Լ�������쳣������");
	}
}


//�Զ����쳣
class MyException extends Exception {
	public MyException(String msg) {
		super(msg);
	}
}