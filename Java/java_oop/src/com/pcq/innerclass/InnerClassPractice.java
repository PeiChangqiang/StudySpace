package com.pcq.innerclass;

public class InnerClassPractice {

	public static void main(String[] args) {
		IMsgWrap.send(new MsgImpl(), new ChannelImp());
	}

}


//接口中定义静态接口
interface IMsgWrap {
	static interface IMsg {
		String getContent();
	}
	
	static interface IChannel {
		boolean isConnect();
	}
	
	static void send(IMsg msg, IChannel channel) {
		if(channel.isConnect()) {
			System.out.println("发送消息:" + msg.getContent());
		} else {
			System.out.println("消息通道无建立，无法发送消息。。。");
		}
	}
}

class ChannelImp implements IMsgWrap.IChannel {

	@Override
	public boolean isConnect() {
		return true;
	}
	
}


class MsgImpl implements IMsgWrap.IMsg {

	@Override
	public String getContent() {
		return "不要回答，不要回答。。。";
	}
}

//方法中定义内部类
class OuterClass {
	private String msg = "这是一个外部类参数";
	public void methodClass(String s) {
		class InnerClass {
			public void print() {
				System.out.println(OuterClass.this.msg + "," + s);
			}
		}
		new InnerClass().print();
	}
	public static void main(String[] args) {
		new OuterClass().methodClass("这是方法的局部变量");
	}
}