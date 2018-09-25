package com.pcq.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射来调用方法
 */
public class ReflectMethod {
    private String name;

    public ReflectMethod(String name) {
        this.name = name;
    }

    public void sayHello(String name) {
        System.out.println("Hello!" + name);
    }

    public static ReflectMethod getInstance(String name) {
        ReflectMethod object = null;
        try {
            object = (ReflectMethod)Class.forName("com.pcq.reflect.ReflectMethod").getConstructor(String.class).newInstance(name);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }
    //这里可以发现只要是反射，主要是使用类，获得类的信息（包括类的属性，类的方法，类的构造函数等信息）。通过类的信息来获得方法，调用方法。这时候方法变成了一个类的对象属性。
    public static void main(String[] args) {
        ReflectMethod object = getInstance("pcq");
        try {
            Method method = ReflectMethod.class.getMethod("sayHello", String.class);
            method.invoke(object,"qcp");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
