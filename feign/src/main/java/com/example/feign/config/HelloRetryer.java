package com.example.feign.config;

import feign.Request;
import feign.RetryableException;
import feign.Retryer;
import org.springframework.context.annotation.Bean;

/**
 * 可以单独配置指定服务
 * 在application.properties文件中指定配置重试次数
 */
public class HelloRetryer implements Retryer {

    @Override
    public void continueOrPropagate(RetryableException e) {
            e.method();
            e.retryAfter();
    }

    @Override
    public Retryer clone() {
        Retryer retryer = new Retryer.Default(100, 1000, 3);
        return retryer;
    }
}
