package com.pcq.basic_class;



/**
 * autocloseable ��ͨ���Զ��رչ��� �����tryһ�����ã��Ż��Զ�����
 * since jdk 1.7
 * @author Administrator
 *
 */
public class AutoCloseableClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try(Message m = new Message()) {
			
		} catch(Exception e) {
			
		}
	}

}


class Message implements AutoCloseable {

	
	
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("��Ϣͨ���رա�������");
	}
	
}
