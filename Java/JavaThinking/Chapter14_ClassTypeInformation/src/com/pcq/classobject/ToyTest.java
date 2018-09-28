package com.pcq.classobject;

/**
 * 该例说明拿到一个类的类对象，就可以获得该类的全部信息，包括它的父类，它的接口等等。
 * 并且能够通过这个类对象的newInstance方法获得该类的实例对象，但该方法返回的引用并不是确定的类型引用，而是一个Object，但是
 * 指向的却是一个具体类型的对象
 */
public class ToyTest {
    static void printInfo(Class c) {
        System.out.println("Class Name : " + c.getName() + ",is interface?[" + c.isInterface() + "]");
        System.out.println("Simple Name : " + c.getSimpleName());
        System.out.println("Canonical Name : " + c.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("com.pcq.classobject.FancyToy");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        printInfo(c);
        System.out.println("----------------------------------------------------------------");
        for(Class face : c.getInterfaces()) {
            printInfo(face);
            System.out.println("----------------------------------------------------------------");
        }
        Class father = c.getSuperclass();
        try {
            Object obj = father.newInstance();
            printInfo(obj.getClass());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}


interface HasBatteries {}
interface Waterproof {}
interface Shoots {}
interface Fly {}
class Toy {
    Toy() {}
    Toy(int i) {}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots, Fly {
    FancyToy() {
        super(1);
    }
}
