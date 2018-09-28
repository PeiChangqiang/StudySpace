package com.pcq.classobject;

/**
 * 该例子说明，一旦某个类的Class对象被类加载器加载进内存，该Class对象就被用来创建这个类的所有对象。
 * 也就是说，JVM使用类加载器来创建字节码的Class对象，使用Class对象来创建这个类的所有对象。
 * 类加载器首先检查这个类有没有被加载，若没有则根据类名寻找.class文件，加载时会进行一些验证确保没有不良java代码。
 */
public class SweetShop {

    public static void main(String[] args) {
        System.out.println("inside main");
        new Candy();
        System.out.println("after creating candy");
        try {
            Class.forName("com.pcq.classobject.Gum");
        } catch (ClassNotFoundException e) {
            System.out.println("couldn't find Gum");
        }
        System.out.println("after Class.forName(\"gum\")");
        new Cookie();
        System.out.println("after creating cookie");

    }
}

class Candy {
    static {
        System.out.println("loading candy");
    }
}

class Gum {
    static {
        System.out.println("loading gum");
    }
}

class Cookie {
    static {
        System.out.println("loading cookie");
    }
}