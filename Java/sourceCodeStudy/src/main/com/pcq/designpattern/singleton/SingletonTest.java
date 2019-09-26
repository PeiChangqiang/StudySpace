package main.com.pcq.designpattern.singleton;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class SingletonTest {

    public static void main(String[] args) {
        int count = 100;
        for(int i = 0; i < count; i++) {
            Hungry.getInstance();
        }
//        CountDownLatch countDownLatch = new CountDownLatch(count);
//        final Set<Hungry> set = Collections.synchronizedSet(new HashSet<Hungry>());
//        for (int i = 0; i < count; i++) {
//            new Thread() {
//                @Override
//                public void run() {
//                    set.add(Hungry.getInstance());
//                }
//            }.start();
//            countDownLatch.countDown();
//        }
//
//
//
//        try {
//            countDownLatch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }
}
