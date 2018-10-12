package com.pcq.main;

public class Deliver {
    public static void main(String[] args) {
        int a = 20;
        Deliver deliver = new Deliver();
        deliver.add(a);
        System.out.println(a);
        Data d = new Data();
        deliver.addData(d);
        System.out.println(d.a);
    }

    public void add(int a) {
        a++;
        System.out.println(a);
    }

    public void addData(Data a) {
        a.a++;
        System.out.println(a.a);
    }
}


class Data {
    int a = 10;
}
