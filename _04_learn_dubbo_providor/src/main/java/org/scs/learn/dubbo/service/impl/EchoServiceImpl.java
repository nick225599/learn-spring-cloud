package org.scs.learn.dubbo.service.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.example.springcloud.service.EchoService;

@DubboService
public class EchoServiceImpl  implements EchoService {
    @Override
    public String echo(String msg) {
        return msg;
    }
}
