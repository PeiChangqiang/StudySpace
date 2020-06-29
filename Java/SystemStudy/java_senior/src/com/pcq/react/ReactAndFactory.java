package com.pcq.react;

import java.lang.reflect.InvocationTargetException;

/**
 * 反射和工厂设计模式
 * 工厂设计模式应不限于具体的类，甚至于具体的接口类型。
 * 前者需要反射，后者需要泛型配合
 */
public class ReactAndFactory {
    public static void main(String[] args) {
        IMessageService msgService = Factory.getInstance("com.pcq.react.NetMessage", IMessageService.class);
        msgService.send("net message");
        ILifeService lifeService = Factory.getInstance("com.pcq.react.HomeService", ILifeService.class);
        lifeService.apply("home live");
    }
}

class Factory {
    private  Factory() {}

    /**
     *
     * @param className 实例化对象的类路径
     * @param clazz 实例化对象的接口类型
     * @param <T>
     * @return
     */
    public static <T> T getInstance(String className, Class<T> clazz) {
        T instance = null;
        try {
            instance = (T)Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }
}

/**
 * 消息服务接口
 */
interface IMessageService {
    void send(String msg);
}

/**
 * 生活服务接口
 */
interface ILifeService {
    void apply(String service);
}

class NetMessage implements  IMessageService {

    @Override
    public void send(String msg) {
        System.out.println("send：" + msg);
    }
}

class HomeService implements ILifeService {

    @Override
    public void apply(String service) {
        System.out.println("support：" + service);
    }
}