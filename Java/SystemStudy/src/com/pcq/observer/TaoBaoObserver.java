package com.pcq.observer;

import java.util.Observable;
import java.util.Observer;

public class TaoBaoObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        String product = arg.toString();
        System.out.println("淘宝同步更新新产品：" + product);
    }
}
