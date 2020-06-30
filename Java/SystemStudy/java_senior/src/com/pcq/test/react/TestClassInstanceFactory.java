package com.pcq.test.react;

import com.pcq.entity.Emp;
import com.pcq.react.simplebean.ClassInstanceFactory;
import org.junit.Test;

public class TestClassInstanceFactory {

    @Test
    public void testCreate() {
        Emp emp = ClassInstanceFactory.create(Emp.class, "empno:23043|name:pcq|job:java|salary:20000.00|age:27");
        System.out.println(emp);
    }
}
