package com.pcq.observer;

import java.util.Observable;
import java.util.Observer;

public class WheatherPredict extends Observable {
    private String temperature;
    private String humidity;
    private static WheatherPredict wheatherPredict = null;
    private WheatherPredict() {}

    /**
     * 单例模式获得该实例
     * @return
     */
    public static WheatherPredict getInstance() {
        if(wheatherPredict == null) {
            wheatherPredict = new WheatherPredict();
        }
        return wheatherPredict;
    }

    /**
     * 添加观察者
     * @param observer
     */
    public void addObservers(Observer observer) {
        this.addObserver(observer);
    }
    /**
     * 温度变化通知观察者
     * @param temperature
     * @param humidity
     */
    public void wheatherChange(String temperature, String humidity) {
        setHumidity(humidity);
        setTemperature(temperature);
        System.out.println("当前的温度是：" + temperature + ",当前的湿度是：" + humidity);
        this.setChanged();//触发通知事件的标志位
        this.notifyObservers(new String[]{temperature, humidity});//通知观察者
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }
}
