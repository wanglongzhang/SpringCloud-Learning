package com.didispace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 翟永超
 * @create 2017/4/15.
 * @blog http://blog.didispace.com
 */
@RestController
public class DcController {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate restTemplate;

    @Value("${service.provider.name}")
    String serviceProviderName;

    @GetMapping("/consumer")
    public String dc() {
        ServiceInstance serviceInstance = loadBalancerClient.choose(serviceProviderName);

        String url = serviceInstance.getUri().toString() + "/dc";
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }

}
