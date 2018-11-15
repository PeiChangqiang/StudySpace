package com.pcq.chapter5;

import java.util.Objects;

public class Student {

    private String userName;
    private String id;
    private String password;

    public boolean equals(Object object) {
        if(null == object) return false;
        if(this == object) return true;
        if(this.getClass() != object.getClass()) return false;
        Student stu = (Student) object;
        return Objects.equals(userName,stu.userName) && Objects.equals(password, stu.password);
    }

    public int hashCode() {
        int hash = 0;
        for(int i = 0; i < id.length(); i ++) {
            hash = 20 * hash + id.charAt(i);
        }
        return hash;
    }

    public void setId(String id) {
        this.id = id;
    }
}
