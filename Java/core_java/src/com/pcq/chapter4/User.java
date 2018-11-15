package com.pcq.chapter4;

public class User {
    private static int nextId = 0;
    private int id;
    private String userName;

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public int getId() {
        return id;
    }

    public void setId() {
        this.id = nextId++;
    }
}
