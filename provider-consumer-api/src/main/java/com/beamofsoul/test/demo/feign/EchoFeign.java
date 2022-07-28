package com.beamofsoul.test.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-provider", fallback = EchoFeign.EchoFeignFallback.class)
public interface EchoFeign {

    @GetMapping("/echo/{string}")
    String echo(@PathVariable(value = "string") String string);

    @Component
    class EchoFeignFallback implements EchoFeign {

        public String echo(String string) {
            return "echo fallback";
        }
    }
}
