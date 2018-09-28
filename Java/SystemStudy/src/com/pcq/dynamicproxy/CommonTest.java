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

    @Test
    public void testDutyChain() {
        MakeDinner proxy1 = (MakeDinner) InterceptorJdkProxy.bind(new MakeDinnerImpl(), "com.pcq.dynamicproxy.Interceptor1");
        MakeDinner proxy2 = (MakeDinner) InterceptorJdkProxy.bind(proxy1, "com.pcq.dynamicproxy.Interceptor2");
        MakeDinner proxy3 = (MakeDinner) InterceptorJdkProxy.bind(proxy2, "com.pcq.dynamicproxy.Interceptor3");
        proxy3.makeSoup("筒骨汤");

    }

  /*  @Test
    public void testCglibProxy() {
        CglibProxy cProxy = new CglibProxy();
        MakeDinnerImpl md = (MakeDinnerImpl) cProxy.getProxy(MakeDinnerImpl.class);
        md.makeSoup("排骨汤");
    }*/
}
