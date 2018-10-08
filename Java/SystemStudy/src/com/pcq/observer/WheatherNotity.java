package com.pcq.observer;

import java.util.Observable;
import java.util.Observer;

public class WheatherNotity implements Observer {
    @Override
    public void update(Observable o, Object arg) {

        String[] args = (String[])arg;
        System.out.println("同步更新温度和湿度情况：" + args[0] + "," + args[1]);
    }
}
