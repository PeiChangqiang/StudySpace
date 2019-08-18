package main.com.pcq.designpattern.factory;

public class MilkFactory {


    public Milk getMilk(String name) {
        if("特仑苏".equals(name)) {//这种写死的代码其实是很lowbe的
            return new Telunsu();
        }
        return null;
    }
}
