package com.pcq.innerclass;

public class InnerClassDemo {
	public static void main(String[] args) {
		Outer out = new Outer();
		out.funInner();
		
		/**
		 * ����ʱ�������ڲ����class�ļ���Outer$Inner.class
		 * ʵ�����ڲ����ȫ�ƾ���Outer.Inner
		 * �����ⲿ����ڲ������Կ��Ի���ֱ�ӷ��ʣ����ʵ�����ڲ���֮ǰ��Ҫ��ʵ�����ⲿ�ࡣ
		 * ����ڲ���ֻ�����ⲿ��ʹ�ã������ʹ��private����
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
		private String privateStr = "�ڲ���˽������";
		void print() {
			System.out.println(Outer.this.msg);
		}
	}
}



//�ӿ��е��ڲ��ӿ�
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


//�ӿ��е��ڲ�������
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
			return "�̳��ڲ�������";
		}
		
	}
}




//�ӿ��е���ͨ�ڲ���;�̬����
interface Inter {
	void send();
	class InterImpl implements Inter {
		public static void main(String[] args) {
			Inter inter = Inter.getInstance();
			inter.send();
		}
		public void send() {
			System.out.println("�ӿ��е���ͨ�ڲ���");
		}
	}
	
	public static Inter getInstance() {
		return new InterImpl();
	}
}


//����������ͨ��
abstract class AbstractOuter {
	abstract void send();
	private  class InnerClass extends AbstractOuter {
		@Override
		void send() {
			
		}
		
	}	
}


