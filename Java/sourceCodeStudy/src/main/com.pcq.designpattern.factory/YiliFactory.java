package main.com.pcq.designpattern.factory;

public class YiliFactory implements Factory{
    @Override
    public Milk getMilk() {
        return new Yili();
    }
}
