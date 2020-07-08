package com.pcq.react.proxypattern;

import com.pcq.inter.IChannalService;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler, IChannalService {
    private Object target;

    public Object bind(Object target) {
        this.target = target;
        //ͨ���ڶ��������ɼ����ٷ�ʵ�ֵĴ����ǻ��ڽӿ���ʵ�ֵ�
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj = null;
        if(this.isConnect()) {
          obj = method.invoke(target, args);
          this.close();
        }
        return obj;
    }

    @Override
    public boolean isConnect() {
        System.out.println("build connect.......");
        return true;
    }

    @Override
    public void close() {
        System.out.println("close connect........");
    }
}
