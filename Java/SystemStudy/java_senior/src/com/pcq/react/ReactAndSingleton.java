package com.pcq.react;
/**
 * �����뵥��ģʽ������ʽ��
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
 * ��׼�Ķ��߳��¶���ʽ����ģʽ
 */
class Singleton {
    private static volatile Singleton instance = null;//�����ڴ��б���һ��
    private  Singleton() {
        System.out.println(Thread.currentThread().getName() + ": exe getInstance");
    }
    public static Singleton getInstance() {
        if(instance == null) {
            synchronized (Singleton.class) {
                if(instance == null) {//ͬ���߼�����Ҫ�ٴ��ж�
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
