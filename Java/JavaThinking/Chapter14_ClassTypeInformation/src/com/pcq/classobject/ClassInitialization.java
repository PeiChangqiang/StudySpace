package com.pcq.classobject;

import java.util.Random;

/**
 * 该例子说明，通过类字面量常量获得类类型对象的引用并不会初始化该Class对象，但是Class.forName会。
 * 对于static final修饰的编译期常量，读取时也并不需要初始化该Class对象。
 * 但是，static final修饰的常量未必一定是编译期常量，例如Initable.num2，它不是一个编译期常量，因此对它的访问强制进行了Initable的初始化
 */
public class ClassInitialization {
    public static final Random rand = new Random(47);

    public static void main(String[] args) throws ClassNotFoundException {
        Class c = Initable.class;//并不打印"Initializing initable..."语句
        System.out.println(Initable.num1);//也不会打印static中的语句，说明并未初始化Class对象，它是编译期常量
        System.out.println(Initable.num2);//Initable的Class对象被初始化了，因为它不是编译期常量
        System.out.println(Initable2.num1);
        Class.forName("com.pcq.classobject.Initable3");
        System.out.println(Initable3.num1);
    }
}

class Initable {
    static final int num1 = 47;
    static final int num2 = ClassInitialization.rand.nextInt(1000);
    static {
        System.out.println("Initializing initable...");
    }
}
class Initable2 {
    static int num1 = 47;
    static {
        System.out.println("Initializing initable2...");
    }
}
class Initable3 {
    static  int num1 = 77;
    static {
        System.out.println("Initializing initable3...");
    }
}
