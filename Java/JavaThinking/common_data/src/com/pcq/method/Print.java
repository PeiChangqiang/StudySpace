package com.pcq.method;

/**
 * 封装打印的方法
 */
public class Print {
    /**
     * 打印一个空白行，相当于回车
     */
    public static void print() {
        System.out.println();
    }

    /**
     * 打印分割线
     */
    public static void printLine() {
        System.out.println("-----------------------------------------------------------------");
    }

    /**
     * 打印对象，对于基本数据类型和它的包装类，打印的是值。对象打印的是toString()方法里的内容
     * @param obj
     */
    public static void print(Object obj) {
        System.out.println(obj);
    }
}
