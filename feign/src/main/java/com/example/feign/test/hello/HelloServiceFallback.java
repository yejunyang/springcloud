package com.example.feign.test.hello;

import com.example.feign.test.User;
import org.springframework.stereotype.Component;


/**
 * https://blog.csdn.net/mobiusstrip/article/details/83859300
 */
@Component
public class HelloServiceFallback implements HelloService {
    @Override
    public String hello() {
        return "hystrix error";
    }

    @Override
    public String hello1(String name) {
        return "hystrix error";
    }

    @Override
    public User hello2(String name, int age) {
        return new User("error",0);
    }

    @Override
    public String hello3(User user) {
        return "hystrix error";
    }

    @Override
    public String test() {
        return "hystrix test error";
    }
}
