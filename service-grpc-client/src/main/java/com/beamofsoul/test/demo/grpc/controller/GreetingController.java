package com.beamofsoul.test.demo.grpc.controller;

import com.beamofsoul.test.demo.grpc.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/hi/{name}")
    public String hi(@PathVariable String name) {
        System.out.print("#");
        return greetingService.sayHello(name);
    }
}
