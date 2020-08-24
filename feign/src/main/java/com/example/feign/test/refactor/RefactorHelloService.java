package com.example.feign.test.refactor;

import com.my.feignapi.test.HelloService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient("hello")
public interface RefactorHelloService extends HelloService{
}
