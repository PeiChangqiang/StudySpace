package com.pcq.innerclass;

public class InnerClassPractice {

	public static void main(String[] args) {
		IMsgWrap.send(new MsgImpl(), new ChannelImp());
	}

}


//�ӿ��ж��徲̬�ӿ�
interface IMsgWrap {
	static interface IMsg {
		String getContent();
	}
	
	static interface IChannel {
		boolean isConnect();
	}
	
	static void send(IMsg msg, IChannel channel) {
		if(channel.isConnect()) {
			System.out.println("������Ϣ:" + msg.getContent());
		} else {
			System.out.println("��Ϣͨ���޽������޷�������Ϣ������");
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
		return "��Ҫ�ش𣬲�Ҫ�ش𡣡���";
	}
}

//�����ж����ڲ���
class OuterClass {
	private String msg = "����һ���ⲿ�����";
	public void methodClass(String s) {
		class InnerClass {
			public void print() {
				System.out.println(OuterClass.this.msg + "," + s);
			}
		}
		new InnerClass().print();
	}
	public static void main(String[] args) {
		new OuterClass().methodClass("���Ƿ����ľֲ�����");
	}
}