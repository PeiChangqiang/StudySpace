package com.pcq.slf4j;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Slf4jApplicationTests {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    void contextLoads() {
        //日志级别，由低到高，可以调整日志的级别，日志就会在该级别及更高的级别生效。
        logger.trace("trace日志。。。");
        logger.debug("debug日志。。。");
        logger.info("info日志。。。");
        logger.warn("warn日志。。。");
        logger.error("error日志。。。");
    }

}
