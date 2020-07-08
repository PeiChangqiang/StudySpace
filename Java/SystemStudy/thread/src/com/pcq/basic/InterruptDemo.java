package com.pcq.basic;

import java.util.concurrent.TimeUnit;

public class InterruptDemo {
    static int i = 1;
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(
                ()->{
                    while(!Thread.currentThread().isInterrupted()) {
                        i++;
                    }
                    System.out.println(i);
                }, "interruptdemo"
        );
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
    }
}
