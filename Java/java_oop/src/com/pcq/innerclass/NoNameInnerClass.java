package com.pcq.innerclass;

public class NoNameInnerClass {

public static void main(String[] args) {
	
}
}


//匿名内部类
interface NoName {
	public static void main(String[] args) {
		NoName nn = new NoName(){
			public void print(String msg) {
				System.out.println(msg);
			}
		};
		nn.print("匿名内部类");
	}
	void print(String msg);
}



interface OutCla {
	void print(String msg);
	public static void main(String[] args) {
		OutCla oc = OutCla.getInstance();
		oc.print("静态方法中返回匿名内部类");
		OutCla oc2 = new OutCla() {
			public void print(String msg) {
				//会产生OutCla$2.class文件
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