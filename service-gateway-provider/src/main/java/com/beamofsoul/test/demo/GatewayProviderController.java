package com.beamofsoul.test.demo;

import com.beamofsoul.test.demo.feign.EchoFeign;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayProviderController {

    private EchoFeign echoFeign;

    public GatewayProviderController(EchoFeign echoFeign) {
        this.echoFeign = echoFeign;
    }

    @GetMapping("/echo/{string}")
    public String echo(@PathVariable String string) {
        System.out.print("#");
        return "Hello Nacos Discovery " + string;
    }

    @GetMapping("/flow")
    public String flow() {
        return "FLOW";
    }

    @GetMapping("/degrade")
    public String degrade(@RequestParam Integer id) throws InterruptedException {
        if (id % 2 == 0) { // 模拟时长，超过则降级场景
            Thread.sleep(2000);
//            throw new RuntimeException("异常数测试");
        }
        System.out.println("#");
        return "DEGRADE";
    }

    @GetMapping("/divide")
    public String divide(@RequestParam Integer a, @RequestParam Integer b) {
        System.out.print("#");
        return String.valueOf(a / b);
    }

    @GetMapping("/internal/{string}")
    public String internal(@PathVariable String string) {
        String txt = this.echoFeign.echo(string);
        return "Internal call: " + txt;
    }
}
