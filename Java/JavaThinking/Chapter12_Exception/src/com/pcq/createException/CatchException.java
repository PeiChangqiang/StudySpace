package com.pcq.createException;

public class CatchException  {
    public static void main(String[] args) {
      /*  try {
            g();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            h();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        try {
            e();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void e() {
        try {
            f();
        } catch (Exception e) {
            e.printStackTrace();
            throw new IndexOutOfBoundsException("我捕获了空指针异常，但是我却抛出数组下标越界异常。这样就无法定位最初始的异常，因为我篡改了异常信息");
        }
    }

    public static void f() throws Exception {
        throw new NullPointerException("this is a nullpointer Exception");
    }

    public static void g() throws Exception {
        try {
            f();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void h() throws Exception {
        try {
            f();
        } catch (Exception e) {
            e.printStackTrace();
            throw (Exception) e.fillInStackTrace();
        }
    }
}

