package com.pcq.chapter5;

public class CommTest {
    public static void main(String[] args) {
        /*Object object;
        Student stu1 = new Student();
        Student stu2 = new Student();
        System.out.println(stu1.equals(stu2));

        Student stu3 = new Student();
        stu3.setId("00122s");
        System.out.println(stu3.hashCode());*/

        String a = new String("abc");
        String b = new String("abc");
        StringBuilder sb = new StringBuilder(a);
        System.out.println(a.getBytes());
        System.out.println(a.hashCode() == b.hashCode());
        System.out.println(sb.hashCode());
        System.out.println(a.hashCode());

    }
}
