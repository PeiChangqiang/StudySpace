package com.pcq.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 1.代理是控制第三方对真实对象（被代理的对象）的直接访问。
 * 2.代理有两个步骤：
 *  1）建立代理对象和真实对象的关系
 *  2）实现代理对象的代理逻辑。即如何去代理
 * 3.java中常用的代理技术：
 *  JDK、CGLIB、Javassist、ASM
 */

//该类是JDK代理类，必须实现InvocationHandler
public class JdkProxy implements InvocationHandler{

    private Object target = null;//存放被代理的对象

    /**
     * 建立关系，并且返回代理对象
     * @param target 被代理的对象
     * @return 代理对象
     */
    public Object getTarget(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    /**
     * 实现代理对象的代理逻辑
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理逻辑方法。。。");
        System.out.println("访问真实对象前做的一些准备逻辑工作。。。");
        Object obj = method.invoke(target, args);
        System.out.println("调用代理对象后做的一些善后逻辑工作。。。");
        return obj;
    }

}
