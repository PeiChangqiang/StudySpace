package com.pcq.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AutoconfigApplicationTests {

    @Test
    void contextLoads() {
      int num = 2147483647;
      num += 2L;
        System.out.println(num);
    }


}
