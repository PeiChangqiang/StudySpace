package com.pcq.dynamicproxy;

import java.lang.reflect.Method;

public class Interceptor2 implements Interceptor {
    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("拦截器2方法反射前执行");
        return true;
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {

    }

    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("拦截器2方法反射后执行。。。");
    }
}
