package com.pcq.basic;



import java.util.concurrent.*;

public class CallableDemo implements Callable<String> {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        CallableDemo cd = new CallableDemo();
        Future<String> future = es.submit(cd);
        String str = future.get();//×èÈû
        System.out.println(str);
        es.shutdown();
    }
    @Override
    public String call() throws Exception {
        return "xxxx";
    }
}
