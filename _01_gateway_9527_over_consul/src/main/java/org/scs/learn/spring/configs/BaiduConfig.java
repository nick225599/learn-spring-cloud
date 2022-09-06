package org.scs.learn.spring.configs;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaiduConfig {

    @Bean
    public RouteLocator rlBaidu01(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();

        routes.route("baidu1", r -> r.path("/baidu").uri("https://news.baidu.com/guonei")).build();

        return routes.build();
    }
}
