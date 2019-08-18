package main.com.pcq.designpattern.factory;

/**
 * 工厂模型
 */
public interface Factory {
    /**
     * 用来生产牛奶
     * @return
     */
    Milk getMilk();
}
