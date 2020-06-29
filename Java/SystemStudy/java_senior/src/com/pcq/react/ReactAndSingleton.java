package com.pcq.react;
/**
 * 反射与单例模式（懒汉式）
 */
public class ReactAndSingleton {
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++) {
            new Thread(
                    ()->{
                        Singleton.getInstance();
                    }
            ).start();
        }
    }
}

/**
 * 标准的多线程下饿汉式单例模式
 */
class Singleton {
    private static volatile Singleton instance = null;//与主内存中保持一致
    private  Singleton() {
        System.out.println(Thread.currentThread().getName() + ": exe getInstance");
    }
    public static Singleton getInstance() {
        if(instance == null) {
            synchronized (Singleton.class) {
                if(instance == null) {//同步逻辑中需要再次判断
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
