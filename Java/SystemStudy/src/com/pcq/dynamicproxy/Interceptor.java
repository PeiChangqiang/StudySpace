package com.pcq.dynamicproxy;

import java.lang.reflect.Method;

/**
 * 拦截器接口
 * 如果before返回true则执行被代理对象的方法。false则执行around方法。最后执行after方法
 */
public interface Interceptor {
    boolean before(Object proxy, Object target, Method method, Object[] args);
    void around(Object proxy, Object target, Method method, Object[] args);
    void after(Object proxy, Object target, Method method, Object[] args);
}
