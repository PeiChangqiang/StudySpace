package com.pcq.react;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
       // Unsafe unsafe = Unsafe.getUnsafe();
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);//½â³ý·â×°
        Unsafe u = (Unsafe) field.get(null);
        System.out.println(field.getType());
        Singleton singleton = (Singleton)u.allocateInstance(Singleton.class);
        System.out.println(singleton);
    }
}



