package com.example.feign.test.hello;

import com.example.feign.test.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(value = "hello",fallback = HelloServiceFallback.class)
public interface HelloService {

    @RequestMapping("/hello")
    String hello();

    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    public String hello1(@RequestParam("name") String name);

    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    public User hello2(@RequestHeader("name") String name, @RequestHeader("age") int age);

    @RequestMapping(value = "/hello3",method = RequestMethod.POST)
    public String hello3(@RequestBody User user);

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String test();
}
