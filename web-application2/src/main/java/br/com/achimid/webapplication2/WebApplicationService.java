package br.com.achimid.webapplication2;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class WebApplicationService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    WebApplicationUtils utils;

    @HystrixCommand(fallbackMethod = "getHelloFallback")
    public String getHello() {
        return this.restTemplate.getForObject(URI.create(utils.getWebApplicationUrl() + "hello"), String.class);
    }

    public String getHelloFallback() {
        return "Hello Fallback";
    }
}
