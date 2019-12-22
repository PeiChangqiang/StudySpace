package com.pcq.innerclass;

public class NoNameInnerClass {

public static void main(String[] args) {
	
}
}


//�����ڲ���
interface NoName {
	public static void main(String[] args) {
		NoName nn = new NoName(){
			public void print(String msg) {
				System.out.println(msg);
			}
		};
		nn.print("�����ڲ���");
	}
	void print(String msg);
}



interface OutCla {
	void print(String msg);
	public static void main(String[] args) {
		OutCla oc = OutCla.getInstance();
		oc.print("��̬�����з��������ڲ���");
		OutCla oc2 = new OutCla() {
			public void print(String msg) {
				//�����OutCla$2.class�ļ�
			}
		};
	}
	static OutCla getInstance() {
		return new OutCla() {
			public void print(String msg) {
				System.out.println(msg);
			}
		};
	}
}