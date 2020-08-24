package com.example.feign.config;

import com.netflix.hystrix.Hystrix;
import com.netflix.hystrix.HystrixCommandKey;
import feign.Request;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class Config {

    public static int connectTimeOutMillis = 1000;//超时时间
    public static int readTimeOutMillis = 2000;


    /**
     * 配置是全局的超时处理
     * @return
     */
    @Bean
    public Request.Options options() {
        return new Request.Options(connectTimeOutMillis, readTimeOutMillis);
    }

    /**
     * 配置是全局的重试次数
     * @return
     */
    @Bean
    public Retryer feignRetryer() {
        Retryer retryer = new Retryer.Default(100, 1000, 4);
        return retryer;
    }

}
