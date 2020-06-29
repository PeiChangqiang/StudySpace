package com.pcq.react;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReactClassInfo extends BaseAbsClass implements IChannalService,IMsgService {

    public ReactClassInfo(String s, int i) {

    }
    public  ReactClassInfo() {}
    private ReactClassInfo(String s) {

    }
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = ReactClassInfo.class;
        Field[] fields = clazz.getFields();
        for(Field field : fields) {
            System.out.println(field.getName());
        }
//        String packageName = clazz.getPackage().getName();
//        System.out.println(packageName);
//        Class<?> cls = clazz.getSuperclass();
//        System.out.println(cls.getName());
//        Class<?>[] clss = clazz.getInterfaces();
//        for(Class<?> temp : clss) {
//            System.out.println(temp.getName());
//        }
//        Constructor<?>[] constructors = clazz.getConstructors();
//        for(Constructor<?> cons : constructors) {
//            System.out.println(cons);
//        }
//        Constructor con = clazz.getDeclaredConstructor(String.class);
//        System.out.println(con);
//        Object obj = con.newInstance("abc");
//        System.out.println(obj.toString());
        Method[] methods = clazz.getMethods();
        for(Method m : methods) {//遍历循环类的方法对象
            System.out.print(Modifier.toString(m.getModifiers()) + " ");
            System.out.print(m.getReturnType() + " ");
            System.out.print(m.getName());
            System.out.print("(");
            Class<?>[] params = m.getParameterTypes();
            for(int i = 0; i < params.length; i++) {
                System.out.print(params[i].getName() + " " + "arg-" + i);
                if(i < params.length - 1) {
                    System.out.print(",");
                }
            }
            System.out.print(")");
            Class<?>[] exceptions = m.getExceptionTypes();
            if(exceptions.length > 0) {
                System.out.print(" throws ");
            }
            for(int j = 0; j < exceptions.length; j++) {
                System.out.print( exceptions[j].getName());
                if(j < exceptions.length - 1) {
                    System.out.print(",");
                }

            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "this is a test about react and Class operation";
    }

    @Override
    public boolean isConnect() {
        return false;
    }

    @Override
    public void send() {
        if(isConnect()) {
            System.out.println("send message....");
        }
    }
}
