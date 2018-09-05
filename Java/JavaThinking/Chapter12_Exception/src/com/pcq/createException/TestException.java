package com.pcq.createException;

public class TestException {

    /**
     * 这是一个方法说明
     * @throws MyException
     */
    public void f() throws MyException {
        System.out.println("抛出异常开始....");
            throw new MyException();
    }


    public static void main(String[] args){

        try {
            new TestException().f();
            new TestException().methodA("something");
        } catch (MyException e) {
            e.printStackTrace();
        } finally {
            System.out.println("捕获异常结束..");
        }
    }
    public void test() {

    }
    public void methodA(String test) {

    }
}
