package com.pcq.observer;

public class Main {
    public static void main(String[] args) {
        ProductList productList = ProductList.getInstance();
        productList.addObserver(new TaoBaoObserver());
        productList.addObserver(new JingdongObserver());
        productList.addProduct("蜂蜜");
        System.out.println("------------------------------------------------------");

        WheatherPredict wheatherPredict = WheatherPredict.getInstance();
        wheatherPredict.addObserver(new WheatherNotity());
        wheatherPredict.wheatherChange("39","20");
    }
}
