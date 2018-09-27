package com.pcq.dynamicproxy;

import org.junit.Test;

public class CommonTest {

    @Test
    public void testJdkProxy() {
        JdkProxy jdkProxy = new JdkProxy();
        MakeDinner makeDinner = (MakeDinner) jdkProxy.getTarget(new MakeDinnerImpl());
        makeDinner.makeDinner();
        makeDinner.makeSoup("参数");
    }

    @Test
    public void testInterceptorJdkProxy() {
        MakeDinner proxy = (MakeDinner) InterceptorJdkProxy.bind(new MakeDinnerImpl(), "com.pcq.dynamicproxy.MyInterceptor");
        proxy.makeDinner();
    }
}
