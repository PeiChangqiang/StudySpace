package com.pcq.builder;

public class TicketHelper {
    public void buildAdult(String info) {
        System.out.println("构建成人票...");
    }

    public void buildChildForSeat(String info) {
        System.out.println("构建有座儿童票...");
    }

    public void buildChildNoSeat(String info) {
        System.out.println("构建无座儿童票...");
    }

    public void buildElder(String info) {
        System.out.println("构建老年人票...");
    }

    public void buildSoldier(String info) {
        System.out.println("构建军人票...");
    }
}
