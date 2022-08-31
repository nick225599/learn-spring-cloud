package org.example.springcloud.payment.order;

//import org.example.springcloud.payment.ribbonrule.RandomRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.ribbon.RibbonClient;
//import org.springframework.cloud.netflix.ribbon.RibbonClients;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
//@RibbonClient(name="CLOUD-PAYMENT-SERVICE", configuration = RandomRuleConfig.class)
public class Order80Eureka {
    public static void main(String[] args) {
        SpringApplication.run(Order80Eureka.class, args);
    }
}
