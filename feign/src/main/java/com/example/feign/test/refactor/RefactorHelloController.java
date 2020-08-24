package com.example.feign.test.refactor;

import com.example.feign.test.hello.HelloService;
import com.my.feignapi.test.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefactorHelloController {

    @Autowired
    private RefactorHelloService refactorHelloService;
    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    public String hello1(){
        StringBuilder sb = new StringBuilder();
        sb.append(helloService.hello()).append("<br>");
        sb.append(refactorHelloService.hello1("good")).append("<br>");
        sb.append(refactorHelloService.hello2("good",30)).append("<br>");
        sb.append(refactorHelloService.hello3(new User("good",30))).append("<br>");
        return sb.toString();
    }

}
