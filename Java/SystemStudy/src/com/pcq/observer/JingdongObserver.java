package com.pcq.observer;

import java.util.Observable;
import java.util.Observer;

public class JingdongObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        String newObject = arg.toString();
        System.out.println("京东同步新产品:" + newObject);
    }
}
