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
}
