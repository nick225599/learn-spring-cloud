package org.example.servers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient("provider-consul")
public interface EchoService {

    @GetMapping("/index/echo/{msg}")
    String echo(@PathVariable("msg") String msg);

}
