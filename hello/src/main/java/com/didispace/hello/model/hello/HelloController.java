package com.didispace.hello.model.hello;


import jdk.internal.dynalink.support.AutoDiscovery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

@RestController
public class HelloController {

    private final Logger logger = Logger.getLogger(getClass().toString());

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/hello")
    public String hello() throws InterruptedException {
        int sleep = new Random().nextInt(3000);
        logger.info("sleepTime : " + sleep);
        Thread.sleep(sleep);
        /*for( String s :  discoveryClient.getServices()){
            System.out.println("services " + s);
            List<ServiceInstance> serviceInstances =  discoveryClient.getInstances(s);
            for(ServiceInstance si : serviceInstances){
                StringBuilder stringBuilder= new StringBuilder();
                stringBuilder.append("[===================================================================\n");
                stringBuilder.append("** services : " + s + ", : getHost() = " + si.getHost()+"\n");
                stringBuilder.append("** services : " + s + ", : getPort() = " + si.getPort()+"\n");
                stringBuilder.append("** services : " + s + ", : getServiceId() = " + si.getServiceId()+"\n");
                stringBuilder.append("** services : " + s + ", : getUri() = " + si.getUri()+"\n");
                stringBuilder.append("** services : " + s + ", : getMetadata() = " + si.getMetadata()+"\n");
                stringBuilder.append("===================================================================]");
                logger.info(stringBuilder.toString());
            }
        }*/
        return "hello world";
    }

    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    public String hello1(@RequestParam String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    public User hello2(@RequestHeader String name,@RequestHeader int age) {
        return new User(name,age);
    }


    @RequestMapping(value = "/hello3",method = RequestMethod.POST)
    public String hello3(@RequestBody User user) {
        return "Hello " + user.getName() + ", " + user.getAge();
    }

}
