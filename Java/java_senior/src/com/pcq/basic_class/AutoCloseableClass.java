package com.pcq.basic_class;



/**
 * autocloseable 的通道自动关闭功能 必须和try一起联用，才会自动调用
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
		System.out.println("消息通道关闭。。。。");
	}
	
}
