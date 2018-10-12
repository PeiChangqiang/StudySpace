package com.pcq.main;

public class Main {

    int i;
    Main main;

    //方法名和参数列表(方法签名)唯一标识出一个方法。返回值不能判断两个方法是否一样。因为假设两个方法返回值不同，方法名和参数列表相同，当你调用的时候，编译器并不能判断到底调用哪个。编译器并不会根据
    //等号左边的接收类型来判断具体调用哪个，因为即使有返回值的方法，调用时也不是必须用一个接收类型去接收。
    public void testLocal() {
        System.out.println(i);
        System.out.println(main);
    }
    public static void mainTest() {
        int i = 0;//方法中的局部变量如果没有初始化值，那么使用时编译器会报错
        System.out.println(i);
        new Main().testLocal();
    }

    public static void main(String[] args) {
        mainTest();
    }

}
