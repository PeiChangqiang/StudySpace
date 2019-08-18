package main.com.pcq.designpattern.factory.abstr;

import main.com.pcq.designpattern.factory.Milk;

/**
 * 抽象工厂是用户的主入口
 * spring用的最多的一个设计模式
 * 处理用户和产品之间的沟通桥梁
 *优点：
 * 1.公共的逻辑可以统一处理，方便
 * 2.易于扩展
 */
public abstract class AbstractFactory {
    /**
     * 获得蒙牛牛奶
     * @return
     */
    public abstract Milk getMengniu();

    /**
     * 获得伊利牛奶
     * @return
     */
    public abstract Milk getYili();

    /**
     * 获得特仑苏
     * @return
     */
    public abstract  Milk getTelunsu();

    /**
     * 获得三鹿毒奶粉
     * @return
     */
    public abstract  Milk getSanlu();

}
