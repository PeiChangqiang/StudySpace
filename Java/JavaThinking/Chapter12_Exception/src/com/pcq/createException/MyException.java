package com.pcq.createException;

public class MyException extends Exception{

    public static void f() throws ExceptionWithMsg{
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