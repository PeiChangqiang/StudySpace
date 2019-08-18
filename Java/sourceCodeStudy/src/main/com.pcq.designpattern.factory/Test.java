package main.com.pcq.designpattern.factory;

import main.com.pcq.designpattern.factory.abstr.AbstractFactory;
import main.com.pcq.designpattern.factory.abstr.MilkFactory;

public class Test {
    public static void main(String[] args) {
        //System.out.println(new Telunsu().getName());
//        MilkFactory factory = new MilkFactory();
//        Milk milk = factory.getMilk("特仑苏");
//        System.out.println(milk.getName());

        AbstractFactory factory = new MilkFactory();
        System.out.println(factory.getMengniu().getName());
        System.out.println(factory.getSanlu().getName());
    }
}
