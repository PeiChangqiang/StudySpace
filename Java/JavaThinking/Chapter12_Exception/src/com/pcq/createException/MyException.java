package com.pcq.createException;

public class MyException extends Exception{

    private static String str = "呵呵哒";
    public static void f() throws ExceptionWithMsg{
        str.charAt(0);
        str.charAt(1);
        str.charAt(0);
        str.charAt(0);
        str.charAt(0);
        throw new ExceptionWithMsg("异常了，快捕获一下吧！");

    }
    public static void main(String[] args) {
        try {
            f();
        } catch(ExceptionWithMsg e) {
            e.printStackTrace();
        }
    }
}


class ExceptionWithMsg extends Exception {
    public ExceptionWithMsg(String message) {
        super(message);

    }
}