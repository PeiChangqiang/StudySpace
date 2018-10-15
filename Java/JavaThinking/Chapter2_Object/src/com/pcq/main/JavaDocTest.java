package com.pcq.main;

/**
 * 这是一个测试如何规范代码注释文档，以便
 * 让javadoc能够生成规范html格式的代码注
 * 释文档的测试类
 */
public class JavaDocTest {
    public String id;
    /**这是用户名*/
    public String userName;
    /**这是年龄*/
    protected Integer age;

    /**private修饰的字段默认不会被javadoc生成注释，除非加上-private标记*/
    private String passWord;

    /**这是一个默认的
     * 构造函数。
     */
    public JavaDocTest() {

    }

    /**
     * 这是一个测试方法
     * @param x 字符串x
     */
    public void docTest(String x) {

    }
}
