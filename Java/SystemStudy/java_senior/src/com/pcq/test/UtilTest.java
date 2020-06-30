package com.pcq.test;

import com.pcq.util.StringUtil;
import org.junit.Test;

public class UtilTest {
    @Test
    public void testInitCap() {
        String str = StringUtil.initCap("name");
        System.out.println(str);
    }
}
