package com.pcq.dynamicproxy;

public class MakeDinnerImpl implements MakeDinner {
    @Override
    public void makeDinner() {
        System.out.println("I am making delicious dinner!");
    }

    @Override
    public void makeSoup(String type) {
        System.out.println("I am making delicious soup!" + type);
    }
}
