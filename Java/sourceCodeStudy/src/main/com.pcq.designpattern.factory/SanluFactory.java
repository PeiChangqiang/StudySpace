package main.com.pcq.designpattern.factory;

public class SanluFactory implements Factory {
    @Override
    public Milk getMilk() {
        return new Sanlu();
    }
}
