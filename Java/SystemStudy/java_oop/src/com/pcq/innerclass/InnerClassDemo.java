package com.pcq.innerclass;

public class InnerClassDemo {
	public static void main(String[] args) {
		Outer out = new Outer();
		out.funInner();
		
		/**
		 * 编译时会生成内部类的class文件：Outer$Inner.class
		 * 实际上内部类的全称就是Outer.Inner
		 * 由于外部类和内部的属性可以互相直接访问，因此实例化内部类之前需要先实例化外部类。
		 * 如果内部类只允许外部类使用，则可以使用private修饰
		 */
		Outer.Inner in = new Outer().new Inner();
	}
}

class Outer {
	private String msg = "something";
	
	public void funInner() {
		Inner in = new Inner();
		in.print();
		System.out.println(in.privateStr);
	}
	
	class Inner {
		private String privateStr = "内部类私有属性";
		void print() {
			System.out.println(Outer.this.msg);
		}
	}
}



//接口中的内部接口
interface IChannel {
	void sendMsg(String msg);
	
	interface IMsg {
		String getContent();
	}
}

class ChannelImpl implements IChannel {

	public static void main(String[] args) {
		IChannel cha = new ChannelImpl();
		IMsg msgImpl = ((ChannelImpl)cha).new MsgImpl();
		msgImpl.getContent();
	}
	@Override
	public void sendMsg(String msg) {
		
	}
	
	class MsgImpl implements IMsg {

		@Override
		public String getContent() {
			return null;
		}
		
	}
}


//接口中的内部抽象类
interface IChan {
	void send();
	abstract class AbstractMsg {
		public static void main(String[] args) {
			IChan ich = new ChanImpl();
			ich.send();
		}
		public abstract String getContent();
	}
}


class ChanImpl implements IChan {

	@Override
	public void send() {
		AbstractMsg msgImpl = new MsgImpl();
		System.out.println(msgImpl.getContent());
	}
	
	class MsgImpl extends AbstractMsg {

		@Override
		public String getContent() {
			return "继承内部抽象类";
		}
		
	}
}




//接口中的普通内部类和静态方法
interface Inter {
	void send();
	class InterImpl implements Inter {
		public static void main(String[] args) {
			Inter inter = Inter.getInstance();
			inter.send();
		}
		public void send() {
			System.out.println("接口中的普通内部类");
		}
	}
	
	public static Inter getInstance() {
		return new InterImpl();
	}
}


//抽象类中普通类
abstract class AbstractOuter {
	abstract void send();
	private  class InnerClass extends AbstractOuter {
		@Override
		void send() {
			
		}
		
	}	
}


