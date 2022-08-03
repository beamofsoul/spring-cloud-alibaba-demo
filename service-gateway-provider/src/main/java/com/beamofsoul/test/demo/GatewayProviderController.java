package com.beamofsoul.test.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayProviderController {

    @GetMapping("/echo/{string}")
    public String echo(@PathVariable String string) {
        System.out.print("#");
        return "Hello Nacos Discovery " + string;
    }

    @GetMapping("/divide")
    public String divide(@RequestParam Integer a, @RequestParam Integer b) {
        System.out.print("#");
        return String.valueOf(a / b);
    }
}
