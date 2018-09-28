/*

package com.pcq.dynamicproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

*/
/**
 * CGLIB代理类
 *//*


public class CglibProxy implements org.springframework.cglib.proxy.MethodInterceptor {


    */
/**
     * 生成代理对象
     * @param c 被代理的类
     * @return
     *//*

    public Object getProxy(Class c) {
        //增强类对象
        org.springframework.cglib.proxy.Enhancer enhancer = new Enhancer();
        //设置增强类型
        enhancer.setSuperclass(c);
        //代理逻辑对象设置为当前对象,该对象的类必须实现了MethodInterceptor的intercept方法
        enhancer.setCallback(this);
        //生成和返回代理对象
        return enhancer.create();
    }

    */
/**
     *
     * @param o 代理对象
     * @param method 方法
     * @param objects 方法参数
     * @param methodProxy 方法代理
     * @return 代理的逻辑返回
     * @throws Throwable
     *//*

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.err.println("调用代理类方法前执行逻辑...");
        Object result = methodProxy.invokeSuper(o, objects);
        System.err.println("调用后...");
        return result;
    }
}

*/
