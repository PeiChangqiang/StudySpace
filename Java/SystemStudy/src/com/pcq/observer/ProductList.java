package com.pcq.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ProductList extends Observable{
    private List<String> productList = null;
    private static ProductList instance;
    private ProductList(){}//构造方法私有化

    /**
     * 产品列表唯一实例。
     * @return
     */
    public static ProductList getInstance() {
        if(instance == null) {
            instance = new ProductList();
            instance.productList = new ArrayList<String>();
        }
        return  instance;
    }

    /**
     * 增加观察者
     * @param observer
     */
    public void addProductListObserver(Observer observer) {
        this.addObserver(observer);
    }

    public void addProduct(String product) {
        productList.add(product);
        System.out.println("产品列表增加了新产品:" + product);
        this.setChanged();
        this.notifyObservers(product);
    }
}
