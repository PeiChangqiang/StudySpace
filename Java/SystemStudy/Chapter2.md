# Chapter2

### 二、观察者模式

定义了一对多的关系，当被观察者发生变化时，通知所有的观察者，并让他们根据最新情况更新自己。

这里使用java.util包下的类实现观察者模式

* 被观察者

  1.被观察者继承Observable。

  2.被观察者维护自身被观察的状态。

  3.被观察者维护添加或者删除观察者。

  4.被观察者维护的状态发生变化时，通知观察者，使他们更新。

* 观察者

  1.观察者实现Observer，并且实现update方法。其中Observable是被观察者。arg是被观察者维护的状态。



* 关键代码

~~~java
/**
*被观察者
*/
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
        this.notifyObservers(new String[]{temperature, humidity});//通知观察者，该方法将会调用观察者的update方法。
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


/**
*观察者
*/
public class WheatherNotity implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        String[] args = (String[])arg;
        System.out.println("同步更新温度和湿度情况：" + args[0] + "," + args[1]);
    }
}

//测试方法
 public static void main(String[] args) {
        WheatherPredict wheatherPredict = WheatherPredict.getInstance();
        wheatherPredict.addObserver(new WheatherNotity());
        wheatherPredict.wheatherChange("39","20");//调用观察的update方法。
    }
~~~

