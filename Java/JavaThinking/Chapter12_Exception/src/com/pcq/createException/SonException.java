package com.pcq.createException;

public class SonException extends MyException {

    private String str;
    public SonException(String msg) {
        this.str = msg;
    }

    public static void main(String[] args) {
        new SonException().f();
    }
    public SonException() {
    }

    public static void f() {
    }
    public void f(String str) {
        str.charAt(0);
        str.charAt(0);
        str.charAt(0);
        str.charAt(0);
        str.charAt(0);
        str.charAt(0);
        str.charAt(0);
    }
}
