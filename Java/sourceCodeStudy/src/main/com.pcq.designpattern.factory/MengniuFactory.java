package main.com.pcq.designpattern.factory;

public class MengniuFactory implements Factory {
    @Override
    public Milk getMilk() {
        return new MengNiu();
    }
}
