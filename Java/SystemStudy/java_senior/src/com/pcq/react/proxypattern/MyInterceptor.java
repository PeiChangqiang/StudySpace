package com.pcq.react.proxypattern;

import com.pcq.inter.IMsgService;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyInterceptor implements MethodInterceptor {
    public static void main(String[] args) {
        MsgHandler mh = new MsgHandler();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(mh.getClass());//ºŸ∂®∏∏¿‡
        enhancer.setCallback(new MyInterceptor(mh));
        MsgHandler imsg = (MsgHandler)enhancer.create();
        imsg.send();
    }
    private Object target;
    public MyInterceptor(Object target) {
        this.target = target;
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object obj = null;
        if(isConnect()) {
            obj = method.invoke(target, objects);
            close();
        }
        return obj;
    }


    public boolean isConnect() {
        System.out.println("build connect.......");
        return true;
    }


    public void close() {
        System.out.println("close connect........");
    }
}
