package br.com.achimid.webapplication2;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
public class WebApplicationUtils {

    @Lazy
    @Autowired
    private EurekaClient discoveryClient;

    private String serviceUrl(String appName) {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka(appName, false);
        return instance.getHomePageUrl();
    }

    public String getWebApplicationUrl() {
        return this.serviceUrl("WEB-APPLICATION");
    }
}
