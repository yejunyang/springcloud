package com.didispace.hello.model.hello.refactor;

import com.my.feignapi.test.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefactorController implements com.my.feignapi.test.HelloService {


    @Override
    public String hello1(@RequestParam("name") String name) {
        return "refactor hello "+ name;
    }

    @Override
    public User hello2(@RequestHeader("name") String name,@RequestHeader("age") int age) {
        return new User(name,age);
    }

    @Override
    public String hello3(@RequestBody User user) {
        return "refactor hello "+user.getName() +", "+ user.getAge();
    }
}
