package com.pcq.lambda;
import java.util.function.*;
import com.pcq.array.ArrayUtil;

public class LambdaPractice {
	public static void main(String[] args) {
		IFun f = (food) -> {
			System.out.println("eat " + food);
		};
		f.eat("apple");
		
		//类静态方法引用
		IFun2 f2 = ArrayUtil :: getSum;
		int[] arr = ArrayUtil.getArray(5);
		ArrayUtil.printArray(arr);
		int sum = f2.sum(arr);
		System.out.println(sum);
		
		//对象普通方法引用
		MyUtil mu = new MyUtil();
		MyUtil.IFun3 f3 = mu :: mutilVal;
		System.out.println(f3.mutil(2, 3));
		
		//特定类普通方法应用
		MyUtil.IFun4 fx = String :: toLowerCase;
		System.out.println(fx.lower("dfsEDFSD"));
		
		
		//构造方法引用
		MyUtil.IFun5 f5 = MyUtil :: new;
		f5.getUtil();
		
	}
}


@FunctionalInterface
interface IFun {
	void eat(String food);
}

@FunctionalInterface
interface IFun2 {
	int sum(int[] arr);
}

class MyUtil {
	public MyUtil() {
		System.out.println("MyUtil的构造方法");
	}
	public int mutilVal(int x, int y) {
		return x * y;
	}
	
	interface IFun3 {
		int mutil(int x, int y);
	}
	
	interface IFun4 {
		String lower(String str);
	}
	
	interface IFun5 {
		MyUtil getUtil();
	}
}



//内建函数式接口
class TestInerInterface {
	public static void main(String[] args) {
		Function<String,Boolean>  fun = "XX****ZZ" :: startsWith;
		boolean flag = fun.apply("xx");
		System.out.println(flag);
		
		Consumer<String> con = System.out :: println;
		con.accept("Hello World");
		
		Supplier<String> s = "DSFSDF" :: toLowerCase;
		System.out.println(s.get());
	}
}