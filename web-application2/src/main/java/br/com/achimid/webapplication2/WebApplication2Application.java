package br.com.achimid.webapplication2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableEurekaClient
@EnableCircuitBreaker
@SpringBootApplication
@EnableHystrixDashboard
@RequestMapping("/hello")
public class WebApplication2Application {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication2Application.class, args);
	}

	@Autowired
	private WebApplicationService webApplicationService;

	@GetMapping
	public String hello() {
		return webApplicationService.getHello();
	}


}
