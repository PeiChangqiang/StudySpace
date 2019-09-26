package main.com.pcq.designpattern.singleton;

/**
 * 饿汉式单例模式，加载类的时候就加载类实例
 */
public class Hungry {
    private Hungry() {}
    //这里的final控制引用的地址不可变，也就是说一直只引用最初new出来的对象
    private static final Hungry hungry = new Hungry();
    public static Hungry getInstance() {
        System.out.println(System.currentTimeMillis() + ":" + hungry );
        return  hungry;
    }
}
