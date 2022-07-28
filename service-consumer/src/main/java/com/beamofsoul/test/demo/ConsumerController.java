package com.beamofsoul.test.demo;

import com.beamofsoul.test.demo.feign.EchoFeign;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    private final RestTemplate restTemplate;
    private final EchoFeign echoFeign;

    public ConsumerController(RestTemplate restTemplate, EchoFeign echoFeign) {
        this.restTemplate = restTemplate;
        this.echoFeign = echoFeign;
    }

    @GetMapping("call")
    public String call() {
//        return restTemplate.getForObject("http://localhost:8081/echo/call_me", String.class, Maps.newHashMap());
//        return restTemplate.getForObject("http://service-provider/echo/call_me", String.class);
        return echoFeign.echo("call_me");
    }
}
