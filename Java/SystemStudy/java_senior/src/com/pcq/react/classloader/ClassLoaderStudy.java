package com.pcq.react.classloader;

import java.io.BufferedWriter;

public class ClassLoaderStudy {


    public static void main(String[] args) {
        ClassLoader cl = ClassLoader.class.getClassLoader();
        ClassLoader c2 = ClassLoaderStudy.class.getClassLoader();
        System.out.println(cl);
        System.out.println(c2);
        System.out.println(c2.getParent());
    }
}

/**
 * �Զ����������
 */
class myClassLoader extends ClassLoader {

}
