package com.pcq.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 父类中的静态list只会加载一次。而每次实例化子类就会调用父类的构造函数，并将当前的子类对象add进静态list中。
 */
public class TestStatic {
    public static void main(String[] args) {
        List<Father> list = Arrays.asList(new son1(), new son2(), new son3());
        System.out.println(Father.list);
    }
}

class Father {
    static List<Father> list = new ArrayList<Father>();
    Father() {
        list.add(this);
    }
    public String toString() {
        return getClass().getSimpleName();
    }
}

class son1 extends Father {}
class son2 extends Father {}
class son3 extends Father {}
