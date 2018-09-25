package com.pcq.reflect;

import java.lang.reflect.InvocationTargetException;

import static java.lang.Class.forName;

/**
 * 通过反射生成对象
 * 1.构造函数无参数创建对象
 */
public class ObjectImpl {
    public void sayHello(String name) {
        System.out.println("hello!" + name);
    }


    public static Object getInstance() {
        ObjectImpl objectImpl = null;
        try {
            objectImpl = (ObjectImpl) forName("com.pcq.reflect.ObjectImpl").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return objectImpl;
    }
    public static void main(String[] args) {
        ObjectImpl object = (ObjectImpl) getInstance();
        System.out.println(object.getClass());
        ObjectImpl2 object2 = ObjectImpl2.getInstance();
        System.out.println(object2.getClass());
    }
}

/**
 * 2.通过反射生成构造函数有参数的对象
 */
class  ObjectImpl2 {
    private String name;
    public ObjectImpl2(String name) {
        this.name = name;
    }
    public static ObjectImpl2 getInstance() {
        ObjectImpl2  object = null;
        try {
            object = (ObjectImpl2) Class.forName("com.pcq.reflect.ObjectImpl2").getConstructor(String.class).newInstance("张三");//相当于 new ObjectImpl2("张三");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return object;
    }
}
