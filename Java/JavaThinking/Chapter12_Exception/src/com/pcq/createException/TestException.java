package com.pcq.createException;

public class TestException {

    public void f() throws MyException {
        System.out.println("抛出异常开始....");
            throw new MyException();
    }


    public static void main(String[] args){

        try {
            new TestException().f();
        } catch (MyException e) {
            e.printStackTrace();
        } finally {
            System.out.println("捕获异常结束..");
        }
    }
}
