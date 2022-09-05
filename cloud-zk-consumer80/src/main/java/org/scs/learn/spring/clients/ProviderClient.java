package org.scs.learn.spring.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "zk-provider", fallback = Object.class)
@Component
public interface ProviderClient {

    @GetMapping("/provider/echo/performance/{msg}")
    String echoPerformance(@PathVariable("msg") String msg);

    @GetMapping("/provider/echo/normal/{msg}")
    String echoNormal(@PathVariable("msg") String msg);
}
