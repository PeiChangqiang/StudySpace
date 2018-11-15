package com.pcq.chapter4;

public class Main {

    public static void main(String[] args) {
        User user1 = new User();
        user1.setId();
        User user2 = new User();
        user2.setId();
        System.out.println(user1.getId());
        System.out.println(user2.getId());
    }
}
