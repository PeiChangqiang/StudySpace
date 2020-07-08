package com.pcq.test.react;

import com.pcq.inter.IMsgService;
import com.pcq.react.proxypattern.MsgHandler;
import com.pcq.react.proxypattern.MyInvocationHandler;
import org.junit.Test;

public class TestMyInvocationHandler {
    @Test
    public void testProxy() {
        IMsgService imsg = (IMsgService)new MyInvocationHandler().bind(new MsgHandler());
        imsg.send();
    }
}
