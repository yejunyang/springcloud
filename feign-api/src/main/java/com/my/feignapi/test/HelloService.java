package com.my.feignapi.test;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/refactor")
public interface HelloService {

    @RequestMapping(value = "/hello4",method = RequestMethod.GET)
    public String hello1(@RequestParam("name") String name);

    @RequestMapping(value = "/hello5",method = RequestMethod.GET)
    public User hello2(@RequestHeader("name") String name, @RequestHeader("age") int age);

    @RequestMapping(value = "/hello6",method = RequestMethod.POST)
    public String hello3(@RequestBody User user);
}
