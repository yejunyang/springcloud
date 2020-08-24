package com.didispace.hello.model.hello.configTest;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * @RefreshScope动态刷新test
 */
@RefreshScope
@RestController
public class ConfigTest {

    private final Logger logger = Logger.getLogger(getClass().toString());

    @Value("${hello.test}")
    private String test;

    @RequestMapping("/test")
    public String getValue(){
        logger.info(test);
        return this.test;
    }
}
