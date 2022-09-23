package org.scs.learn.dubbo.service.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.example.springcloud.service.HelloService;

@DubboService
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "hello, " + name;
    }
}
