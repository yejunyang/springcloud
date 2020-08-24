package com.example.feign.test.hello;

import com.example.feign.test.User;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;


    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return helloService.hello();
    }

    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    public String hello1(){
        StringBuilder sb = new StringBuilder();
        sb.append(helloService.hello()).append("<br>");
        sb.append(helloService.hello1("good")).append("<br>");
        sb.append(helloService.hello2("good",30)).append("<br>");
        sb.append(helloService.hello3(new User("good",30))).append("<br>");
        return sb.toString();
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return helloService.test();
    }
}
